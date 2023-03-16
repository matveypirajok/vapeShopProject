package services;

import dto.AccessoryDto;
import dto.DescriptionDto;
import dto.ProviderDto;
import dto.ShopDto;
import entity.Accessory;
import entity.Description;

import java.util.List;

public interface AccessoryService {
    AccessoryDto save(AccessoryDto accessoryDto);

    void update(AccessoryDto accessoryDto);

    void delete(AccessoryDto accessoryDto);

    void addDependencyDescription(AccessoryDto accessoryDto, Integer descriptionId);

    void deleteDependencyDescription(AccessoryDto accessoryDto);

    void addDependencyShop(AccessoryDto accessoryDto, Integer shopId);

    void deleteDependencyShop(AccessoryDto accessoryDto);

    void addDependencyProvider(AccessoryDto accessoryDto, Integer providerId);

    void deleteDependencyProvider(AccessoryDto accessoryDto, Integer id);

    List<AccessoryDto> findAll(AccessoryDto accessoryDto);
}
