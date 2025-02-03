package io.nazar.songs_project.domain.service;

import io.nazar.songs_project.domain.model.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAllById(List<Singer> singers );
}
