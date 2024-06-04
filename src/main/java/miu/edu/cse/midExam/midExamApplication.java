package miu.edu.cse.midExam;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.midExam.model.House;
import miu.edu.cse.midExam.model.HouseOwner;
import miu.edu.cse.midExam.service.HouseOwnerService;
import miu.edu.cse.midExam.service.HouseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class midExamApplication implements CommandLineRunner {
    private final HouseOwnerService houseOwnerService;
    private final HouseService houseService;

    @Override
    public void run(String... args) throws Exception {
        // Add New house owners
        Optional<HouseOwner> houseOwner1  = houseOwnerService.addOwner(new HouseOwner("John", "Doe", "123456788"));
        Optional<HouseOwner> houseOwner2  = houseOwnerService.addOwner(new HouseOwner("Bob", "Doe",  "545677777"));



        // Add multiple houses to owner
        Optional<House> house = houseService.addHouse(new House(1, "Normal", "Street name 1"));
        Optional<House> house1 = houseService.addHouse(new House(2, "Normal", "Street name 2"));
        Optional<House> house2 = houseService.addHouse(new House(3, "Normal", "Street name 3"));

        List<House> houseList = new ArrayList<>();
        houseList.add(house1.get());
        houseList.add(house2.get());

        System.out.println(houseOwnerService.addMultipleHouseToHouseOwner(houseOwner1, houseList));


        // Update House owner data
        HouseOwner houseOwner = new HouseOwner("Jane", "Doe", "945677777");
        houseOwnerService.addOwner(houseOwner);

        houseOwner.setFirstName("Updated");
        houseOwner.setLastName("Updated");

        houseOwnerService.updateHouseOwner(houseOwner);


        // Sort house owner base on phone number
        List<HouseOwner> houseOwners = houseOwnerService.getAllHouseOwners();
        List<HouseOwner> sortedHouseOwners = houseOwners.stream().sorted(Comparator.comparing(HouseOwner::getPhoneNumber)).toList();
        sortedHouseOwners.forEach(System.out::println);


    }

    public static void main(String[] args) {
        SpringApplication.run(midExamApplication.class, args);
    }

}
