package services.serviceImpl;

import dao.DaoImpl;
import dao.DaoProvider;
import dao.DaoShop;
import dao.daoImpl.DaoProviderImpl;
import dao.daoImpl.DaoShopImpl;
import dto.ShopDto;
import entity.Provider;
import entity.Shop;
import mapper.ProviderMapper;
import mapper.ShopMapper;
import mapper.impl.ProviderMapperImpl;
import mapper.impl.ShopMapperImpl;
import services.ShopService;

import java.util.List;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService {

    private DaoShop dao = new DaoShopImpl();
    private ShopMapper mapper = new ShopMapperImpl();
    private Shop shop;

    @Override
    public ShopDto save(ShopDto shopDto) {
        Shop shop = mapper.dtoToEntity(shopDto);
        dao.save(shop);
        return shopDto;
    }

    @Override
    public void update(ShopDto shopDto) {
        dao.update(mapper.dtoToEntity(shopDto));
    }

    @Override
    public void delete(ShopDto shopDto) {
        dao.delete(mapper.dtoToEntity(shopDto));
    }

    @Override
    public List<ShopDto> findAll(ShopDto shopDto) {
        return dao.findAll(shop)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
