package com.makarevich.converter;

/**
 * User: svetlana.voyteh
 * Date: 14.04.2016
 */
public interface Converter<Model, DTO> extends ConverterToLocal<Model, DTO>, ConverterToFront<Model, DTO> {
}
