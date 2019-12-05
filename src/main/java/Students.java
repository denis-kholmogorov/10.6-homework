import javax.persistence.*;

import java.time.temporal.Temporal;
import java.util.Date;


@Entity
@Table(name = "Students")
public class Students
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(name = "registration_date", columnDefinition = "DATE")
    private Date registrationDay;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRegistrationDay(Date registrationDay) {
        this.registrationDay = registrationDay;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getRegistrationDay() {
        return registrationDay;
    }

}
