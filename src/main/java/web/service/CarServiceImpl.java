package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count > createCars().size()) {
            return createCars();
        }
        return IntStream.range(0, count).mapToObj(createCars()::get).collect(Collectors.toList());
    }

    @Override
    public List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("mers", 101, 2.3));
        cars.add(new Car("bmw", 1010, 3.3));
        cars.add(new Car("ford", 10101, 1.3));
        cars.add(new Car("ford", 10, 1.6));
        cars.add(new Car("лада", 12, 2.6));
        return cars;
    }
}
