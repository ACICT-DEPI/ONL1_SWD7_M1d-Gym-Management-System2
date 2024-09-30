package firsttry.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import firsttry.demo.models.facility.Equipment;
import firsttry.demo.services.EquipmentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/equipments")  // Maps to root URL
    public List<Equipment> getTrainers() {
        return equipmentService.getEquipments();
    }

    @GetMapping("/equipments/{id}")  // Maps to root URL
    public String getEquipment(@PathVariable Long id) {
        return "Fetching Equipment at id = " + id;
    }

    @PostMapping("/equipments")
    public Equipment saveEquipment(@RequestBody Equipment equipment) {

        return equipmentService.saveEquipment(equipment);
    }
    
    @PutMapping("/equipments/{id}")
    public Equipment editEquipment(@PathVariable Long id, @RequestBody Equipment equipment) {
        System.out.println("Updating the Equipment data at id = " + id);        
        return equipment;
    }

    @DeleteMapping("/equipments")
    public String deleteEquipment(@RequestParam Long id){
        return "Deleting Equipment at id = " + id;
    }
}
