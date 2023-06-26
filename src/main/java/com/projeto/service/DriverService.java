package com.projeto.service;

import com.projeto.model.response.Relatorio4Response;
import com.projeto.model.response.Relatorio5Response;
import com.projeto.model.response.Relatorio6Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverService {

    private EntityManager entityManager;

    @Autowired
    public DriverService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Relatorio5Response> getYearAndRaceName(int driverId) {
        StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("PIL_REL5");
        spq.setParameter(2, driverId);
        spq.execute();
        return spq.getResultList();
    }

    public List<Relatorio6Response> getStatusAndQuantity(int driverId) {
        StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("PIL_REL6");
        spq.setParameter(2, driverId);
        spq.execute();
        return spq.getResultList();
    }
}
