package io.nazar.songs_project.domain.service.impl;

import io.nazar.songs_project.domain.model.Singer;
import io.nazar.songs_project.domain.repository.SingerRepository;
import io.nazar.songs_project.domain.service.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SingerServiceImpl implements SingerService {
    private final SingerRepository singerRepository;
    @Override
    public List<Singer> findAllById(List<Singer> singers) {
        List<Singer> foundSingers = singerRepository.findAllById(
                List.of(singers
                        .stream()
                        .map(Singer::getId)
                        .toArray(Long[]::new))
        );
        if (foundSingers.size() != singers.size()) {
            throw new IllegalArgumentException("Some singers were not found");
        }
        return foundSingers;

    }
}
