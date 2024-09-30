package firsttry.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import firsttry.demo.models.facility.GymHall;
import firsttry.demo.services.GymHallService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class GymHallController {
    
    @Autowired
    private GymHallService gymHallService;

    @GetMapping("/halls")  // Maps to root URL
    public List<GymHall> getGymHalls() {
        return gymHallService.getGymHalls();
    }

    @GetMapping("/halls/{id}")  // Maps to root URL
    public String getGymHall(@PathVariable Long id) {
        return "Fetching hall at id = " + id;
    }

    @PostMapping("/halls")
    public GymHall saveEquipment(@RequestBody GymHall gymHall) {

        return gymHallService.saveGymHall(gymHall);
    }
    
    @PutMapping("/halls/{id}")
    public GymHall editGymHall(@PathVariable Long id, @RequestBody GymHall gymHall) {
        System.out.println("Updating the Gym Hall data at id = " + id);        
        return gymHall;
    }

    @DeleteMapping("/halls")
    public String deleteGymHall(@RequestParam Long id){
        return "Deleting Gym Hall at id = " + id;
    }
}
