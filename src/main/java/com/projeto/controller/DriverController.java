package com.projeto.controller;

import com.projeto.mapper.DriverMapper;
import com.projeto.model.Driver;
import com.projeto.model.request.DriverRequest;
import com.projeto.model.response.Relatorio5Response;
import com.projeto.model.response.Relatorio6Response;
import com.projeto.repository.DriverRepository;
import com.projeto.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/driver")
public class DriverController {
    public DriverRepository driverRepository;
    public DriverService driverService;

    @Autowired
    public DriverController(DriverRepository driverRepository,DriverService driverService) {
        this.driverRepository = driverRepository;
        this.driverService = driverService;
    }

    public DriverController() {
    }

    @GetMapping
    public int countAll() {
        return driverRepository.countAll();
    }

    @GetMapping("/races")
    public int countAllRaces() {
        return driverRepository.countAllRace();
    }


    @GetMapping("/forename")
    public Driver findByForename(@RequestParam(value = "forename") String forename){
        return driverRepository.findByForename(forename).orElse(null);
    }

    @PostMapping
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

    @GetMapping("/victories")
    @Secured("Piloto")
    public int getTotalVictoriesByPilot(@RequestParam String p_driverref){
        return driverRepository.getTotalVictoriesByDriver(p_driverref);
    }

    @GetMapping("/historic")
    @Secured("Piloto")
    public Map<String,?> getDriverHistoric(@RequestParam String p_driverref){
        return driverRepository.getDriverHistoric(p_driverref);
    }

    @GetMapping("/yearAndRaceName")
    @Secured("Piloto")
    public List<Relatorio5Response> getYearAndRaceName(@RequestParam String p_driverref){
        return driverService.getYearAndRaceName(p_driverref);
    }

    @GetMapping("/statusAndQuantity")
    @Secured("Piloto")
    public List<Relatorio6Response> getStatusAndQuantity(@RequestParam String p_driverref){
        return driverService.getStatusAndQuantity(p_driverref);
    }

}
