package firsttry.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firsttry.demo.models.facility.GymHall;
import firsttry.demo.repositories.GymHallRepository;

@Service
public class GymHallServiceImpl implements GymHallService{

    @Autowired
    GymHallRepository gymHallRepository;

    @Override
    public List<GymHall> getGymHalls() {
        return gymHallRepository.findAll();
    }

    @Override
    public GymHall saveGymHall(GymHall gymHall) {
        List<GymHall> gymHalls = gymHallRepository.findByGymHallName(gymHall.getGymHallName());
        if(gymHalls.isEmpty()){
            return gymHallRepository.save(gymHall);
        }
        else{
            System.out.println("Gym Hall already Exists");
            return gymHalls.get(0);
        }
    }
    
}
