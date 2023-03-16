package services.serviceImpl;

import dao.DaoCartridge;
import dao.DaoDescription;
import dao.daoImpl.DaoCartridgeImpl;
import dao.daoImpl.DaoDescriptionImpl;
import dto.DescriptionDto;
import entity.Cartridge;
import entity.Description;
import mapper.CartridgeMapper;
import mapper.DescriptionMapper;
import mapper.impl.CartridgeMapperImpl;
import mapper.impl.DescriptionMapperImpl;
import services.DescriptionService;

import java.util.List;
import java.util.stream.Collectors;

public class DescriptionServiceImpl implements DescriptionService {

    private DaoDescription dao = new DaoDescriptionImpl();
    private DescriptionMapper mapper = new DescriptionMapperImpl();
    private Description description;

    @Override
    public DescriptionDto save(DescriptionDto descriptionDto) {
        Description description = mapper.dtoToEntity(descriptionDto);
        dao.save(description);
        return descriptionDto;
    }

    @Override
    public void update(DescriptionDto descriptionDto) {
        dao.update(mapper.dtoToEntity(descriptionDto));
    }

    @Override
    public void delete(DescriptionDto descriptionDto) {
        dao.delete(mapper.dtoToEntity(descriptionDto));
    }

    @Override
    public List<DescriptionDto> findAll(DescriptionDto descriptionDto) {
        return dao.findAll(description)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
