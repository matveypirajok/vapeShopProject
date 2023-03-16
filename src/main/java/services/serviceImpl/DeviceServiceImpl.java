package services.serviceImpl;

import dao.DaoDescription;
import dao.DaoDevice;
import dao.DaoProvider;
import dao.DaoShop;
import dao.daoImpl.DaoDescriptionImpl;
import dao.daoImpl.DaoDeviceImpl;
import dao.daoImpl.DaoProviderImpl;
import dao.daoImpl.DaoShopImpl;
import dto.DeviceDto;
import entity.Cartridge;
import entity.Description;
import entity.Device;
import entity.Provider;
import mapper.DescriptionMapper;
import mapper.DeviceMapper;
import mapper.impl.DescriptionMapperImpl;
import mapper.impl.DeviceMapperImpl;
import services.DeviceService;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeviceServiceImpl implements DeviceService {

    private DaoDevice dao = new DaoDeviceImpl();
    private DeviceMapper mapper = new DeviceMapperImpl();
    private DaoDescription daoDescription = new DaoDescriptionImpl();
    private DaoProvider daoProvider = new DaoProviderImpl();
    private DaoShop daoShop = new DaoShopImpl();
    private Device device;

    @Override
    public DeviceDto save(DeviceDto deviceDto) {
        Device device = mapper.dtoToEntity(deviceDto);
        dao.save(device);
        return deviceDto;
    }

    @Override
    public void update(DeviceDto deviceDto) {
        dao.update(mapper.dtoToEntity(deviceDto));
    }

    @Override
    public void delete(DeviceDto deviceDto) {
        dao.delete(mapper.dtoToEntity(deviceDto));
    }

    @Override
    public List<DeviceDto> findAll(DeviceDto deviceDto) {
        return dao.findAll(device)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addDependencyDescription(DeviceDto deviceDto, Integer descriptionId) {
        Device device = mapper.dtoToEntity(deviceDto);
        device.setDescription(daoDescription.findDescriptionById(descriptionId));
        dao.update(device);
    }

    @Override
    public void deleteDependencyDescription(DeviceDto deviceDto) {
        Device device = mapper.dtoToEntity(deviceDto);
        device.setDescription(null);
        dao.update(device);
    }

    @Override
    public void addDependencyShop(DeviceDto deviceDto, Integer shopId) {
        Device device = mapper.dtoToEntity(deviceDto);
        device.setShop(daoShop.findShopById(shopId));
        dao.update(device);
    }

    @Override
    public void deleteDependencyShop(DeviceDto deviceDto) {
        Device device = mapper.dtoToEntity(deviceDto);
        device.setShop(null);
        dao.update(device);
    }

    @Override
    public void addDependencyProvider(DeviceDto deviceDto, Integer providerId) {
        Device device = mapper.dtoToEntity(deviceDto);
        Set<Provider> providers = device.getProviders();
        providers.add(daoProvider.findProviderById(providerId));
        device.setProviders(providers);
        dao.update(device);
    }

    @Override
    public void deleteDependencyProvider(DeviceDto deviceDto, Integer id) {
        Device device = mapper.dtoToEntity(deviceDto);
        Set<Provider> providers = device.getProviders();
        Iterator<Provider> iterator = providers.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                providers.remove(iterator.next());
            }
        }
        device.setProviders(providers);
        dao.update(device);
    }
}
