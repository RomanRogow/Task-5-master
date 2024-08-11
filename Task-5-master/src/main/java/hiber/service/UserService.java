package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    List<User> getCarModelSeries(String model,int series);
}
