package entities;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
@Subselect(
        value = "SELECT pl.id as id,  s.id as studentId, c.id as courseId " +
                "FROM PurchaseList pl " +
                "JOIN Students s ON s.name = pl.student_name " +
                "JOIN Courses c ON c.name = pl.course_name"
)
@Synchronize({"Students", "Courses"})
public class IdStudentIdCourse
{

    @Id
    private int id;

    private int studentId;

    private int courseId;

    public IdStudentIdCourse(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


}
