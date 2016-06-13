package com.makarevich.converter;


public interface ConverterToFront<Model, DTO> {

    DTO convertToFront(Model model);
}
