package com.manning.sbip.ch03.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S entity);

    Iterable<T> findAll();
}
