package com.example.AtvCurriculo.service;


import com.example.AtvCurriculo.models.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AtvCurriculo.repository.CurriculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {
    private final CurriculoRepository curriculoRepository;

    @Autowired
    public CurriculoService(CurriculoRepository curriculoRepository) {
        this.curriculoRepository = curriculoRepository;
    }
    public List<Curriculo> listarCurriculos() {
        return curriculoRepository.findAll();
    }
    public Optional<Curriculo> obterCurriculoPorId(Long id) {
        return curriculoRepository.findById(id);
    }
    public Curriculo create(Curriculo curriculo2) {
        return curriculoRepository.save(curriculo2);
    }

    public Curriculo update(Long id, Curriculo curriculoAtualizado) {
        Curriculo curriculoExistente = curriculoRepository.findById(id).orElse(null);

        if (curriculoExistente != null) {
            curriculoExistente.setNome(curriculoAtualizado.getNome());
            curriculoExistente.setEmail(curriculoAtualizado.getEmail());
            curriculoExistente.setObjetivo(curriculoAtualizado.getObjetivo());
            curriculoExistente.setFormacao(curriculoAtualizado.getFormacao());
            curriculoExistente.setXp(curriculoAtualizado.getXp());
            curriculoExistente.setHabilidades(curriculoAtualizado.getHabilidades());

            return curriculoRepository.save(curriculoExistente);
        } else {
            return null;
        }
    }
    public void delete(Long id) {
        curriculoRepository.deleteById(id);
    }
}