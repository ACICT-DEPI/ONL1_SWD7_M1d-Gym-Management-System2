package firsttry.demo.models.peaple;

import firsttry.demo.models.facility.GymHall;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "Trainer")
public class Trainer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    @OneToOne
    @JoinColumn(name = "SSR", referencedColumnName = "SSR")
    private Person person;

    @Column(name = "WorkingHours")
    private int workingHours;

    @Column(name = "Rating")
	private double rating;

    @Column(name = "Salary")
	private double salary;
    
    @OneToOne
    @JoinColumn(name = "GymHallId", referencedColumnName = "Id")
    private GymHall gymHall;
    // @Column(name = "GymHallId")
	// private int assignedHall;
}
