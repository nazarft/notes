package io.nazar.songs_project.domain.usecase.editorial.impl;

import io.nazar.songs_project.domain.model.Editorial;
import io.nazar.songs_project.domain.repository.EditorialRepository;
import io.nazar.songs_project.domain.usecase.editorial.EditorialFindByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditorialFindByIdService implements EditorialFindByIdUseCase {
    private final EditorialRepository editorialRepository;
    @Override
    public Editorial execute(Long id) {
        return editorialRepository.findById(id).orElse(null);
    }
}
