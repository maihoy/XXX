package com.makarevich.converter;

public interface ConverterToLocal<Model, DTO> {

    Model convertToLocal(DTO dto, Model model);

}
