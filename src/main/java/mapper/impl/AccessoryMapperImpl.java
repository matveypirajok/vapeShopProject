package mapper.impl;

import dto.AccessoryDto;
import entity.Accessory;
import mapper.AccessoryMapper;

public class AccessoryMapperImpl implements AccessoryMapper {

    @Override
    public Accessory dtoToEntity(AccessoryDto dto) {
        return Accessory.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .shop(dto.getShop())
                .description(dto.getDescription())
                .providers(dto.getProviders())
                .build();
    }

    @Override
    public AccessoryDto entityToDto(Accessory entity) {
        return AccessoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .shop(entity.getShop())
                .description(entity.getDescription())
                .providers(entity.getProviders())
                .build();
    }
}
