package ru.cetelem.supplier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ru.cetelem.supplier.domain.Car;

@Service
public class CarService {

	public List<Car> getCars(){
		List<Car> cars = new ArrayList();
		cars.add(new Car(1, "Car1", "Model1"));
		cars.add(new Car(2, "Car2", "Model2"));
		
		
		return cars;
	}
}
