package mapper;

import dto.AccessoryDto;
import dto.DescriptionDto;
import entity.Accessory;
import entity.Description;

public interface DescriptionMapper {
    Description dtoToEntity( DescriptionDto dto);
    DescriptionDto entityToDto(Description entity);
}
