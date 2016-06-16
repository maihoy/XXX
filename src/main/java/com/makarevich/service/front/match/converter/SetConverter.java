package com.makarevich.service.front.match.converter;


import com.makarevich.converter.Converter;
import com.makarevich.dao.match.model.Set;
import com.makarevich.service.front.match.dto.SetDTO;
import org.springframework.stereotype.Component;

@Component
public class SetConverter implements Converter<Set, SetDTO> {

    public SetDTO convertToFront(Set set) {
        // todo;
        return null;
    }

    public Set convertToLocal(SetDTO setDTO, Set set) {
        return null;
    }
}
