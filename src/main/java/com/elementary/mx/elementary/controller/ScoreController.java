package com.elementary.mx.elementary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elementary.mx.elementary.DTO.ScoreDTO;
import com.elementary.mx.elementary.model.Score;
import com.elementary.mx.elementary.service.ScoreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/score")
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> createScore(@Valid @RequestBody ScoreDTO scoreDTO){
        Score score = this.scoreService.createScore(scoreDTO);
        return new ResponseEntity<Score>(score, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> findScoreById(@RequestParam int id){
        Score score = this.scoreService.findScoreById(id);
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Score>> findAllScores(){
        List<Score> scores = this.scoreService.findAll();
        return new ResponseEntity<List<Score>>(scores, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable int id, @Valid @RequestBody ScoreDTO scoreDTO){
        Score score = this.scoreService.updateScore(id, scoreDTO);
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteScore(int id){
        this.scoreService.deleteScoreById(id);
    }

}
