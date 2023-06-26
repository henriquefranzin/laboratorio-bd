package com.projeto.service;

import com.projeto.model.response.Relatorio1Response;
import com.projeto.model.response.Relatorio3Response;
import com.projeto.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {

    private ConstructorRepository constructorRepository;
    private EntityManager entityManager;

    @Autowired
    public AdminService(ConstructorRepository constructorRepository, EntityManager entityManager) {
        this.constructorRepository = constructorRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Relatorio1Response> getResultByStatus(){
        StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("getResultByStatus");
        spq.execute();
        return spq.getResultList();
    }
}
