package com.projeto.controller;

import com.projeto.mapper.ConstructorMapper;
import com.projeto.model.request.ConstructorRequest;
import com.projeto.model.response.Relatorio3Response;
import com.projeto.model.response.Relatorio4Response;
import com.projeto.repository.ConstructorRepository;
import com.projeto.repository.DriverRepository;
import com.projeto.service.EscuderiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/escuderia")
public class EscuderiaController {
    public DriverRepository driverRepository;
    public ConstructorRepository constructorRepository;

    public EscuderiaService escuderiaService;

    @Autowired
    public EscuderiaController(DriverRepository driverRepository, ConstructorRepository constructorRepository,
                               EscuderiaService escuderiaService) {
        this.driverRepository = driverRepository;
        this.constructorRepository = constructorRepository;
        this.escuderiaService = escuderiaService;
    }

    public EscuderiaController() {
    }

    @GetMapping("/forename")
    @Secured("Escuderia")
    public Map<String,?> getByForenameAndConstructorref(@RequestParam String p_driverref, @RequestParam String p_constructorref){
        return driverRepository.getDriverByForenameAndConstructorref(p_driverref, p_constructorref);
    }

    @PostMapping
    public ResponseEntity<String> insertConstructor(@RequestBody ConstructorRequest constructorRequest) {

        constructorRepository.findConstructorByNameOrConstructorref(constructorRequest.getName(), constructorRequest.getConstructorref())
                .ifPresentOrElse(constructor -> {
                            throw new RuntimeException("Construtor já existe.");
                        },
                        ()
                                -> constructorRepository.save(ConstructorMapper.toEntity(constructorRequest))
                );

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/victories")
    @Secured("Escuderia")
    public int getTotalVictoriesByConstructor(@RequestParam String p_nome_escuderia) {
        return constructorRepository.getTotalVictoriesByConstructor(p_nome_escuderia);
    }

    @GetMapping("/drivers")
    @Secured("Escuderia")
    public int getTotalDriversByConstructor(@RequestParam String p_nome_escuderia) {
        return constructorRepository.getTotalDriversByConstructor(p_nome_escuderia);
    }

    @GetMapping("/driverAndVictories")
    @Secured("Escuderia")
    public List<Relatorio3Response> getDriverAndVictories(@RequestParam int constructorId) {
        return escuderiaService.getDriverAndVictories(constructorId);
    }

    @GetMapping("/statusAndQuantity")
    @Secured("Escuderia")
    public List<Relatorio4Response> getStatusAndQuantities(@RequestParam int constructorId) {
        return escuderiaService.getStatusAndQuantities(constructorId);
    }

}
