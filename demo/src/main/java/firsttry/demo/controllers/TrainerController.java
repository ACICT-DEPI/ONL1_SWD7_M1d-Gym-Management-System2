package firsttry.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import firsttry.demo.models.peaple.Trainer;
import firsttry.demo.services.TrainerService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping("/trainers")  // Maps to root URL
    public List<Trainer> getTrainers() {
        return trainerService.getTrainers();
    }

    @GetMapping("/trainers/{id}")  // Maps to root URL
    public String getTrainre(@PathVariable Long id) {
        return "Fetching Trainee at id = " + id;
    }

    @PostMapping("/trainers")
    public Trainer saveTrainee(@RequestBody Trainer trainer) {

        return trainerService.saveTrainer(trainer);
    }
    
    @PutMapping("/trainers/{id}")
    public Trainer putMethodName(@PathVariable Long id, @RequestBody Trainer trainer) {
        System.out.println("Updating the Trainer data at id = " + id);        
        return trainer;
    }

    @DeleteMapping("/trainers")
    public String deleteTrainee(@RequestParam Long id){
        return "Deleting Trainee at id = " + id;
    }
}
