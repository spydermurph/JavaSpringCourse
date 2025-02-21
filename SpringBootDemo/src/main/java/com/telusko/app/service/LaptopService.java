package com.telusko.app.service;

import com.telusko.app.repository.LaptopRepository;
import com.telusko.app.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repository;

    public void addLaptop(Laptop laptop){
        System.out.println("laptop method called in service");
        repository.save(laptop);
    }

    public boolean isGoodForProgramming(Laptop laptop){
        return true;
    }
}
