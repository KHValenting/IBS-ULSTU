package ru.ibs.ulstu.webapp.more.entity;

/**
 * Created by PDudarin on 27.11.2016.
 */
public abstract class Entity {

    static int curUniversalSequenceValue = 1;

    public static interface SequenceGenerator{
        static  int staticGetVal(){
            return  curUniversalSequenceValue++;
        }
        default int getVal(){
            return  staticGetVal();
        }
    }

    // для лекции
    public static class SequenceGen{
        public int getVal(){
            return Math.toIntExact(Math.round(Math.random() * 100000)*2);
        }
    }

    private int id;

    Entity(SequenceGenerator gen){
        this.id = gen.getVal(); //Идентификатор
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
