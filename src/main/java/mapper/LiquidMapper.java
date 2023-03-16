package mapper;

import dto.DescriptionDto;
import dto.LiquidDto;
import entity.Description;
import entity.Liquid;

public interface LiquidMapper {
    Liquid dtoToEntity(LiquidDto dto);
    LiquidDto entityToDto(Liquid entity);
}
