package com.elementary.mx.elementary.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elementary.mx.elementary.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
}
