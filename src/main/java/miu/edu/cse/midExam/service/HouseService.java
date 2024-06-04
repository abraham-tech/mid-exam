package miu.edu.cse.midExam.service;


import miu.edu.cse.midExam.model.House;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    Optional<House> addHouse(House house);
    Optional<House> updateHouse(House house);
    void deleteHouse(House house);
    List<House> getAllHouses();
}
