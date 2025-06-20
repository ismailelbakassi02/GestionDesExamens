package com.sge.service;

import com.sge.model.Inscription;
import com.sge.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository repository;

    public List<Inscription> findAll() {
        return repository.findAll();
    }

    public Inscription save(Inscription inscription) {
        return repository.save(inscription);
    }
}
