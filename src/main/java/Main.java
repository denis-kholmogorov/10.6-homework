import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

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
        String hql = "select Student.id as student_id, Courses.id FROM PurchaseList JOIN Students ON Students.name = PurchaseList.student_name JOIN Courses ON Courses.name = PurchaseList.course_name";
        session.beginTransaction();
        Query id = session.createQuery(hql);
        System.out.println(id.getResultList());
//        StudentsAndCourses studentsAndCourse = new StudentsAndCourses();
//        studentsAndCourse.setCourseId(session.get(Course.class, 1));
//        studentsAndCourse.setStudentId(session.get(Student.class, 1));
//        session.save(studentsAndCourse);


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }
}
