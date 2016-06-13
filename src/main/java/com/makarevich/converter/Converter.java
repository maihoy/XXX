package com.makarevich.converter;

public interface Converter<Model, DTO> extends ConverterToLocal<Model, DTO>, ConverterToFront<Model, DTO> {
}
