package com.fpmislata.MoviesStore.controller.webModel.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpmislata.MoviesStore.controller.webModel.actor.ActorCollection;
import com.fpmislata.MoviesStore.controller.webModel.director.DirectorCollection;

import java.util.List;

public record MovieDetail(
        String code,
        String title_es,
        String image,
        List<String> genres,
        String synopsis_es,
        String contentRating,
        @JsonProperty("actors")List<ActorCollection> actorCollection,
        @JsonProperty("directors")DirectorCollection directorCollection
        ) {
}
