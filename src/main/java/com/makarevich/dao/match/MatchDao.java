package com.makarevich.dao.match;

import com.makarevich.dao.match.model.Match;

import java.util.List;

public interface MatchDao {

    void saveMatch(Match match);
    void deleteMatchById(Long id);
    List<Match> findAllMatches();
    Match findMatchById(Long id);
}
