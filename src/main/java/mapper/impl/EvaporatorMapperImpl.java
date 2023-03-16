package mapper.impl;

import dto.EvaporatorDto;
import entity.Evaporator;
import mapper.EvaporatorMapper;

public class EvaporatorMapperImpl implements EvaporatorMapper {
    @Override
    public Evaporator dtoToEntity(EvaporatorDto dto) {
        return Evaporator.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .providers(dto.getProviders())
                .resistance(dto.getResistance())
                .shop(dto.getShop())
                .build();
    }

    @Override
    public EvaporatorDto entityToDto(Evaporator entity) {
        return EvaporatorDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .providers(entity.getProviders())
                .resistance(entity.getResistance())
                .shop(entity.getShop())
                .build();
    }
}
