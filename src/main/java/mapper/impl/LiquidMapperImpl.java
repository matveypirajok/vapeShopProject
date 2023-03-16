package mapper.impl;

import dto.LiquidDto;
import entity.Liquid;
import mapper.LiquidMapper;

public class LiquidMapperImpl implements LiquidMapper {
    @Override
    public Liquid dtoToEntity(LiquidDto dto) {
        return Liquid.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .name(dto.getName())
                .agVg(dto.getAgVg())
                .shop(dto.getShop())
                .providers(dto.getProviders())
                .build();
    }

    @Override
    public LiquidDto entityToDto(Liquid entity) {
        return LiquidDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .name(entity.getName())
                .agVg(entity.getAgVg())
                .shop(entity.getShop())
                .providers(entity.getProviders())
                .build();
    }
}
