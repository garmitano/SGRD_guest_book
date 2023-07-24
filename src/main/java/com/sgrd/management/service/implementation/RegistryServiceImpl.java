package com.sgrd.management.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.Guest;
import com.sgrd.management.model.Registry;
import com.sgrd.management.model.RegistryDetail;
import com.sgrd.management.repository.IGuestRepository;
import com.sgrd.management.repository.IRegistryDetailRepository;
import com.sgrd.management.repository.IRegistryRepository;

import jakarta.transaction.Transactional;

@Service
public class RegistryServiceImpl implements IServiceBase<Registry> {

    @Autowired
    private IRegistryRepository repository;

    @Autowired
    private IRegistryDetailRepository rDetailRepository;

    @Autowired
    private IGuestRepository gRepository;

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

    public Registry addDetails(List<Long> listIdGuest, Registry registry) throws Exception {
        try {
            for (Long idGuest : listIdGuest) {
                System.out.println(idGuest);
                Guest tmpGuest = gRepository.getReferenceById(idGuest);
                RegistryDetail registryDetail = new RegistryDetail(null, tmpGuest, registry);
                rDetailRepository.save(registryDetail);
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
