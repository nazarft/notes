package com.fpmislata.MoviesStore.controller.user;

import com.fpmislata.MoviesStore.controller.common.PaginatedResponse;
import com.fpmislata.MoviesStore.controller.user.webModel.movie.MovieCollectionResponse;
import com.fpmislata.MoviesStore.controller.user.webModel.movie.MovieResponse;
import com.fpmislata.MoviesStore.controller.user.webModel.movie.MovieMapper;
import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.model.PageWithCount;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieCountUseCase;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieFindByCodeUseCase;
import com.fpmislata.MoviesStore.domain.usecase.movie.MovieGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MovieUserController.URL)
public class MovieUserController {
    public static final String URL = "/api/movies";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final MovieGetAllUseCase movieGetAllUseCase;
    private final MovieCountUseCase movieCountUse;
    private final MovieFindByCodeUseCase movieFindByCodeUseCase;
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
    public ResponseEntity<MovieResponse> findByIsbn(@PathVariable String code){
        Movie movie = movieFindByCodeUseCase.execute(code);
        MovieResponse movieResponse = MovieMapper.INSTANCE.toMovieDetail(movie);
        return new ResponseEntity<>(movieResponse, HttpStatus.OK);
    }


}
