package com.padwan.test.service;

import com.padwan.test.dto.MestreAprendizDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JediService {

    private final JediRepository jediRepository;

    @Autowired
    public JediService(JediRepository jediRepository) {
        this.jediRepository = jediRepository;
    }

    public List<MestreAprendizDTO> getMestresEAprendizes() {
        return jediRepository.findAllMestresEAprendizes().stream()
                            .map(record -> new MestreAprendizDTO(
                                    (String) record[0], // mestre
                                    (String) record[1]  // aprendiz
                            ))
                            .collect(Collectors.toList());
    }  

    public List<Jedi> getJedisWithHighMidichlorians() {
        return jediRepository.findAllJedisWithHighMidichlorians();
    }

    public List<Object[]> getJediCountByStatus() {
        return jediRepository.countJedisByStatus();
    }

    // método para salvar Jedi
    public Jedi saveJedi(Jedi jedi) {
        if (jedi.getMentor() != null && jedi.getMentor().getId() != null) {
            Jedi mentor = jediRepository.findById(jedi.getMentor().getId())
                                        .orElseThrow(() -> new RuntimeException("Mentor não encontrado"));
            jedi.setMentor(mentor);
        }
        return jediRepository.save(jedi);
    }

    // método para deletar jedi
    public boolean deleteJediById(Long id) {
    if (jediRepository.existsById(id)) {
        jediRepository.deleteById(id);
        return true;
    } else {
        return false; // Caso o ID não exista
    }
}



}