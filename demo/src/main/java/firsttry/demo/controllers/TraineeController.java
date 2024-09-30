package firsttry.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import firsttry.demo.models.peaple.Trainee;
import firsttry.demo.services.TraineeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/trainees")  // Maps to root URL
    public List<Trainee> getTrainees() {
        return traineeService.getTrainees();
    }

    @GetMapping("/trainees/{id}")  // Maps to root URL
    public String getTrainee(@PathVariable Long id) {
        return "Fetching Trainee at id = " + id;
    }

    @PostMapping("/trainees")
    public Trainee saveTrainee(@RequestBody Trainee trainee) {

        return traineeService.saveTrainee(trainee);
    }
    
    @PutMapping("/trainees/{id}")
    public Trainee putMethodName(@PathVariable Long id, @RequestBody Trainee trainee) {
        System.out.println("Updating the Trainee data at id = " + id);        
        return trainee;
    }

    @DeleteMapping("/trainees")
    public String deleteTrainee(@RequestParam Long id){
        return "Deleting Trainee at id = " + id;
    }
}