package entities;
import javax.persistence.*;

@Entity
@Table(name = "Students_and_Courses")
public class StudentsAndCourses
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Course course;

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudentId() {
        return student;
    }

    public void setStudentId(Student student) {this.student = student;}

    public Course getCourseId() {
        return course;
    }

    public void setCourseId(Course course) {
        this.course = course;
    }


}
