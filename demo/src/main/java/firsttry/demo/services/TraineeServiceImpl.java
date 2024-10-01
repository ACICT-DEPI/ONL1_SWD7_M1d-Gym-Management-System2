package firsttry.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firsttry.demo.models.papers.ExercisePlan;
import firsttry.demo.models.papers.Subscription;
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

    @Override
    public Trainee getTrainee(int id) {
        return traineeRepository.findById(id).get(0);
    }

    @Override
    public Trainee editTrainee(Trainee trainee) {
        List<Trainee> trainees = traineeRepository.findByPerson(trainee.getPerson());
        if(trainees.isEmpty()){
            System.out.println("No Such Trainee to be updated");
            return trainee;
        }
        else{
            ExercisePlan plan = trainee.getExplan();
            Subscription sub = trainee.getSubscription();
            plan.setId(trainees.get(0).getExplan().getId());
            sub.setId(trainees.get(0).getSubscription().getId());
            exercisePlanRepository.save(plan);
            subscriptionRepository.save(sub);
            return traineeRepository.save(trainee);
        }
    }


    @Override
    public void deleteTrainee(Object pram) {
        if(pram instanceof String){
            List<Person> persons = personRepository.findBySsr((String)pram);
            if(persons.isEmpty()){
                System.out.println("No Such Trainee to be deleted");
            }
            else{
                List<Trainee> trainees = traineeRepository.findByPerson(persons.get(0));
                traineeRepository.deleteById(trainees.get(0).getId());
            }
        }
        else if(pram instanceof Integer){
            Optional<Trainee> trainees = traineeRepository.findById((Integer)pram);
            if(trainees.isPresent()){
                traineeRepository.deleteById((Integer)pram);
            }
            else{
                System.out.println("No Such Trainee to be deleted");
            }
        }
    }
    
}
