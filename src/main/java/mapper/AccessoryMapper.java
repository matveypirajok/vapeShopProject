package mapper;

import dto.AccessoryDto;
import entity.Accessory;

public interface AccessoryMapper {
        Accessory dtoToEntity(AccessoryDto dto);
        AccessoryDto entityToDto(Accessory entity);
}
