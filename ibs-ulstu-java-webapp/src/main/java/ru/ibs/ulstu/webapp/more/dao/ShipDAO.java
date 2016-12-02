/**
 * 
 */
package ru.ibs.ulstu.webapp.more.dao;

import java.util.List;
import java.util.Map;

import ru.ibs.ulstu.webapp.more.entity.Ship;

/**
 * Интерфейс для реализации DAO судов
 * 
 * @author KHValentin
 * Created on 18 нояб. 2016 г.
 */
public interface ShipDAO {

	enum Flags{

		RU("ru_RU"), EN("en_EN"), FR("fr_FR"), GB("gb_GB");
		String value;

		Flags(String value)
		{
			this.value = value;
		}
		@Override
		public String toString()
		{
			return value;
		}

		public static String getName(int order){
			switch (order){
				case 0: return "RU";
				case 1: return "EN";
				case 2: return "FR";
				case 3: return "GB";
				default: return "RU";
			}
		}

		public static String getName(String s){
			switch (s){
				case "ru_RU": return "RU";
				case "en_EN": return "EN";
				case "fr_FR": return "FR";
				case "gb_GB": return "GB";
				default: return "RU";
			}
		}

	}


	public Ship getById(int id); //Получение корабля по его идентификатору
	public List<Ship> list(); //Получение полного списка кораблей

	//Получение отфильтрованных списков кораблей
	public List<Ship> filterByName(String name);
	public List<Ship> filterByMmsi(String mmsi);
	public Map<Flags, List<Ship>> getFlagMap();
}
