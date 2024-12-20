package com.fpmislata.MoviesStore.controller.admin;

import com.fpmislata.MoviesStore.controller.admin.webModel.movie.MovieCollectionResponse;
import com.fpmislata.MoviesStore.controller.common.PaginatedResponse;
import com.fpmislata.MoviesStore.controller.admin.webModel.movie.MovieMapper;
import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieCountUseCase;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieFindByCodeUseCase;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieGetAllUseCase;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieInsertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(MovieAdminController.URL)
public class MovieAdminController {
    public static final String URL = "/api/admin/movies";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final MovieGetAllUseCase movieGetAllUseCase;
    private final MovieFindByCodeUseCase movieFindByCodeUseCase;
    private final MovieCountUseCase movieCountUse;
    private final MovieInsertUseCase movieInsertUseCase;
    /*
    private final MovieInsertActorsUseCase movieInsertActorsUseCase;
    private final MovieInsertGenresUseCase movieInsertGenresUseCase;
    */
    @GetMapping
    public ResponseEntity<PaginatedResponse<MovieCollectionResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ){
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        PageWithCount<Movie> moviePageWithCount = movieGetAllUseCase.execute(page -1, pageSize);
        PaginatedResponse<MovieCollectionResponse> response = new PaginatedResponse<>(
                moviePageWithCount
                        .getData()
                        .stream()
                        .map(MovieMapper.INSTANCE::toMovieCollection)
                        .toList(),
                moviePageWithCount.getCount(),page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping("/{code}")
    public ResponseEntity<Movie> getByCode(@PathVariable  String code){
        Movie movie = movieFindByCodeUseCase.execute(code);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Movie> insert(@RequestBody Movie movie){
        movieInsertUseCase.execute(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
