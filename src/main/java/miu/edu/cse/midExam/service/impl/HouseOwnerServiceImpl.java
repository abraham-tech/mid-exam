package miu.edu.cse.midExam.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.midExam.model.House;
import miu.edu.cse.midExam.model.HouseOwner;
import miu.edu.cse.midExam.repository.HouseOwnerRepository;
import miu.edu.cse.midExam.repository.HouseRepository;
import miu.edu.cse.midExam.service.HouseOwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseOwnerServiceImpl implements HouseOwnerService {
    final HouseOwnerRepository houseOwnerRepository;
    final HouseRepository houseRepository;

    @Override
    public Optional<HouseOwner> addOwner(HouseOwner houseOwner) {
        return Optional.of(houseOwnerRepository.save(houseOwner));
    }

    @Override
    public Optional<HouseOwner> updateHouseOwner(HouseOwner houseOwner) {
        houseOwnerRepository.findById(houseOwner.getId()).ifPresent(h -> houseOwnerRepository.save(houseOwner));
        return Optional.of(houseOwner);
    }

    @Override
    public void deleteHouseOwner(HouseOwner houseOwner) {
        houseOwnerRepository.findById(houseOwner.getId()).ifPresent(h -> houseOwnerRepository.delete(houseOwner));
    }

    @Override
    public List<HouseOwner> getAllHouseOwners() {
        return houseOwnerRepository.findAll();
    }

//    @Override
//    public Optional<HouseOwner> addHouseToHouseOwner(Optional<HouseOwner> houseOwner, House house) {
//        houseOwnerRepository.findById(houseOwner.get().getId()).ifPresent(h -> {
//            h.setOwnedHouses(house);
//            houseOwnerRepository.save(h);
//        });
//        return houseOwnerRepository.findById(houseOwner.get().getId());
//
//    }

    @Override
    public Optional<HouseOwner> addMultipleHouseToHouseOwner(Optional<HouseOwner> houseOwner, List<House> houses) {
        houseOwnerRepository.findById(houseOwner.get().getId()).ifPresent(h -> {
            h.setOwnedHouses(houses);
//            houses.stream().map(house -> {
//                h.setOwnedHouses(house.get());
//                return null;
//            });
            houseOwnerRepository.save(h);
        });
        return houseOwnerRepository.findById(houseOwner.get().getId());
    }
}
