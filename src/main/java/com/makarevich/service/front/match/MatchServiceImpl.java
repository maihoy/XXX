package com.makarevich.service.front.match;

import com.makarevich.dao.match.MatchDao;
import com.makarevich.dao.match.model.Match;
import com.makarevich.service.front.match.converter.MatchConverter;
import com.makarevich.service.front.match.dto.MatchDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MatchServiceImpl {

    @Autowired
    private MatchDao dao;
    @Autowired
    private MatchConverter matchConverter;

    public MatchDTO findMatchById(Long id) {
        Match match = dao.findMatchById(id);
        return matchConverter.convertToFront(match);
    }

    public void saveMatch(MatchDTO match) {
        if(match.getId() != null){
            Match entity = dao.findMatchById(match.getId());
            dao.saveMatch(matchConverter.convertToLocal(match, entity));
        } else {
            dao.saveMatch(matchConverter.convertToLocal(match, new Match()));
        }
    }


    public void updateMatch(MatchDTO match) {
        Match entity = dao.findMatchById(match.getId());
        if(entity!=null){
            matchConverter.convertToLocal(match, entity);
        }
    }

    public void deleteMatchById(Long id) {
        dao.deleteMatchById(id);
    }

    public List<MatchDTO> findAllMatches() {
        List<Match> matches = dao.findAllMatches();
        List<MatchDTO> result = new ArrayList<MatchDTO>(matches.size());
        for (Match match : matches) {
            result.add(matchConverter.convertToFront(match));
        }

        return result;
    }

}
