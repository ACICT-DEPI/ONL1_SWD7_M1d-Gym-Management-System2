package firsttry.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firsttry.demo.models.facility.Equipment;
import firsttry.demo.models.facility.GymHall;
import firsttry.demo.repositories.EquipmentRepository;
import firsttry.demo.repositories.GymHallRepository;
import jakarta.transaction.Transactional;

@Service
public class EquipmentServiceImpl implements EquipmentService{

    @Autowired
    GymHallRepository gymHallRepository;

    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getEquipments() {
        return equipmentRepository.findAll();
    }

    @Transactional
    @Override
    public Equipment saveEquipment(Equipment equipment) {
        List <GymHall> gymHallOpt = gymHallRepository.findByGymHallName(equipment.getGymHall().getGymHallName());
        if(gymHallOpt.isEmpty()){
            System.out.println("No such Gym Hall");
            return equipment;
        }
        else{
            System.out.println("Gym Hall found");
            equipment.setGymHall(gymHallOpt.get(0));
            return equipmentRepository.save(equipment);
        }
    }
    
}
