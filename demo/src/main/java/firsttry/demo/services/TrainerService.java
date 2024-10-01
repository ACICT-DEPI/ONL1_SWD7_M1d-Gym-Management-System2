package firsttry.demo.services;

import java.util.List;

import firsttry.demo.models.peaple.Trainer;

public interface TrainerService {
    List<Trainer> getTrainers();
    Trainer saveTrainer(Trainer trainer);
    Trainer getTrainer(int id);
    Trainer editTrainer(Trainer trainer);
    void deleteTrainer(Object pram);
}
