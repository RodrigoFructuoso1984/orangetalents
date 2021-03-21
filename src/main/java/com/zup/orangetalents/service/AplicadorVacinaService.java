package com.zup.orangetalents.service;

import com.zup.orangetalents.entity.AplicadorVacina;
import com.zup.orangetalents.repository.AplicadorVacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AplicadorVacinaService {

    @Autowired
    private AplicadorVacinaRepository aplicadorVacinaRepository;

    public AplicadorVacina save(AplicadorVacina requestToSave) {
        int idCriado = aplicadorVacinaRepository.save(requestToSave).getId();
        Optional<AplicadorVacina> aplicadorCriado = aplicadorVacinaRepository.findById(idCriado);
        if (aplicadorCriado.isEmpty()) {
            throw new IllegalArgumentException("Aplicador não encontrado");
        }
        return aplicadorCriado.get();
    }
}
