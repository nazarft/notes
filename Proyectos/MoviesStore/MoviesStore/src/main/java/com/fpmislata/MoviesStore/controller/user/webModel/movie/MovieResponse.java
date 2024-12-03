package com.fpmislata.MoviesStore.controller.user.webModel.movie;

import com.fpmislata.MoviesStore.controller.user.webModel.actor.ActorCollectionResponse;
import com.fpmislata.MoviesStore.controller.user.webModel.contentRating.ContentRatingCollectionResponse;

import java.util.List;

public record MovieResponse(
        String code,
        String title,
        String synopsis,
        String image,
        String director,
        List<String> genres,
        ContentRatingCollectionResponse contentRating,
        List<ActorCollectionResponse> actors
) {
}
