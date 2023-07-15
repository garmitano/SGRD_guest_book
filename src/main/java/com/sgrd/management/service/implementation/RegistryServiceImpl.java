package com.sgrd.management.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.Registry;
import com.sgrd.management.repository.IRegistryRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistryServiceImpl implements IServiceBase<Registry> {

    @Autowired
    private IRegistryRepository repository;

    @Override
    @Transactional
    public List<Registry> listAll() throws Exception {
        try {
            List<Registry> registries = repository.findAll();
            return registries;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Registry addNewOne(Registry registry) throws Exception {
        try {
            return repository.save(registry);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Registry getOneById(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOneById'");
    }

    @Override
    public Registry updateOne(Registry entity, Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
    }

    @Override
    public void deleteOne(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOne'");
    }

}
