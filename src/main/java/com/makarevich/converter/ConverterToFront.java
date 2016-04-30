package com.makarevich.converter;

/**
 * User: svetlana.voyteh
 * Date: 14.04.2016
 */
public interface ConverterToFront<Model, DTO> {

    DTO convertToFront(Model model);
}
