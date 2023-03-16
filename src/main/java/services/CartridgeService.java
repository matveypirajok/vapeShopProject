package services;

import dto.AccessoryDto;
import dto.CartridgeDto;

import java.util.List;

public interface CartridgeService {
    CartridgeDto save(CartridgeDto cartridgeDto);

    void update(CartridgeDto cartridgeDto);

    void delete(CartridgeDto cartridgeDto);

    List<CartridgeDto> findAll(CartridgeDto cartridgeDto);

    void addDependencyDescription(CartridgeDto cartridgeDto, Integer descriptionId);

    void deleteDependencyDescription(CartridgeDto cartridgeDto);

    void addDependencyShop(CartridgeDto cartridgeDto, Integer shopId);

    void deleteDependencyShop(CartridgeDto cartridgeDto);

    void addDependencyProvider(CartridgeDto cartridgeDto, Integer providerId);

    void deleteDependencyProvider(CartridgeDto cartridgeDto, Integer id);
}
