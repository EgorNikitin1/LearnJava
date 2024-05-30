package ru.muctr;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory factory;

    public static void prepareData() {
        factory = new Configuration().configure("configs/hibernate.cfg.xml").buildSessionFactory();

        Session session = null;

        try {
            String sqlString = Files.lines(Paths.get("init.sql")).collect(Collectors.joining());
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sqlString).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromDB() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Guitar guitar = session.get(Guitar.class, 1);
            System.out.println();
            System.out.println("Гитара 1: " + guitar.toString());
            System.out.println("Информация о гитаре 1: " + guitar.getGuitarInfo());
            System.out.println("Брэнд гитары 1: " + guitar.getBrand());
            System.out.println("Группа гитары 1: " + guitar.getGroups());
            session.getTransaction().commit();
        }
    }

    private static void deleteFromDB() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Guitar guitar = session.get(Guitar.class, 1);
            session.delete(guitar);
            session.getTransaction().commit();
        }
    }

    private static void addInDB() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Guitar guitar = new Guitar("Shecter", 2300);
            session.save(guitar);
            session.getTransaction().commit();
        }
    }

    private static void updateInDb() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Guitar guitar = session.get(Guitar.class, 3);
            guitar.setPrice(3500);
            guitar.setPrice(3700);

            session.getTransaction().commit();
            guitar.setPrice(3900);
            System.out.println(guitar.getPrice());
        }
    }

    private static void readWithJpql() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Guitar guitar1 = (Guitar) session.createQuery("select g from Guitar g where g.id = 2").getSingleResult();
            System.out.println(guitar1);

            Guitar guitar2 = (Guitar) session.createQuery("select g from Guitar g where g.name = ''", Guitar.class).getSingleResult();
            System.out.println(guitar2);

            List<Guitar> guitarList = session.createQuery("select g from Guitar g where g.price > 2000").getResultList();
            System.out.println(guitarList);

            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {

        prepareData();
        readFromDB();
        // deleteFromDB();
        // addInDB();
        // updateInDb();
        // readWithJpql();
        factory.close();


    }
}