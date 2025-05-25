package com.elementary.mx.elementary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elementary.mx.elementary.DTO.body.ScoreBodyDTO;
import com.elementary.mx.elementary.DTO.update.ScoreUpdateDTO;
import com.elementary.mx.elementary.exception.DuplicatedScoreRecordException;
import com.elementary.mx.elementary.exception.IncompatibleGradeException;
import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.service.ScoreService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> createScore(@Valid @RequestBody ScoreBodyDTO scoreBodyDTO) throws IncompatibleGradeException, DuplicatedScoreRecordException{
        Score score = this.scoreService.createScore(scoreBodyDTO);
        return new ResponseEntity<Score>(score, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> findScoreById(@PathVariable int id) throws EntityNotFoundException{
        Score score = this.scoreService.findScoreById(id);
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Score>> findAllScores() throws EntityNotFoundException{
        List<Score> scores = this.scoreService.findAll();
        return new ResponseEntity<List<Score>>(scores, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable int id, @Valid @RequestBody ScoreUpdateDTO scoreDTO) throws EntityNotFoundException{
        Score score = this.scoreService.updateScore(id, scoreDTO);
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteScore(@PathVariable int id) throws EntityNotFoundException{
        this.scoreService.deleteScoreById(id);
    }

}
