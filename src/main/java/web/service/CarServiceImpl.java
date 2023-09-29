package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars(Integer count, List<Car> carList) {
        if (count == null || count > carList.size()) {
            return carList;
        }
        return IntStream.range(0, count).mapToObj(carList::get).collect(Collectors.toList());
    }
}
