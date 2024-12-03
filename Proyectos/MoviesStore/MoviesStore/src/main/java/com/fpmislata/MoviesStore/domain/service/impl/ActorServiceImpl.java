package com.fpmislata.MoviesStore.domain.service.impl;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.domain.repository.ActorRepository;
import com.fpmislata.MoviesStore.domain.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    @Override
    public List<Actor> getByMovieId(Long idMovie) {
        return actorRepository.getByMovieId(idMovie);
    }

    @Override
    public List<Actor> findAllById(List<Actor> actors) {
        List<Actor> foundActors = actorRepository.findAllById(
                actors.stream()
                        .map(actor -> actor.getId())
                        .toArray(size -> new Long[size])
        );
        if(foundActors.size() != actors.size()){
            throw new RuntimeException("Some actors were not found");
        }
        return foundActors;
    }
}
