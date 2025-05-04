package com.elementary.mx.elementary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elementary.mx.elementary.DTO.ScoreDTO;
import com.elementary.mx.elementary.mapper.ScoreMapper;
import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.repository.ScoreRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ScoreMapper scoreMapper;

    public Score createScore(ScoreDTO scoreDTO){
        Score score = new Score(); 
        this.scoreMapper.updateScoreFromRecord(scoreDTO, score);
        return this.scoreRepository.save(score);
    }

    public Score findScoreById(int id) throws EntityNotFoundException{
        return this.scoreRepository
                        .findById(id)
                        .orElseThrow(EntityNotFoundException::new);
    }

    public List<Score> findAll(){
        return this.scoreRepository.findAll();
    }

    public Score updateScore(int id, ScoreDTO scoreDTO){
        Score score = this.findScoreById(id);
        this.scoreMapper.updateScoreFromRecord(scoreDTO, score);
        return this.scoreRepository.save(score);
    }

    public void deleteScoreById(int id){
        this.scoreRepository.deleteById(id);
    }
}
