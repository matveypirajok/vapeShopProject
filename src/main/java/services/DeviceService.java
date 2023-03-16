package services;

import dto.AccessoryDto;
import dto.CartridgeDto;
import dto.DeviceDto;

import java.util.List;

public interface DeviceService {
    DeviceDto save(DeviceDto deviceDto);

    void update(DeviceDto deviceDto);

    void delete(DeviceDto deviceDto);

    List<DeviceDto> findAll(DeviceDto deviceDto);

    void addDependencyDescription(DeviceDto deviceDto, Integer descriptionId);

    void deleteDependencyDescription(DeviceDto deviceDto);

    void addDependencyShop(DeviceDto deviceDto, Integer shopId);

    void deleteDependencyShop(DeviceDto deviceDto);

    void addDependencyProvider(DeviceDto deviceDto, Integer providerId);

    void deleteDependencyProvider(DeviceDto deviceDto, Integer id);
}
