package firsttry.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firsttry.demo.models.peaple.Person;
import firsttry.demo.models.peaple.Trainee;
import firsttry.demo.repositories.ExercisePlanRepository;
import firsttry.demo.repositories.PersonRepository;
import firsttry.demo.repositories.SubscriptionRepository;
import firsttry.demo.repositories.TraineeRepository;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ExercisePlanRepository exercisePlanRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    TraineeRepository traineeRepository;

    @Override
    public List<Trainee> getTrainees() {
        return traineeRepository.findAll();
    }

    @Override
    public Trainee saveTrainee(Trainee trainee) {
        List<Person> persons = personRepository.findBySsr(trainee.getPerson().getSsr());
        if(persons.isEmpty()){
            personRepository.save(trainee.getPerson());
            exercisePlanRepository.save(trainee.getExplan());
            subscriptionRepository.save(trainee.getSubscription());
            return traineeRepository.save(trainee);
        }
        else{
            List<Trainee> trainees = traineeRepository.findByPerson(trainee.getPerson());
            if(trainees.isEmpty()){
                trainee.setPerson(persons.get(0));
                exercisePlanRepository.save(trainee.getExplan());
                subscriptionRepository.save(trainee.getSubscription());
                return traineeRepository.save(trainee);
            }
            else{
                System.out.println("Trainee already exists");
                return trainees.get(0);
            }
        }
    }
    
}
