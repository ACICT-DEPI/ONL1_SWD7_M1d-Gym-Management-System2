package firsttry.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import firsttry.demo.models.papers.ExercisePlan;

@Repository
public interface ExercisePlanRepository extends JpaRepository<ExercisePlan, Integer>{
    
}
