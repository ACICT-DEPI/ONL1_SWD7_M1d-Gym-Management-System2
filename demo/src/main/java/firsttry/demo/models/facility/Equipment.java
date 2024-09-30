package firsttry.demo.models.facility;

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
@Table(name = "Equipment")
public class Equipment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    @Column(name = "Name")
    private String equipmentName;

    @Column(name = "Type")
	private String equipmentType;

    @OneToOne
    @JoinColumn(name = "GymHallId", referencedColumnName = "Id")
    private GymHall gymHall;
}
