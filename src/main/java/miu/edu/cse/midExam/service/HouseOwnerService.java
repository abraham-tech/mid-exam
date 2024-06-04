package miu.edu.cse.midExam.service;

import miu.edu.cse.midExam.model.House;
import miu.edu.cse.midExam.model.HouseOwner;

import java.util.List;
import java.util.Optional;

public interface HouseOwnerService {
    Optional<HouseOwner> addOwner(HouseOwner houseOwner);
    Optional<HouseOwner> updateHouseOwner(HouseOwner houseOwner);
    void deleteHouseOwner(HouseOwner houseOwner);
    List<HouseOwner> getAllHouseOwners();
//    Optional<HouseOwner> addHouseToHouseOwner(Optional<HouseOwner> houseOwner, House house);
    Optional<HouseOwner> addMultipleHouseToHouseOwner(Optional<HouseOwner> owner, List<House> houses);
}
