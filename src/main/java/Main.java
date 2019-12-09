import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Courses> query = builder.createQuery(Courses.class);
        Root<Courses> root = query.from(Courses.class);
        query.select(root);
        /*List<Courses> coursesList = session.createQuery(query).getResultList();
        coursesList.forEach(c ->{
            System.out.println(c.getName());
        });*/

        Courses course = session.get(Courses.class, 2);
        System.out.println(course.getTeacherId().getName());


        session.close();
        sessionFactory.close();


    }
}