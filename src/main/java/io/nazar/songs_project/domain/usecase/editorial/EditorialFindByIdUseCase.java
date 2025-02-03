package io.nazar.songs_project.domain.usecase.editorial;


import io.nazar.songs_project.domain.model.Editorial;

public interface EditorialFindByIdUseCase {
    Editorial execute(Long id);
}
