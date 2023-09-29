package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("")
    public String showCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> list = service.getCars(count, createCars());
        model.addAttribute("cars", list);
        return "cars";
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("mers", 101, 2.3));
        cars.add(new Car("bmw", 1010, 3.3));
        cars.add(new Car("ford", 10101, 1.3));
        cars.add(new Car("ford", 10, 1.6));
        cars.add(new Car("лада", 12, 2.6));
        return cars;
    }
}