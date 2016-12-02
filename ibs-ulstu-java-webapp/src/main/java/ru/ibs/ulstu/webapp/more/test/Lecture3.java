package ru.ibs.ulstu.webapp.more.test;

import ru.ibs.ulstu.webapp.more.dao.ShipDAO;
import ru.ibs.ulstu.webapp.more.dao.ShipDAOImpl;
import ru.ibs.ulstu.webapp.more.entity.Ship;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by PDudarin on 26.11.2016.
 */
public class Lecture3 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {

        Class c = Class.forName("ru.ibs.ulstu.webapp.more.dao.ShipDAOImpl");
        // Print out implemented interfaces
        Class[] interfaces = c.getInterfaces();
        for (int i = 0, size = interfaces.length; i < size; i++) {
            System.out.print(i == 0 ? "implements " : ", ");
            System.out.print(interfaces[i].getSimpleName());
        }
        System.out.println();

        // Prints all the properties
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\t" + field.getName() + ";");
            if (field.getName() == "SHIP_LIST_SIZE"){
                field.setAccessible(true);
                System.out.println("\t" + field.getInt(null) + ";");
            }
        }

        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            Annotation[] annotations = m.getAnnotations();
            System.out.print("\t");
            for (Annotation a : annotations)
                System.out.print("@" + a.annotationType().getSimpleName() + " ");
            System.out.println();

            System.out.print("\t" + m.getModifiers() + m.getReturnType() + " " + m.getName() + "(");
            System.out.print(m.getParameterTypes());
            System.out.println(") { }");
        }

    }

}
