package firsttry.demo.models.facility;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name = "GymHall")
public class GymHall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
    @Column(name = "Name")
    private String gymHallName;
}
