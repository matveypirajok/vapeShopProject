package services.serviceImpl;

import dao.*;
import dao.daoImpl.*;
import dto.AccessoryDto;
import dto.EvaporatorDto;
import entity.Device;
import entity.Evaporator;
import entity.Provider;
import mapper.DeviceMapper;
import mapper.EvaporatorMapper;
import mapper.impl.DeviceMapperImpl;
import mapper.impl.EvaporatorMapperImpl;
import services.EvaporatorService;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EvaporatorServiceImpl implements EvaporatorService {

    private DaoEvaporator dao = new DaoEvaporatorImpl();
    private EvaporatorMapper mapper = new EvaporatorMapperImpl();
    private DaoDescription daoDescription = new DaoDescriptionImpl();
    private DaoProvider daoProvider = new DaoProviderImpl();
    private DaoShop daoShop = new DaoShopImpl();
    private Evaporator evaporator;

    @Override
    public EvaporatorDto save(EvaporatorDto evaporatorDto) {
        Evaporator evaporator = mapper.dtoToEntity(evaporatorDto);
        dao.save(evaporator);
        return evaporatorDto;
    }

    @Override
    public void update(EvaporatorDto evaporatorDto) {
        dao.update(mapper.dtoToEntity(evaporatorDto));
    }

    @Override
    public void delete(EvaporatorDto evaporatorDto) {
        dao.delete(mapper.dtoToEntity(evaporatorDto));
    }

    @Override
    public List<EvaporatorDto> findAll(EvaporatorDto evaporatorDto) {
        return dao.findAll(evaporator)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addDependencyDescription(EvaporatorDto evaporatorDto, Integer descriptionId) {
        Evaporator evaporator = mapper.dtoToEntity(evaporatorDto);
        evaporator.setDescription(daoDescription.findDescriptionById(descriptionId));
        dao.update(evaporator);
    }

    @Override
    public void deleteDependencyDescription(EvaporatorDto evaporatorDto) {
        Evaporator evaporator = mapper.dtoToEntity(evaporatorDto);
        evaporator.setDescription(null);
        dao.update(evaporator);
    }

    @Override
    public void addDependencyShop(EvaporatorDto evaporatorDto, Integer shopId) {
        Evaporator evaporator = mapper.dtoToEntity(evaporatorDto);
        evaporator.setShop(daoShop.findShopById(shopId));
        dao.update(evaporator);
    }

    @Override
    public void deleteDependencyShop(EvaporatorDto evaporatorDto) {
        Evaporator evaporator = mapper.dtoToEntity(evaporatorDto);
        evaporator.setShop(null);
        dao.update(evaporator);
    }

    @Override
    public void addDependencyProvider(EvaporatorDto evaporatorDto, Integer providerId) {
        Evaporator evaporator = mapper.dtoToEntity(evaporatorDto);
        Set<Provider> providers = evaporator.getProviders();
        providers.add(daoProvider.findProviderById(providerId));
        evaporator.setProviders(providers);
        dao.update(evaporator);
    }

    @Override
    public void deleteDependencyProvider(EvaporatorDto evaporatorDto, Integer id) {
        Evaporator evaporator = mapper.dtoToEntity(evaporatorDto);
        Set<Provider> providers = evaporator.getProviders();
        Iterator<Provider> iterator = providers.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                providers.remove(iterator.next());
            }
        }
        evaporator.setProviders(providers);
        dao.update(evaporator);
    }
}
