package io.nazar.songs_project.domain.repository;

import io.nazar.songs_project.domain.model.Singer;

import java.util.List;

public interface SingerRepository {
    List<Singer> findAllById(List<Long> ids);
}
