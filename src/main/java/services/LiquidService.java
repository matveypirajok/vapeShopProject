package services;

import dto.AccessoryDto;
import dto.EvaporatorDto;
import dto.LiquidDto;
import entity.Liquid;

import java.util.List;

public interface LiquidService {
    LiquidDto save(LiquidDto liquidDto);

    void update(LiquidDto liquidDto);

    void delete(LiquidDto liquidDto);

    List<LiquidDto> findAll(LiquidDto liquidDto);

    void addDependencyDescription(LiquidDto liquidDto, Integer descriptionId);

    void deleteDependencyDescription(LiquidDto liquidDto);

    void addDependencyShop(LiquidDto liquidDto, Integer shopId);

    void deleteDependencyShop(LiquidDto liquidDto);

    void addDependencyProvider(LiquidDto liquidDto, Integer providerId);

    void deleteDependencyProvider(LiquidDto liquidDto, Integer id);
}
