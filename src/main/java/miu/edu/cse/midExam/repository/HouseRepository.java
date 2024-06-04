package miu.edu.cse.midExam.repository;

import miu.edu.cse.midExam.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
