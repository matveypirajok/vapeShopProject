package mapper.impl;

import dto.ProviderDto;
import entity.Provider;
import mapper.ProviderMapper;

public class ProviderMapperImpl implements ProviderMapper {
    @Override
    public Provider dtoToEntity(ProviderDto dto) {
        return Provider.builder()
                .id(dto.getId())
                .address(dto.getAddress())
                .accessories(dto.getAccessories())
                .cartridges(dto.getCartridges())
                .country(dto.getCountry())
                .devices(dto.getDevices())
                .liquids(dto.getLiquids())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    @Override
    public ProviderDto entityToDto(Provider entity) {
        return ProviderDto.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .accessories(entity.getAccessories())
                .cartridges(entity.getCartridges())
                .country(entity.getCountry())
                .devices(entity.getDevices())
                .liquids(entity.getLiquids())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }
}
