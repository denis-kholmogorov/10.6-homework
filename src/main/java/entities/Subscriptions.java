package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Subscriptions")
public class Subscriptions
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Course course;

    @Column(name = "subscription_date", columnDefinition = "DATE")
    private Date subscriptionDate;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourseId() {
        return course;
    }

    public void setCourseId(Course courseId) {
        this.course = courseId;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


}
