package mapper.impl;

import dto.DescriptionDto;
import entity.Description;
import mapper.DescriptionMapper;

public class DescriptionMapperImpl implements DescriptionMapper {
    @Override
    public Description dtoToEntity(DescriptionDto dto) {
        return Description.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .build();
    }

    @Override
    public DescriptionDto entityToDto(Description entity) {
        return DescriptionDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .build();
    }
}
