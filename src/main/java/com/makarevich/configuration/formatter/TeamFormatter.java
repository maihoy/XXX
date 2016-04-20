package com.makarevich.configuration.formatter;

import com.makarevich.service.front.team.dto.TeamDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TeamFormatter implements Converter<TeamDTO, TeamDTO>{

    public TeamDTO convert(TeamDTO element) {
        return element;
    }

}
