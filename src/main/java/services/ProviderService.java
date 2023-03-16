package services;

import dto.AccessoryDto;
import dto.CartridgeDto;
import dto.ProviderDto;

import java.util.List;

public interface ProviderService {
    ProviderDto save(ProviderDto providerDto);

    void update(ProviderDto providerDto);

    void delete(ProviderDto providerDto);

    List<ProviderDto> findAll(ProviderDto providerDto);
}
