package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface AdminInterface<T>{
    List<T> getAll();
    ResponseEntity<T> getById(Object id);
    ResponseEntity<T> save(T t);
    ResponseEntity<Void> delete(Long id);
    ResponseEntity<T> update(Object id, T t);
}