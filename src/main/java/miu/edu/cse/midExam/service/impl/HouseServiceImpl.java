package miu.edu.cse.midExam.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.midExam.model.House;
import miu.edu.cse.midExam.repository.HouseRepository;
import miu.edu.cse.midExam.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public Optional<House> addHouse(House house) {
        return Optional.of(houseRepository.save(house));
    }

    @Override
    public Optional<House> updateHouse(House house) {
        houseRepository.findById(house.getId()).ifPresent(h -> houseRepository.save(house));
        return Optional.of(house);
    }

    @Override
    public void deleteHouse(House house) {
        houseRepository.findById(house.getId()).ifPresent(h -> houseRepository.delete(house));
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }
}
