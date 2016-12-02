package ru.ibs.ulstu.webapp.more.test;

import ru.ibs.ulstu.webapp.more.dao.ShipDAO;
import ru.ibs.ulstu.webapp.more.dao.ShipDAOImpl;
import ru.ibs.ulstu.webapp.more.entity.Entity;
import ru.ibs.ulstu.webapp.more.entity.Ship;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by PDudarin on 26.11.2016.
 */
public class Lecture2{

    public static void main(String[] args) {

        ShipDAO dao = new ShipDAOImpl();

        //Вариант 1
        Collections.sort(dao.list(), new Comparator<Ship>() {
                    @Override
                    public int compare(Ship s1, Ship s2) {
                        return -1*s1.compareTo(s2);
                    }
                }
        );
        for (Ship ship: dao.list()) {
            System.out.print(" " + ship.getFlag() + " " + ship.getName());
        }

        //Вариант 2
        Collections.sort(dao.list(), (s1, s2) -> -1*s1.compareTo(s2));

        for (Ship ship: dao.list()) {
            System.out.print(" " + ship.getFlag() + " " + ship.getName());
        }

        //Вариант 3
        dao.list().sort(Comparator.comparing(Ship::getFlag).thenComparing(Ship::getName));
        for (Ship ship: dao.list()) {
            System.out.print(" " + ship.getFlag() + " " + ship.getName());
        }


    }
    /*
    // Перечисления
    enum Season {

        WINTER("Зима"), SPRING("Весна"), SUMMER("Лето"), AUTUMN("Осень");

        String value;
        Season(String value)
        {
            this.value = value;
        }
        @Override
        public String toString()
        {
            return value;
        }
    }
    */

    /*
    public static void main(String[] args) {

        Season season = Season.SPRING;
        if (season == Season.SPRING) season = Season.SUMMER;
        System.out.println(season);
        System.out.println(season.ordinal());

        season = Season.valueOf("AUTUMN");
        System.out.println(Arrays.toString(Season.values()));
    }
    */
    /*
    // Анонимные классы
    static abstract class SimpleAbstract{
        int p;
        public SimpleAbstract(int p){
          this.p = p;
        }
        public int getP() {
            return p;
        }
    }

    public static void main(String[] args) {
        SimpleAbstract sa = new SimpleAbstract(10){
            {
                p++;
            }
        };
        System.out.print("P value: " + sa.getP());
    }
   */


   /*
   // Использование внутреннего класса
  public static void main(String[] args) {
      Entity.SequenceGen g = new Entity.SequenceGen(); // Обратите внимание что Entity абстрактный!
      System.out.print("Generated value: " + g.getVal());
  }
  */
}
