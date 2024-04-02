package com.selsup.api.selsuptesttask.mapper;

import com.selsup.api.selsuptesttask.dto.DocumentDto;
import com.selsup.api.selsuptesttask.dto.ProductDto;
import com.selsup.api.selsuptesttask.model.Document;
import com.selsup.api.selsuptesttask.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface DocumentMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "productionDate", target = "productionDate", qualifiedByName = "convertStringToLocalDate")
    @Mapping(source = "regDate", target = "regDate", qualifiedByName = "convertStringToLocalDate")
    Document mapDtoDocumentToEntity(DocumentDto documentDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "certificateDocumentDate", target = "certificateDocumentDate", qualifiedByName = "convertStringToLocalDate")
    @Mapping(source = "productionDate", target = "productionDate", qualifiedByName = "convertStringToLocalDate")
    Product mapDtoProductToEntity(ProductDto productDto);

    @Named("convertStringToLocalDate")
    default LocalDate convertStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}
