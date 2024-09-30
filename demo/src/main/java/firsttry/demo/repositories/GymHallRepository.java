package firsttry.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import firsttry.demo.models.facility.GymHall;

@Repository
public interface GymHallRepository extends JpaRepository<GymHall, Integer>{
    List<GymHall> findByGymHallName(String gymHallName);
}
