package com.sstu.work.service;

import com.sstu.work.model.Country;
import com.sstu.work.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAll(){
        return countryRepository.getAll();
    }

}

