import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<IdStudentIdCourse> query = builder.createQuery(IdStudentIdCourse.class);
        Root<IdStudentIdCourse> root = query.from(IdStudentIdCourse.class);
        query.select(root);

        List<IdStudentIdCourse> studentIdCourses = session.createQuery(query).getResultList();
        studentIdCourses.forEach(i->{
            StudentsAndCourses sac = new StudentsAndCourses();
            sac.setCourseId(session.get(Course.class, i.getCourseId()));
            sac.setStudentId(session.get(Student.class, i.getStudentId()));
            session.save(sac);
        });

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
