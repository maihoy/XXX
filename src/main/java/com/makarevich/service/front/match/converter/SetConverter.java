package com.makarevich.service.front.match.converter;


import com.makarevich.converter.Converter;
import com.makarevich.dao.match.model.Rally;
import com.makarevich.dao.match.model.Set;
import com.makarevich.service.front.match.dto.SetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetConverter implements Converter<Set, SetDTO> {

    @Autowired
    private RallyConverter rallyConverter;

    public SetDTO convertToFront(Set set) {
        SetDTO dto = new SetDTO();
        dto.setId(set.getId());

        for (Rally rally : set.getRallies()) {
            dto.getRallies().add(rallyConverter.convertToFront(rally));
        }


        return dto;
    }

    public Set convertToLocal(SetDTO setDTO, Set set) {
        return null;
    }
}
