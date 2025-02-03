package io.nazar.songs_project.persistence.dao.impl.jpa.mapper;


import io.nazar.songs_project.domain.model.Editorial;
import io.nazar.songs_project.persistence.dao.impl.jpa.entity.EditorialEntity;

public class EditorialJpaMapper {
    public static Editorial toDomain(EditorialEntity editorialEntity) {
        return new Editorial(
                editorialEntity.getId(),
                editorialEntity.getName(),
                editorialEntity.getCountry());
    }
    public static EditorialEntity toEntity(Editorial editorial) {
        return new EditorialEntity(
                editorial.getId(),
                editorial.getName(),
                editorial.getCountry());
    }
}
