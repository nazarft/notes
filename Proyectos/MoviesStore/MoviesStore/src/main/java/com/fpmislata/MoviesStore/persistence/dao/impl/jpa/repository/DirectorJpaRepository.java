package com.fpmislata.MoviesStore.persistence.dao.impl.jpa.repository;

import com.fpmislata.MoviesStore.persistence.dao.impl.jpa.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorJpaRepository extends JpaRepository<DirectorEntity, Long> {

}
