package mapper.impl;

import dto.CartridgeDto;
import entity.Cartridge;
import mapper.CartridgeMapper;

public class CartridgeMapperImpl implements CartridgeMapper {
    @Override
    public Cartridge dtoToEntity(CartridgeDto dto) {
        return Cartridge.builder()
                .id(dto.getId())
                .providers(dto.getProviders())
                .description(dto.getDescription())
                .resistance(dto.getResistance())
                .shop(dto.getShop())
                .build();
    }

    @Override
    public CartridgeDto entityToDto(Cartridge entity) {
        return CartridgeDto.builder()
                .id(entity.getId())
                .providers(entity.getProviders())
                .description(entity.getDescription())
                .resistance(entity.getResistance())
                .shop(entity.getShop())
                .build();
    }
}
