package mapper;

import dto.DescriptionDto;
import dto.DeviceDto;
import entity.Description;
import entity.Device;

public interface DeviceMapper {
    Device dtoToEntity(DeviceDto dto);
    DeviceDto entityToDto(Device entity);
}
