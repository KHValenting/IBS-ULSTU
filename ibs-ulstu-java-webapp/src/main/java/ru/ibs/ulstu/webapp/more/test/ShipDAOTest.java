/**
 * 
 */
package ru.ibs.ulstu.webapp.more.test;

import ru.ibs.ulstu.webapp.more.dao.ShipDAO;
import ru.ibs.ulstu.webapp.more.dao.ShipDAOImpl;
import ru.ibs.ulstu.webapp.more.entity.Ship;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Автоматический тест на DAO судов
 * 
 * @author KHValentin
 * Created on 18 нояб. 2016 г.
 */
public class ShipDAOTest {

    // компаратор сортирует список или массив объектов по имени
    private static Comparator<Ship> shipComparator = new Comparator<Ship>() {
        @Override
        public int compare(Ship s1, Ship s2) {
            return -1*s1.compareTo(s2);
        }
    };

    private int errQty = 0;

    private static void getException() throws Exception
    {
        throw new Exception("!!!");
    }

    private static void printSortedList1(List<Ship> shipList){
        Collections.reverse(shipList);
        for (Ship ship: shipList) {
            System.out.print(" " + ship.getName());
        }
    }

    private static void printSortedList2(List<Ship> shipList){
        //Collections.sort(shipList, shipComparator);
        Collections.sort(shipList, new Comparator<Ship>() {
            @Override
            public int compare(Ship s1, Ship s2) {
                return -1*s1.compareTo(s2);
            }
        }
        );
        for (Ship ship: shipList) {
            System.out.print(" " + ship.getFlag() + " " + ship.getName());
        }
    }

	public static void main(String[] args){

		System.out.println("НАЧАЛО");

        try {
            // Обратите внимание, что вначале стоит интерфейc, а не класс
            ShipDAO dao = new ShipDAOImpl();

            //System.out.println(dao.list());
            printSortedList2(dao.list());
            //getException();

            System.out.println("\n\n Map by flags:" + dao.getFlagMap());
        } catch (Exception e) {
            System.out.println("Что-то пошло не так :( ");
        }

		System.out.println("КОНЕЦ");
	}
	
}


/*
public class Animal{  public void saySmth(){ System.out.println("Hello!"); }}

public class Dog extends Animal {

    @Override
    public void saySmth(){ System.out.println("Wow!"); }
}

public class Pig extends Animal {

    @Override
    public void saySmth(){ System.out.println("Hryu-hryu!"); }
}

void main(){

    Dog d = new Dog();
    Pig p = new Pig();

    Animal a = d;
    d.saySmth();
    a.saySmth();
    a = new Animal();
    a.saySmth();

    Object o = a;
    (Animal)o.saySmth();

}

*/










