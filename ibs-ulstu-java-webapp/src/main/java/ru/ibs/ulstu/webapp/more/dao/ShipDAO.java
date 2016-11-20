/**
 * 
 */
package ru.ibs.ulstu.webapp.more.dao;

import java.util.List;

import ru.ibs.ulstu.webapp.more.entity.Ship;

/**
 * Интерфейс для реализации DAO судов
 * 
 * @author KHValentin
 * Created on 18 нояб. 2016 г.
 */
public interface ShipDAO {

	public Ship getById(int id);
	public List<Ship> list();
	public List<Ship> filterByName(String name);
	public List<Ship> filterByMmsi(String mmsi);
	
}
