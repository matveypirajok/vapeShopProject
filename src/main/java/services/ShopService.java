package services;

import dto.ProviderDto;
import dto.ShopDto;

import java.util.List;

public interface ShopService {
    ShopDto save(ShopDto shopDto);

    void update(ShopDto shopDto);

    void delete(ShopDto shopDto);

    List<ShopDto> findAll(ShopDto shopDto);
}
