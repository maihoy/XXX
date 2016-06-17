package com.makarevich.service.front.match;

import com.makarevich.service.front.match.dto.ScoreDTO;

import java.util.List;


public interface ScoreService {
    ScoreDTO findScoreById(Long id);

    void saveScore(ScoreDTO score);

    void updateScore(ScoreDTO score);

    void deleteScoreById(Long id);

    List<ScoreDTO> findAllScores();
}
