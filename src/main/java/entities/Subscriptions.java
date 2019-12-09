package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Subscriptions")
public class Subscriptions
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "student_id")
    private Integer student;

    @Column(name = "course_id")
    private Integer course;

    @Column(name = "subscription_date", columnDefinition = "DATE")
    private Date subscriptionDate;


    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getCourseId() {
        return course;
    }

    public void setCourseId(Integer courseId) {
        this.course = courseId;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


}
