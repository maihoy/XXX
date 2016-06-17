package com.makarevich.service.front.match;

import com.makarevich.dao.match.MatchDao;
import com.makarevich.dao.match.model.Match;
import com.makarevich.dao.match.model.Score;
import com.makarevich.service.front.match.converter.MatchConverter;
import com.makarevich.service.front.match.converter.ScoreConverter;
import com.makarevich.service.front.match.dto.MatchDTO;
import com.makarevich.service.front.match.dto.ScoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("scoreService")
@Transactional
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    private MatchDao dao;

    @Autowired
    private ScoreConverter scoreConverter;

    public ScoreDTO findScoreById(Long id) {
        Score score = dao.findScoreById(id);
        return scoreConverter.convertToFront(score);
    }

    public void saveScore(ScoreDTO score) {
        if(score.getId() != null){
            Score entity = dao.findScoreById(score.getId());
            dao.saveScore(scoreConverter.convertToLocal(score, entity));
        } else {
            dao.saveScore(scoreConverter.convertToLocal(score, new Score()));
        }
    }


    public void updateScore(ScoreDTO score) {
        Score entity = dao.findScoreById(score.getId());
        if(entity!=null){
            scoreConverter.convertToLocal(score, entity);
        }
    }

    public void deleteScoreById(Long id) {
        dao.deleteScoreById(id);
    }

    public List<ScoreDTO> findAllScores() {
        List<Score> scores = dao.findAllScores();
        List<ScoreDTO> result = new ArrayList<ScoreDTO>(scores.size());
        for (Score score : scores) {
            result.add(scoreConverter.convertToFront(score));
        }

        return result;
    }

}
