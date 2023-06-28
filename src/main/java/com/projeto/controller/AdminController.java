package com.projeto.controller;

import com.projeto.mapper.ConstructorMapper;
import com.projeto.mapper.DriverMapper;
import com.projeto.model.response.Relatorio1Response;
import com.projeto.model.request.ConstructorRequest;
import com.projeto.model.request.DriverRequest;
import com.projeto.model.response.Relatorio2Response;
import com.projeto.model.response.Relatorio5Response;
import com.projeto.model.response.Relatorio6Response;
import com.projeto.repository.ConstructorRepository;
import com.projeto.repository.DriverRepository;
import com.projeto.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private DriverRepository driverRepository;
    private ConstructorRepository constructorRepository;
    private AdminService adminService;

    @Autowired
    public AdminController(DriverRepository driverRepository, ConstructorRepository constructorRepository, AdminService adminService) {
        this.driverRepository = driverRepository;
        this.constructorRepository = constructorRepository;
        this.adminService = adminService;
    }

    public AdminController() {
    }

    @GetMapping("/driver")
    @Secured("Administrador")
    public int countAllDriver() {
        return driverRepository.countAll();
    }

    @GetMapping("/race")
    @Secured("Administrador")
    public int countAllRaces() {
        return driverRepository.countAllRace();
    }

    @GetMapping("/constructor")
    @Secured("Administrador")
    public int countAllConstructor() {
        return constructorRepository.countAllConstructor();
    }

    @GetMapping("/season")
    @Secured("Administrador")
    public int countAllSeason() {
        return constructorRepository.countAllSeason();
    }

    @GetMapping("/resultByStatus")
    @Secured("Administrador")
    public List<Relatorio1Response> getResultByStatus() {
        return adminService.getResultByStatus();
    }

    @GetMapping("/airports-cities")
    @Secured("Administrador")
    public List<Relatorio2Response> getAirportsAndCities(@RequestParam String cityName){
        return adminService.getAirportsAndCities(cityName);
    }

    @PostMapping("/driver")
    @Secured("Administrador")
    public ResponseEntity<String> insertDriver(@RequestBody DriverRequest driverRequest) {

        driverRepository.findByForename(driverRequest.getForename())
                .ifPresentOrElse(driver -> {
                            throw new RuntimeException("Piloto já existe.");
                        },
                        ()
                                -> driverRepository.save(DriverMapper.toEntity(driverRequest))
                );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/constructor")
    @Secured("Administrador")
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
}
