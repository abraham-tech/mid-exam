package miu.edu.cse.midExam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int houseNumber;
    private String streetName;
    private String houseType;

    public House(int houseNumber, String houseType, String streetName) {
        this.houseNumber = houseNumber;
        this.houseType = houseType;
        this.streetName = streetName;
    }

//    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
//    private List<HouseOwner> houseOwners;

    @ManyToOne
    @JoinColumn(name="house_id")
    private HouseOwner houseOwner;

    @Override
    public String toString() {
        return "House{" +
                "houseNumber=" + houseNumber +
                ", streetName='" + streetName + '\'' +
                ", houseType='" + houseType + '\'' +
                '}';
    }
}
