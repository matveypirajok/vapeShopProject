package mapper;

import dto.DescriptionDto;
import dto.ProviderDto;
import entity.Description;
import entity.Provider;

public interface ProviderMapper {
    Provider dtoToEntity(ProviderDto dto);
    ProviderDto entityToDto(Provider entity);
}
