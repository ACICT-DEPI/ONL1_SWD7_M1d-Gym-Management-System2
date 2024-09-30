package firsttry.demo.models.peaple;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
// import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.Inheritance;
// import jakarta.persistence.InheritanceType;
// import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "SSR")
    private String ssr;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Password")
    private String accountPass;

    @Column(name = "Age")
    private int age;

    // @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    // private Trainee trainee;

    //Constructor
    public Person()
    {
        
    }

    public Person(String name, String ssr, String email)
    {
        this.setName(name);
        this.setSsr(ssr);
        this.setEmail(email);
    }

    public Person(String name, String ssr, String email, String phoneNumber, String accountPass, int age)
    {
        this(name, ssr, email);
        this.setSsr(ssr);
        this.setPhoneNumber(phoneNumber);
        this.setAccountPass(accountPass);
        this.setAge(age);
    }
}
