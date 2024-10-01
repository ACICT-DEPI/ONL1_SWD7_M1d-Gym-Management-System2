package firsttry.demo.services;

import java.util.List;

import firsttry.demo.models.peaple.Trainee;

public interface TraineeService {
    List<Trainee> getTrainees();
    Trainee saveTrainee(Trainee trainee);
    Trainee getTrainee(int id);
    Trainee editTrainee(Trainee trainee);
    // void deleteTrainee(int id);
    // void deleteTrainee(String ssr);
    void deleteTrainee(Object pram);
}
