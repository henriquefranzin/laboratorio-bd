package com.projeto.repository;

import com.projeto.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.Map;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByForename(String forename);

    @Query(value = "select * from get_piloto_por_escuderia_e_driverref(?1,?2)", nativeQuery = true)
    Map<String,?> getDriverByForenameAndConstructorref(String p_driverref, String constructorref);

    @Query(value = "select * from get_historico_piloto(?1)", nativeQuery = true)
    Map<String,?> getDriverHistoric(String p_driverref);

    @Procedure(procedureName = "numero_vitorias_piloto")
    int getTotalVictoriesByDriver(String p_driverref);

    @Query(value = "select distinct count(driverid) from driver", nativeQuery = true)
    int countAll();

    @Query(value = "select count(raceid) from races", nativeQuery = true)
    int countAllRace();
}
