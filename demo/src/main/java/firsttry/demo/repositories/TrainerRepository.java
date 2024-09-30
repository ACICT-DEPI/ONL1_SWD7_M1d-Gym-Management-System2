package firsttry.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import firsttry.demo.models.peaple.Person;
import firsttry.demo.models.peaple.Trainer;
import firsttry.demo.models.facility.GymHall;


@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
    List<Trainer> findById(int id);
    List<Trainer> findByGymHall(GymHall gymHall);
    List<Trainer> findByPerson(Person person);
    List<Trainer> findByRating(double rating);
    List<Trainer> findBySalary(double salary);
    List<Trainer> findByWorkingHours(int workingHours);
}
