package com.makarevich.converter;

import com.makarevich.model.Team;
import com.makarevich.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Object, Team>{

    @Autowired
    TeamService teamService;

    public Team convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Team profile= teamService.findById(id);
        System.out.println("Team : "+profile);
        return profile;
    }

}
