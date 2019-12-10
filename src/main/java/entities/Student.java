package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(name = "registration_date", columnDefinition = "DATE")
    private Date registrationDay;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
        joinColumns = {@JoinColumn(name = "student_id")},
        inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> coursesFromSubcrip;


    public Student() {
    }

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

    public List<Course> getCoursesFromSubcrip() {
        return coursesFromSubcrip;
    }

    public void setCoursesFromSubcrip(List<Course> coursesFromSubcrip) {
        this.coursesFromSubcrip = coursesFromSubcrip;
    }
}
