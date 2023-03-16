package services.serviceImpl;

import dao.DaoAccessory;
import dao.DaoDescription;
import dao.DaoProvider;
import dao.DaoShop;
import dao.daoImpl.DaoAccessoryImpl;
import dao.daoImpl.DaoDescriptionImpl;
import dao.daoImpl.DaoProviderImpl;
import dao.daoImpl.DaoShopImpl;
import dto.AccessoryDto;
import dto.DescriptionDto;
import dto.ProviderDto;
import dto.ShopDto;
import entity.Accessory;
import entity.Provider;
import mapper.AccessoryMapper;
import mapper.impl.AccessoryMapperImpl;
import services.AccessoryService;

import java.util.*;
import java.util.stream.Collectors;

public class AccessoryServiceImpl implements AccessoryService {

    private DaoAccessory dao = new DaoAccessoryImpl();
    private DaoDescription daoDescription = new DaoDescriptionImpl();
    private DaoProvider daoProvider = new DaoProviderImpl();
    private DaoShop daoShop = new DaoShopImpl();
    private AccessoryMapper mapper = new AccessoryMapperImpl();
    private Accessory accessory;

    @Override
    public AccessoryDto save(AccessoryDto accessoryDto) {
        Accessory accessory = mapper.dtoToEntity(accessoryDto);
        dao.save(accessory);
        return accessoryDto;
    }

    @Override
    public void update(AccessoryDto accessoryDto) {
        dao.update(mapper.dtoToEntity(accessoryDto));
    }

    @Override
    public void delete(AccessoryDto accessoryDto) {
        dao.delete(mapper.dtoToEntity(accessoryDto));
    }

    @Override
    public void addDependencyDescription(AccessoryDto accessoryDto, Integer descriptionId) {
        Accessory accessory = mapper.dtoToEntity(accessoryDto);
        accessory.setDescription(daoDescription.findDescriptionById(descriptionId));
        dao.update(accessory);
    }

    @Override
    public void deleteDependencyDescription(AccessoryDto accessoryDto) {
        Accessory accessory = mapper.dtoToEntity(accessoryDto);
        accessory.setDescription(null);
        dao.update(accessory);
    }

    @Override
    public void addDependencyShop(AccessoryDto accessoryDto, Integer shopId) {
        Accessory accessory = mapper.dtoToEntity(accessoryDto);
        accessory.setShop(daoShop.findShopById(shopId));
        dao.update(accessory);
    }

    @Override
    public void deleteDependencyShop(AccessoryDto accessoryDto) {
        Accessory accessory = mapper.dtoToEntity(accessoryDto);
        accessory.setShop(null);
        dao.update(accessory);
    }

    @Override
    public void addDependencyProvider(AccessoryDto accessoryDto, Integer providerId) {
        Accessory accessory = mapper.dtoToEntity(accessoryDto);
        Set<Provider> providers = accessory.getProviders();
        providers.add(daoProvider.findProviderById(providerId));
        accessory.setProviders(providers);
        dao.update(accessory);
    }

    @Override
    public void deleteDependencyProvider(AccessoryDto accessoryDto, Integer id) {
        Accessory accessory = mapper.dtoToEntity(accessoryDto);
        Set<Provider> providers = accessory.getProviders();
        Iterator<Provider> iterator = providers.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                providers.remove(iterator.next());
            }
        }
        accessory.setProviders(providers);
        dao.update(accessory);
    }

    @Override
    public List<AccessoryDto> findAll(AccessoryDto accessoryDto) {
        return dao.findAll(accessory)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
