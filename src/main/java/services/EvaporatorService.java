package services;

import dto.AccessoryDto;
import dto.EvaporatorDto;

import java.util.List;

public interface EvaporatorService {
    EvaporatorDto save(EvaporatorDto evaporatorDto);

    void update(EvaporatorDto evaporatorDto);

    void delete(EvaporatorDto evaporatorDto);

    List<EvaporatorDto> findAll(EvaporatorDto evaporatorDto);

    void addDependencyDescription(EvaporatorDto evaporatorDto, Integer descriptionId);

    void deleteDependencyDescription(EvaporatorDto evaporatorDto);

    void addDependencyShop(EvaporatorDto evaporatorDto, Integer shopId);

    void deleteDependencyShop(EvaporatorDto evaporatorDto);

    void addDependencyProvider(EvaporatorDto evaporatorDto, Integer providerId);

    void deleteDependencyProvider(EvaporatorDto evaporatorDto, Integer id);
}
