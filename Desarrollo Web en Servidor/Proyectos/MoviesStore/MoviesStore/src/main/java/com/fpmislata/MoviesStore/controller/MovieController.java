package com.fpmislata.MoviesStore.controller;

import com.fpmislata.MoviesStore.controller.webModel.movie.MovieCollection;
import com.fpmislata.MoviesStore.controller.webModel.movie.MovieDetail;
import com.fpmislata.MoviesStore.controller.webModel.movie.MovieMapper;
import com.fpmislata.MoviesStore.domain.model.Movie;
import com.fpmislata.MoviesStore.domain.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieCollection> getAll(){
        List<MovieCollection> movieCollections = movieService
                .getAll()
                .stream()
                .map(MovieMapper.INSTANCE::toMovieCollection)
                .toList();
        return movieCollections;
    }
    @GetMapping("/{code}")
    public MovieDetail getMovieByCode(@PathVariable String code){
        MovieDetail movieDetail = MovieMapper.INSTANCE.toMovieDetail(movieService.getByCode(code));
        return movieDetail;
    }

}
