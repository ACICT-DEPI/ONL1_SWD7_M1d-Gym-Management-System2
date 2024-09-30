package firsttry.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import firsttry.demo.models.facility.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>{
    
}
