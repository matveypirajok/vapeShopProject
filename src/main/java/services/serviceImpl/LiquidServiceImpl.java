package services.serviceImpl;

import dao.*;
import dao.daoImpl.*;
import dto.LiquidDto;
import entity.Evaporator;
import entity.Liquid;
import entity.Provider;
import mapper.EvaporatorMapper;
import mapper.LiquidMapper;
import mapper.impl.EvaporatorMapperImpl;
import mapper.impl.LiquidMapperImpl;
import services.LiquidService;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LiquidServiceImpl implements LiquidService {

    private DaoLiquid dao = new DaoLiquidImpl();
    private LiquidMapper mapper = new LiquidMapperImpl();
    private DaoDescription daoDescription = new DaoDescriptionImpl();
    private DaoProvider daoProvider = new DaoProviderImpl();
    private DaoShop daoShop = new DaoShopImpl();
    private Liquid liquid;

    @Override
    public LiquidDto save(LiquidDto liquidDto) {
        Liquid liquid = mapper.dtoToEntity(liquidDto);
        dao.save(liquid);
        return liquidDto;
    }

    @Override
    public void update(LiquidDto liquidDto) {
        dao.update(mapper.dtoToEntity(liquidDto));
    }

    @Override
    public void delete(LiquidDto liquidDto) {
        dao.delete(mapper.dtoToEntity(liquidDto));
    }

    @Override
    public List<LiquidDto> findAll(LiquidDto liquidDto) {
        return dao.findAll(liquid)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addDependencyDescription(LiquidDto liquidDto, Integer descriptionId) {
        Liquid liquid = mapper.dtoToEntity(liquidDto);
        liquid.setDescription(daoDescription.findDescriptionById(descriptionId));
        dao.update(liquid);
    }

    @Override
    public void deleteDependencyDescription(LiquidDto liquidDto) {
        Liquid liquid = mapper.dtoToEntity(liquidDto);
        liquid.setDescription(null);
        dao.update(liquid);
    }

    @Override
    public void addDependencyShop(LiquidDto liquidDto, Integer shopId) {
        Liquid liquid = mapper.dtoToEntity(liquidDto);
        liquid.setShop(daoShop.findShopById(shopId));
        dao.update(liquid);
    }

    @Override
    public void deleteDependencyShop(LiquidDto liquidDto) {
        Liquid liquid = mapper.dtoToEntity(liquidDto);
        liquid.setShop(null);
        dao.update(liquid);
    }

    @Override
    public void addDependencyProvider(LiquidDto liquidDto, Integer providerId) {
        Liquid liquid = mapper.dtoToEntity(liquidDto);
        Set<Provider> providers = liquid.getProviders();
        providers.add(daoProvider.findProviderById(providerId));
        liquid.setProviders(providers);
        dao.update(liquid);
    }

    @Override
    public void deleteDependencyProvider(LiquidDto liquidDto, Integer id) {
        Liquid liquid = mapper.dtoToEntity(liquidDto);
        Set<Provider> providers = liquid.getProviders();
        Iterator<Provider> iterator = providers.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                providers.remove(iterator.next());
            }
        }
        liquid.setProviders(providers);
        dao.update(liquid);
    }
}
