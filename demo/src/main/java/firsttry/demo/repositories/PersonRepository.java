package firsttry.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import firsttry.demo.models.peaple.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String>{
    List<Person> findBySsr(String ssr);
    List<Person> findByEmail(String email);
    List<Person> findByName(String name);
    List<Person> findByAge(int age);
}
