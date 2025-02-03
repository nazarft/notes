package io.nazar.songs_project.persistence.dao;

import io.nazar.songs_project.domain.model.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAllById(List<Long> ids);
}
