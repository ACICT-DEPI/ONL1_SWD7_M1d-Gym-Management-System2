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
    public Trainee getTrainee(@PathVariable Integer id) {
        return traineeService.getTrainee(id);
    }

    @PostMapping("/trainees")
    public Trainee saveTrainee(@RequestBody Trainee trainee) {
        return traineeService.saveTrainee(trainee);
    }
    
    @PutMapping("/trainees/{id}")
    public Trainee editTrainee(@PathVariable Integer id, @RequestBody Trainee trainee) {
        trainee.setId(id);        
        return traineeService.editTrainee(trainee);
    }

    @DeleteMapping("/trainees")
    public void deleteTrainee(@RequestParam(required = false) Integer id, @RequestParam(required = false) String ssr){
        if(id != null){
            traineeService.deleteTrainee(id);
        }
        else if(ssr != null){
            traineeService.deleteTrainee(ssr);
        }
        else{
            System.out.println("Either 'id' or 'name' must be provided.");
        }
    }

}