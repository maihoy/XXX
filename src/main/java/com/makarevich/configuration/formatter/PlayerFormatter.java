package com.makarevich.configuration.formatter;

import com.makarevich.service.front.player.dto.PlayerDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * User: svetlana.voyteh
 * Date: 15.04.2016
 */
@Component
public class PlayerFormatter implements Converter<PlayerDTO, PlayerDTO> {

    public PlayerDTO convert(PlayerDTO source) {
        return source;
    }
}
