package firsttry.demo.services;

import java.util.List;

import firsttry.demo.models.facility.Equipment;

public interface EquipmentService {
    List<Equipment> getEquipments();
    Equipment saveEquipment(Equipment equipment);
}
