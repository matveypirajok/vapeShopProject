package mapper;

import dto.DescriptionDto;
import dto.EvaporatorDto;
import entity.Description;
import entity.Evaporator;

public interface EvaporatorMapper {
    Evaporator dtoToEntity(EvaporatorDto dto);
    EvaporatorDto entityToDto(Evaporator entity);
}
