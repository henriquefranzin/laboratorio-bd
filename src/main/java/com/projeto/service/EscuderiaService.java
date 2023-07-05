package com.projeto.service;

import com.projeto.model.response.Relatorio3Response;
import com.projeto.model.response.Relatorio4Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EscuderiaService {

    private EntityManager entityManager;

    @Autowired
    public EscuderiaService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Relatorio3Response> getConstructorAndVictories(String p_constructorref) {
        StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("ESC_REL3");
        spq.setParameter(2, p_constructorref);
        spq.execute();
        return spq.getResultList();
    }

    @Transactional
    public List<Relatorio4Response> getStatusAndQuantities(String p_constructorref) {
        StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("ESC_REL4");
        spq.setParameter(2, p_constructorref);
        spq.execute();
        return spq.getResultList();
    }
}
