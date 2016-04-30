package com.makarevich.converter;

/**
 * User: svetlana.voyteh
 * Date: 14.04.2016
 */
public interface ConverterToLocal<Model, DTO> {

    Model convertToLocal(DTO dto, Model model);

}
