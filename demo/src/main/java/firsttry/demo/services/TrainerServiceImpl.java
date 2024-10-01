package firsttry.demo.services;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteTrainer(Object pram) {
        if(pram instanceof Integer){
            Optional<Trainer> trainers = trainerRepository.findById((Integer)pram);
            if(trainers.isPresent()){
                trainerRepository.deleteById((Integer)pram);
            }
            else{
                System.out.println("No Such Trainer to be deleted");
            }
        }
        else if(pram instanceof String){
            List<Person> persons = personRepository.findBySsr((String)pram);
            if(persons.isEmpty()){
                System.out.println("No Such Trainer to be deleted");
            }
            else{
                List<Trainer> trainers = trainerRepository.findByPerson(persons.get(0));
                trainerRepository.deleteById(trainers.get(0).getId());
            }
        }
    }

    @Override
    public Trainer getTrainer(int id) {
        return trainerRepository.findById(id).get(0);
    }

    @Override
    public Trainer editTrainer(Trainer trainer) {
        List<Trainer> trainers = trainerRepository.findByPerson(trainer.getPerson());
        List<GymHall> gymHalls = gymHallRepository.findByGymHallName(trainer.getGymHall().getGymHallName());
        if(trainers.isEmpty()){
            System.out.println("No such Trainer to be updated.");
            return trainer;
        }
        else{
            if(gymHalls.isEmpty()){
                System.out.println("No such Gym Hall");
                return trainer;
            }
            else{
                trainer.setGymHall(gymHalls.get(0));
                return trainerRepository.save(trainer);
            }
        }
    }

   
    
}
