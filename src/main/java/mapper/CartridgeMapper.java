package mapper;

import dto.AccessoryDto;
import dto.CartridgeDto;
import entity.Accessory;
import entity.Cartridge;

public interface CartridgeMapper {
    Cartridge dtoToEntity(CartridgeDto dto);
    CartridgeDto entityToDto(Cartridge entity);
}
