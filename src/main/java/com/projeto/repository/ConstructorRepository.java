package com.projeto.repository;

import com.projeto.model.Constructor;
import com.projeto.model.response.Relatorio1Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    Optional<Constructor> findConstructorByNameOrConstructorref(String name, String constructorref);

    @Procedure(procedureName = "numero_vitorias_escuderia")
    int getTotalVictoriesByConstructor(String p_nome_escuderia);

    @Procedure(procedureName = "quantidade_pilotos_escuderia")
    int getTotalDriversByConstructor(String p_nome_escuderia);

    @Query(value = "select distinct count(name) from constructors", nativeQuery = true)
    int countAllConstructor();

    @Query(value = "select count(year) from seasons", nativeQuery = true)
    int countAllSeason();

    @Query(value = "select * from get_historico_escuderia(?1)", nativeQuery = true)
    Map<String,?> getConstructorHistoric(String p_nome_escuderia);

}
