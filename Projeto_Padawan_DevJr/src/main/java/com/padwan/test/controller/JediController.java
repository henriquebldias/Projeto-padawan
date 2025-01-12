package com.padwan.test.controller;

import com.padwan.test.dto.MestreAprendizDTO;
import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jedi")
public class JediController {

    private final JediService jediService;

    @Autowired
    public JediController(JediService jediService) {
        this.jediService = jediService;
    }

    @GetMapping("/mestres-aprendizes")
    public ResponseEntity<List<MestreAprendizDTO>> getMestresEAprendizes() {
        return new ResponseEntity<>(jediService.getMestresEAprendizes(), HttpStatus.OK);
    }
    
    @GetMapping("/high-midichlorians")
    public ResponseEntity<List<Jedi>> getJedisWithHighMidichlorians() {
        return new ResponseEntity<>(jediService.getJedisWithHighMidichlorians(), HttpStatus.OK);
    }

    @GetMapping("/count-by-status")
    public ResponseEntity<List<Object[]>> getJediCountByStatus() {
        return new ResponseEntity<>(jediService.getJediCountByStatus(), HttpStatus.OK);
    }

    // endpoint para criar Jedi
    @PostMapping("/create")
    public ResponseEntity<JediDTO> createJedi(@RequestBody Jedi jedi) {
        try {
            Jedi savedJedi = jediService.saveJedi(jedi);
            return new ResponseEntity<>(new JediDTO(savedJedi), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // endpoint para deletar jedi
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJedi(@PathVariable Long id) {
        try {
            boolean deleted = jediService.deleteJediById(id);
            if (deleted) {
                return new ResponseEntity<>("Jedi removido com sucesso!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Jedi não encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao remover o Jedi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}