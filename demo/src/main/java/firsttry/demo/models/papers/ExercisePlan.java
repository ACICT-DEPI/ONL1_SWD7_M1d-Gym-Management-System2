package firsttry.demo.models.papers;

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
@Table(name = "ExercisePlan")
public class ExercisePlan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id = 0;

	@Column(name = "Steps")
	private String exerciseSteps;

	@Column(name = "Duration")
	private int exerciseDuration;
}
