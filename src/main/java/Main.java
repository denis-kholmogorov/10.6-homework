import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main
{
    public static void main(String[] args)
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Students student = session.get(Students.class, 5);
        Courses course = session.get(Courses.class, 5);
        Teachers teacher = session.get(Teachers.class, 1);

        System.out.println("Название курса - " + course.getName());
        System.out.println(course.getTeacherId().getName());
        System.out.println("Учитель под номером 1 - " + teacher.getName());
        System.out.println(course.getStudents().size());
        System.out.println(student.getCourses().size());

        session.close();
        sessionFactory.close();


    }
}