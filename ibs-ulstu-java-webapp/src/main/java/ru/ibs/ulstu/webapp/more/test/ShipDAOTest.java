/**
 * 
 */
package ru.ibs.ulstu.webapp.more.test;

import ru.ibs.ulstu.webapp.more.dao.ShipDAOImpl;

/**
 * Автоматический тест на DAO судов
 * 
 * @author KHValentin
 * Created on 18 нояб. 2016 г.
 */
public class ShipDAOTest {

	public static void main(String[] args){
		System.out.println("НАЧАЛО");
		ShipDAOImpl dao = new ShipDAOImpl();
		System.out.println(dao.list());
		System.out.println("КОНЕЦ");
	}
	
}
