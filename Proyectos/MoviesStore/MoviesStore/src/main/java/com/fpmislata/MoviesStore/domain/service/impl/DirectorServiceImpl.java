package com.fpmislata.MoviesStore.domain.service.impl;

import com.fpmislata.MoviesStore.domain.model.Director;
import com.fpmislata.MoviesStore.domain.repository.DirectorRepository;
import com.fpmislata.MoviesStore.domain.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;
    @Override
    public Optional<Director> findById(Long id) {
        return directorRepository.findById(id);
    }
}
