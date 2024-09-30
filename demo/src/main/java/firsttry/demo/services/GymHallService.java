package firsttry.demo.services;

import java.util.List;

import firsttry.demo.models.facility.GymHall;

public interface GymHallService {
    List<GymHall> getGymHalls();
    GymHall saveGymHall(GymHall gymHall);
}
