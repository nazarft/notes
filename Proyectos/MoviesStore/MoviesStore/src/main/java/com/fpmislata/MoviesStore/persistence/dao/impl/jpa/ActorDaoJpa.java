package com.fpmislata.MoviesStore.persistence.dao.impl.jpa;

import com.fpmislata.MoviesStore.domain.model.Actor;
import com.fpmislata.MoviesStore.persistence.dao.ActorDao;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.ActorEntity;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.mapper.ActorJpaMapper;
import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository.ActorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("actorDaoJpa")
@Primary
@RequiredArgsConstructor
public class ActorDaoJpa implements ActorDao {
    private final ActorJpaRepository actorJpaRepository;
    @Override
    public List<Actor> getByMovieId(Long idMovie) {
        return actorJpaRepository.findByMoviesId(idMovie)
                .stream()
                .map(actor -> ActorJpaMapper.INSTANCE.toActor(actor))
                .toList();
    }

    @Override
    public List<Actor> findAllById(Long[] ids) {
        return actorJpaRepository.findAllById(List.of(ids))
                .stream()
                .map(actor -> ActorJpaMapper.INSTANCE.toActor(actor))
                .toList();
    }

    @Override
    public List<Actor> getAll() {
        return actorJpaRepository.findAll()
                .stream()
                .map(actor -> ActorJpaMapper.INSTANCE.toActor(actor))
                .toList();
    }

    @Override
    public List<Actor> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ActorEntity> actorEntities = actorJpaRepository.findAll(pageable);
        return actorEntities.getContent()
                .stream()
                .map(actor -> ActorJpaMapper.INSTANCE.toActor(actor))
                .toList();
    }

    @Override
    public Optional<Actor> findById(Long id) {
        return actorJpaRepository.findById(id)
                .map(actor -> ActorJpaMapper.INSTANCE.toActor(actor));
    }

    @Override
    public long insert(Actor actor) {
        ActorEntity actorEntity = actorJpaRepository
                .save(ActorJpaMapper.INSTANCE.toActorEntity(actor));
        return actorEntity.getId();
    }

    @Override
    public void update(Actor actor) {
        actorJpaRepository.save(ActorJpaMapper.INSTANCE.toActorEntity(actor));
    }

    @Override
    public void delete(Long id) {
        actorJpaRepository.deleteById(id);
    }

    @Override
    public int count() {
        return (int) actorJpaRepository.count();
    }

    @Override
    public void save(Actor actor) {
        actorJpaRepository.save(ActorJpaMapper.INSTANCE.toActorEntity(actor));
    }
}
