/**
 * 
 */
package ru.ibs.ulstu.webapp.more.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.ibs.ulstu.webapp.more.entity.Ship;

/**
 * Реализация интерфейса DAO судов. Представляет собой Mock - данные зашиты прямо тут. Не для промышленного использования
 * 
 * @author KHValentin
 * Created on 18 нояб. 2016 г.
 */
public class ShipDAOImpl implements ShipDAO {

	// Формат даты для вывода в текстовых полях типа "Дата позиции"
	private static final DateFormat DF = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss z");//16.10.2016 12:40:43 UTC
	// Кол-во судов, который будут сгененрированы автоматически
	private static final int SHIP_LIST_SIZE = 100;
	
	private static List<Ship> list = new ArrayList<Ship>();
	
	{
		for (int i=0;i<SHIP_LIST_SIZE;i++){
			list.add(new Ship(i+1, "Наименование "+i, "Наименование лат "+i, "CALL_SIGN_"+i, "00"+i, "11"+i, Math.random()>0.5,
					Math.random()>0.5, Math.random()>0.5, i+1, i+1, "ru_RU", DF.format(new Date()),
					"АИС", "69° 02.711' N - 33° 04.314' E", "12.0", "30.5"));
		}
		
	}
	
	@Override
	public Ship getById(int id) {
		for (Ship ship:list){
			if (ship.getId() == id)
				return ship;
		}
		return null;
	}

	@Override
	public List<Ship> list() {
		return list;
	}

	@Override
	public List<Ship> filterByName(String name) {
		List<Ship> result = new ArrayList<Ship>();
		for (Ship ship:list){
			if ((ship.getName() != null)&&(ship.getName().toLowerCase().indexOf(name.toLowerCase()) != -1))
				result.add(ship);
		}
		return result;
	}

	@Override
	public List<Ship> filterByMmsi(String mmsi) {
		List<Ship> result = new ArrayList<Ship>();
		for (Ship ship:list){
			if ((ship.getMmsi() != null)&&(ship.getMmsi().toLowerCase().indexOf(mmsi.toLowerCase()) != -1))
				result.add(ship);
		}
		return result;
	}

}
