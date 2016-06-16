package com.makarevich.service.front.match.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.match.model.Rally;
import com.makarevich.dao.match.model.RallyItem;
import com.makarevich.service.front.match.dto.RallyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RallyConverter  implements Converter<Rally, RallyDTO> {


        @Autowired
        private RallyItemConverter rallyItemConverter;

        public RallyDTO convertToFront(Rally rally) {
            RallyDTO dto = new RallyDTO();
            dto.setId(rally.getId());

            for (RallyItem rallyItem : rally.getItems()) {
                dto.getRallyItems().add(rallyItemConverter.convertToFront(rallyItem));
            }


            return dto;
        }

        public Rally convertToLocal(RallyDTO rallyDTO, Rally rally) {
            return null;
        }

}
