package services.serviceImpl;

import dao.DaoLiquid;
import dao.DaoProvider;
import dao.daoImpl.DaoLiquidImpl;
import dao.daoImpl.DaoProviderImpl;
import dto.ProviderDto;
import entity.Liquid;
import entity.Provider;
import mapper.LiquidMapper;
import mapper.ProviderMapper;
import mapper.impl.LiquidMapperImpl;
import mapper.impl.ProviderMapperImpl;
import services.ProviderService;

import java.util.List;
import java.util.stream.Collectors;

public class ProviderServiceImpl implements ProviderService {

    private DaoProvider dao = new DaoProviderImpl();
    private ProviderMapper mapper = new ProviderMapperImpl();
    private Provider provider;

    @Override
    public ProviderDto save(ProviderDto providerDto) {
        Provider provider = mapper.dtoToEntity(providerDto);
        dao.save(provider);
        return providerDto;
    }

    @Override
    public void update(ProviderDto providerDto) {
        dao.update(mapper.dtoToEntity(providerDto));
    }

    @Override
    public void delete(ProviderDto providerDto) {
        dao.delete(mapper.dtoToEntity(providerDto));
    }

    @Override
    public List<ProviderDto> findAll(ProviderDto providerDto) {
        return dao.findAll(provider)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
