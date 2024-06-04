package miu.edu.cse.midExam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class HouseOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public HouseOwner(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @OneToMany( cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id")
    private List<House> ownedHouses = new ArrayList<>();


//    @ManyToOne
//    @JoinColumn(name="house_id")
//    private House house;

    @Override
    public String toString() {
        return "HouseOwner{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +", " +
                "phone='" + phoneNumber + '\'' +
                '}';
    }
}
