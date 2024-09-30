package firsttry.demo.models.papers;

import java.time.LocalDate;

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
@Table(name = "Subscription")
public class Subscription {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Type")
	private String subscriptionType;

	@Column(name = "StartDate")
	private LocalDate startDate;

	@Column(name = "EndDate")
	private LocalDate endtDate;

	@Column(name = "Price")
	private double price;

	@Column(name = "Discount")
	private double discount;


    public void setSubscriptionType(String subscriptionType)
    {
        this.subscriptionType = subscriptionType;
        this.setStartDate(LocalDate.now());
        switch (subscriptionType.toLowerCase()) {
            case "bronze": {
                this.setEndtDate(this.getStartDate().plusDays(30));
                this.setPrice(50);
                break;
            }
            case "silver": {
                this.setEndtDate(this.getStartDate().plusDays(60));
                this.setPrice(80);
                break;
            }
            case "gold": {
                this.setEndtDate(this.getStartDate().plusDays(90));
                this.setPrice(100);
                break;
            }
            default:
                System.out.println("Unexpected value: " + subscriptionType);
            }
    }
}
