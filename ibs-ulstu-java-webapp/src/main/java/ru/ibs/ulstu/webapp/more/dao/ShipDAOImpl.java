/**
 * 
 */
package ru.ibs.ulstu.webapp.more.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.ibs.ulstu.webapp.more.entity.*;

/**
 * Реализация интерфейса DAO судов. Представляет собой Mock - данные зашиты прямо тут. Не для промышленного использования
 * 
 * @author KHValentin
 * Created on 18 нояб. 2016 г.
 */
public class ShipDAOImpl implements ShipDAO {


	// Формат даты для вывода в текстовых полях типа "Дата позиции"
	private static final DateFormat DF = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss z");//16.10.2016 12:40:43 UTC
	// Кол-во судов, которые будут сгенерированы автоматически
	private static final int SHIP_LIST_SIZE = 100;
	
	private static List<Ship> list = new ArrayList<>();
	
	{

        ObjectMapper mapper = new ObjectMapper();
        String jsonPath = "";
        //JSON from file to Object
        try {

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			Properties prop = new Properties();
			try {
				prop.load(classLoader.getResourceAsStream("app.properties"));
				jsonPath = prop.getProperty("json_path");
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}

			if (jsonPath == "") {
                jsonPath="D:\\Projects\\Java курсы Политех\\project\\ibs-ulstu-java-webapp\\src\\main\\webapp\\app\\testdata\\ships.json";
            }

			ShipsDTO shipsDTO = mapper.readValue(new File(jsonPath), ShipsDTO.class);
            System.out.print("shipsDTO>> " + shipsDTO.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i=0;i<SHIP_LIST_SIZE;i++){
			list.add(new Ship3Impl(/*i+1,*/ "Наименование "+i, "Наименование лат "+i, "CALL_SIGN_"+i, "00"+i, "11"+i, Math.random()>0.5,
					Math.random()>0.5, Math.random()>0.5, i+1, i+1,
					Flags.valueOf(Flags.getName(Math.toIntExact(Math.round(Math.random()*100)%4))).toString(),
					DF.format(new Date()),
					"АИС", "69° 02.711' N - 33° 04.314' E", "12.0", "30.5"));
		}
		
	}
	
	@Override
    @Deprecated
	public Ship getById(int id) {
		for (Ship ship:list){
			if (ship.getId() == id)
				return ship;
		}
		return null;
	}

	@Override
	public List<Ship> list()
    {
        //Вариант 3
        //list.sort(Comparator.comparing(Ship::getFlag).thenComparing(Ship::getName));
        return list;
    }

//    {
//		return list;
//	}

	@Override
    @Deprecated
	public List<Ship> filterByName(String name) {
		List<Ship> result = new ArrayList<>();
		for (Ship ship:list){ //Тут IDE подсказывает нам, что разумнее было бы применить новый синтаксис, но займемся этим на следующем занятии
			if ((ship.getName() != null)&&(ship.getName().toLowerCase().indexOf(name.toLowerCase()) != -1))
				result.add(ship);
		}
		return result;
	}

	@Override
	public List<Ship> filterByMmsi(String mmsi) {
		List<Ship> result = new ArrayList<>();
		for (Ship ship:list){
			if ((ship.getMmsi() != null)&&(ship.getMmsi().toLowerCase().indexOf(mmsi.toLowerCase()) != -1))
				result.add(ship);
		}
		return result;
	}

	@Override
	public Map<Flags, List<Ship>> getFlagMap(){

        Map<Flags, List<Ship>> m = new HashMap<>();

        //Создадим все значения с пустыми списками
        for (Flags f: Flags.values()){
            m.put(f, new ArrayList<Ship>());
        }

        //Разложим корабли в карту
        for (Ship s: list()){
            List<Ship> l = m.get(Flags.valueOf(Flags.getName(s.getFlag())));
            l.add(s);
        }
        return m;
	}

}
