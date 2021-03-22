package com.zup.orangetalents.controller;

import com.zup.orangetalents.entity.AplicadorVacina;
import com.zup.orangetalents.service.AplicadorVacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/vacina")
public class VacinaController {

    @Autowired
    private AplicadorVacinaService aplicadorVacinaService;

    @PostMapping("/aplicar")
    public ResponseEntity<AplicadorVacina> aplicar(@RequestBody AplicadorVacina aplicadorVacina) {
        try {
            AplicadorVacina aplicadorCriado = aplicadorVacinaService.save(aplicadorVacina);
            return ResponseEntity.status(HttpStatus.CREATED).body(aplicadorCriado);
        } catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
