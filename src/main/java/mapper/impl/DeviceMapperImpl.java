package mapper.impl;

import dto.DeviceDto;
import entity.Device;
import mapper.DeviceMapper;

public class DeviceMapperImpl implements DeviceMapper {
    @Override
    public Device dtoToEntity(DeviceDto dto) {
        return Device.builder()
                .id(dto.getId())
                .providers(dto.getProviders())
                .capacity(dto.getCapacity())
                .color(dto.getColor())
                .name(dto.getName())
                .price(dto.getPrice())
                .shop(dto.getShop())
                .description(dto.getDescription())
                .build();
    }

    @Override
    public DeviceDto entityToDto(Device entity) {
        return DeviceDto.builder()
                .id(entity.getId())
                .providers(entity.getProviders())
                .capacity(entity.getCapacity())
                .color(entity.getColor())
                .name(entity.getName())
                .price(entity.getPrice())
                .shop(entity.getShop())
                .description(entity.getDescription())
                .build();
    }
}
