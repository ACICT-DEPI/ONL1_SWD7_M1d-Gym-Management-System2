package firsttry.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import firsttry.demo.models.peaple.Person;
import firsttry.demo.models.peaple.Trainee;
import firsttry.demo.models.papers.Subscription;


@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer>{
    List<Trainee> findById(int id);
    List<Trainee> findByPoints(int points);
    List<Trainee> findByPerson(Person person);
    List<Trainee> findBySubscription(Subscription subscription);
}
