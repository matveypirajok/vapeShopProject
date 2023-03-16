package mapper.impl;

import dto.ShopDto;
import entity.Shop;
import mapper.ShopMapper;

public class ShopMapperImpl implements ShopMapper {
    @Override
    public Shop dtoToEntity(ShopDto dto) {
        return Shop.builder().id(dto.getId())
                .accessories(dto.getAccessories())
                .cartridges(dto.getCartridges())
                .shopAddress(dto.getShopAddress())
                .devices(dto.getDevices())
                .evaporators(dto.getEvaporators())
                .liquids(dto.getLiquids())
                .build();
    }

    @Override
    public ShopDto entityToDto(Shop entity) {
        return ShopDto.builder().id(entity.getId())
                .accessories(entity.getAccessories())
                .cartridges(entity.getCartridges())
                .shopAddress(entity.getShopAddress())
                .devices(entity.getDevices())
                .evaporators(entity.getEvaporators())
                .liquids(entity.getLiquids())
                .build();
    }
}
