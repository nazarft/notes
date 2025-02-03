package io.nazar.songs_project.persistence.dao.impl.jpa;

import io.nazar.songs_project.domain.model.Editorial;
import io.nazar.songs_project.persistence.dao.EditorialDao;
import io.nazar.songs_project.persistence.dao.impl.jpa.mapper.EditorialJpaMapper;
import io.nazar.songs_project.persistence.dao.impl.jpa.repository.EditorialJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EditorialDaoJpa implements EditorialDao {
    private final EditorialJpaRepository editorialJpaRepository;
    @Override
    public Optional<Editorial> findById(Long id) {
        return editorialJpaRepository.findById(id).map(editorialEntity -> EditorialJpaMapper.toDomain(editorialEntity));
    }
}
