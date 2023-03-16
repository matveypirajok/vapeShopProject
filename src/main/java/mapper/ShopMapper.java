package mapper;

import dto.DescriptionDto;
import dto.ShopDto;
import entity.Description;
import entity.Shop;

public interface ShopMapper {
    Shop dtoToEntity(ShopDto dto);
    ShopDto entityToDto(Shop entity);
}
