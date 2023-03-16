package services.serviceImpl;

import dao.DaoCartridge;
import dao.DaoDescription;
import dao.DaoProvider;
import dao.DaoShop;
import dao.daoImpl.DaoCartridgeImpl;
import dao.daoImpl.DaoDescriptionImpl;
import dao.daoImpl.DaoProviderImpl;
import dao.daoImpl.DaoShopImpl;
import dto.CartridgeDto;
import entity.Accessory;
import entity.Cartridge;
import entity.Provider;
import mapper.CartridgeMapper;
import mapper.impl.CartridgeMapperImpl;
import services.CartridgeService;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CartridgeServiceImpl implements CartridgeService {

    private DaoCartridge dao = new DaoCartridgeImpl();
    private CartridgeMapper mapper = new CartridgeMapperImpl();
    private DaoDescription daoDescription = new DaoDescriptionImpl();
    private DaoProvider daoProvider = new DaoProviderImpl();
    private DaoShop daoShop = new DaoShopImpl();
    private Cartridge cartridge;

    @Override
    public CartridgeDto save(CartridgeDto cartridgeDto) {
        Cartridge cartridge = mapper.dtoToEntity(cartridgeDto);
        dao.save(cartridge);
        return cartridgeDto;
    }

    @Override
    public void update(CartridgeDto cartridgeDto) {
        dao.update(mapper.dtoToEntity(cartridgeDto));
    }

    @Override
    public void delete(CartridgeDto cartridgeDto) {
        dao.delete(mapper.dtoToEntity(cartridgeDto));
    }

    @Override
    public List<CartridgeDto> findAll(CartridgeDto cartridgeDto) {
        return dao.findAll(cartridge)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addDependencyDescription(CartridgeDto cartridgeDto, Integer descriptionId) {
        Cartridge cartridge = mapper.dtoToEntity(cartridgeDto);
        cartridge.setDescription(daoDescription.findDescriptionById(descriptionId));
        dao.update(cartridge);
    }

    @Override
    public void deleteDependencyDescription(CartridgeDto cartridgeDto) {
        Cartridge cartridge = mapper.dtoToEntity(cartridgeDto);
        cartridge.setDescription(null);
    }

    @Override
    public void addDependencyShop(CartridgeDto cartridgeDto, Integer shopId) {
        Cartridge cartridge = mapper.dtoToEntity(cartridgeDto);
        cartridge.setShop(daoShop.findShopById(shopId));
        dao.update(cartridge);
    }

    @Override
    public void deleteDependencyShop(CartridgeDto cartridgeDto) {
        Cartridge cartridge = mapper.dtoToEntity(cartridgeDto);
        cartridge.setShop(null);
        dao.update(cartridge);
    }

    @Override
    public void addDependencyProvider(CartridgeDto cartridgeDto, Integer providerId) {
        Cartridge cartridge = mapper.dtoToEntity(cartridgeDto);
        Set<Provider> providers = cartridge.getProviders();
        providers.add(daoProvider.findProviderById(providerId));
        cartridge.setProviders(providers);
        dao.update(cartridge);
    }

    @Override
    public void deleteDependencyProvider(CartridgeDto cartridgeDto, Integer id) {
        Cartridge cartridge = mapper.dtoToEntity(cartridgeDto);
        Set<Provider> providers = cartridge.getProviders();
        Iterator<Provider> iterator = providers.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                providers.remove(iterator.next());
            }
        }
        cartridge.setProviders(providers);
        dao.update(cartridge);
    }
}
