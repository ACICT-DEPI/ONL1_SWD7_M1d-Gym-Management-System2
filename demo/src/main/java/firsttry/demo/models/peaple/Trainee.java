package firsttry.demo.models.peaple;

import firsttry.demo.models.papers.ExercisePlan;
import firsttry.demo.models.papers.Subscription;
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
@Table(name = "Trainee")
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    // @Column(name = "Name")
    // private String name;

    // @Column(name = "Email")
    // private String email;

    // @Column(name = "PhoneNumber")
    // private String phoneNumber;

    // @Column(name = "Password")
    // private String accountPass;

    // @Column(name = "Age")
    // private int age;

    
    // @Column(name = "SSR")
    // private String personSSR;

    @OneToOne
    @JoinColumn(name = "SSR", referencedColumnName = "SSR")
    private Person person;

    @Column(name = "Points")
    private int points;
    
    @OneToOne
    @JoinColumn(name = "SubscriptionID", referencedColumnName = "Id")
    private Subscription subscription;

    // @Column(name = "SubscriptionType")
    // private String subscriptionType;

    @OneToOne
    @JoinColumn(name = "ExercisePlanID", referencedColumnName = "Id")
    private ExercisePlan explan;
    
    // @Column(name = "ExercisePlan")
    // private String exPlan;

}
