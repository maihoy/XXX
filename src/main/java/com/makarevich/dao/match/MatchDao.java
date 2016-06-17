package com.makarevich.dao.match;

import com.makarevich.dao.match.model.Match;
import com.makarevich.dao.match.model.Score;

import java.util.List;

public interface MatchDao {

   /* void saveMatch(Match match);
    void deleteMatchById(Long id);
    List<Match> findAllMatches();
    Match findMatchById(Long id);
**/
    void saveScore(Score score);
    void deleteScoreById(Long id);
    List<Score> findAllScores();
    Score findScoreById(Long id);
}
