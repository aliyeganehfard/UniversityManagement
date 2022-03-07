package model.util;

import model.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SingleTonConnection {
    private SingleTonConnection(){}
    private static class LazyHolder{
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Professor.class)
                    .addAnnotatedClass(TrainingEmployee.class)
                    .addAnnotatedClass(College.class)
                    .addAnnotatedClass(Score.class)
                    .addAnnotatedClass(Course.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }
    public static SessionFactory getInstance(){
        return LazyHolder.INSTANCE;
    }
}
