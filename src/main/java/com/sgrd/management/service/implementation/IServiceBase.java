package com.sgrd.management.service.implementation;

import java.util.List;

public interface IServiceBase<E> {
    List<E> listAll() throws Exception;

    E addNewOne(E entity) throws Exception;

    E getOneById(Long id) throws Exception;

    E updateOne(E entity, Long id) throws Exception;

    void deleteOne(Long id) throws Exception;
}
