package services;

import dto.AccessoryDto;
import dto.DescriptionDto;

import java.util.List;

public interface DescriptionService {
    DescriptionDto save(DescriptionDto descriptionDto);

    void update(DescriptionDto descriptionDto);

    void delete(DescriptionDto descriptionDto);

    List<DescriptionDto> findAll(DescriptionDto descriptionDto);
}
