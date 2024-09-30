package firsttry.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firsttry.demo.models.facility.GymHall;
import firsttry.demo.models.peaple.Person;
import firsttry.demo.models.peaple.Trainer;
import firsttry.demo.repositories.GymHallRepository;
import firsttry.demo.repositories.PersonRepository;
import firsttry.demo.repositories.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    GymHallRepository gymHallRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public List<Trainer> getTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        List<Person> persons = personRepository.findBySsr(trainer.getPerson().getSsr());
        List<GymHall> gymHalls = gymHallRepository.findByGymHallName(trainer.getGymHall().getGymHallName());
        if(persons.isEmpty()){
            personRepository.save(trainer.getPerson());
            if(gymHalls.isEmpty()){
                System.out.println("No such Gym Hall");
                return trainer;
            }
            else{
                trainer.setGymHall(gymHalls.get(0));
                return trainerRepository.save(trainer);
            }
        }
        else{
            List<Trainer> trainers = trainerRepository.findByPerson(trainer.getPerson());
            if(trainers.isEmpty()){
                if(gymHalls.isEmpty()){
                    System.out.println("No such Gym Hall");
                    return trainer;
                }
                else{
                    trainer.setGymHall(gymHalls.get(0));
                    return trainerRepository.save(trainer);
                }
            }
            else{
                System.out.println("Trainer already exists");
                return trainers.get(0);
            }
        }
    }

   
    
}
