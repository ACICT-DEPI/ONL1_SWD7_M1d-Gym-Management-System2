package firsttry.demo.services;

import java.util.List;

import firsttry.demo.models.peaple.Trainee;

public interface TraineeService {
    List<Trainee> getTrainees();
    Trainee saveTrainee(Trainee trainee);
}
