package org.example.ecommerce.service;

import org.example.ecommerce.entity.Provider;
import org.example.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ecommerce.repository.ProviderRepository;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    public Provider createProvider(Provider provider) {return providerRepository.save(provider);}
    public List<Provider> getAllProvider() { return providerRepository.findAll();}
    public User getProviderByID(int id){return providerRepository.findById(id).get();}
    public User UpdateProvider(Provider provider){return providerRepository.saveAndFlush(provider);}
    public void deleteProvider(int id){ providerRepository.deleteById(id);}
}
