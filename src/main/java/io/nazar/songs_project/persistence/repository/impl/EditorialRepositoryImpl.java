package io.nazar.songs_project.persistence.repository.impl;
import io.nazar.songs_project.domain.model.Editorial;
import io.nazar.songs_project.domain.repository.EditorialRepository;
import io.nazar.songs_project.persistence.dao.EditorialDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EditorialRepositoryImpl implements EditorialRepository {

    private final EditorialDao editorialDao;
    @Override
    public Optional<Editorial> findById(Long id) {
        return editorialDao.findById(id);
    }
}
