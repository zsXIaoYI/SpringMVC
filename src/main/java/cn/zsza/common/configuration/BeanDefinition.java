package cn.zsza.common.configuration;

import cn.zsza.dailyTest.spring4.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2017/5/5.
 * 16:41
 */
@Configuration
public class BeanDefinition {

    @Bean(name = "carr" )
    public Car buildCar(){
      Car car = new Car();
      car.setBrand("奔驰");
      car.setColor("蓝色");
      car.setMaxSpeed("300");

      return car;
    }

    @Bean
    public List<Car> carList(){
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car();
        car1.setBrand("奥迪");
        car1.setColor("red");
        car1.setMaxSpeed("223");

        Car car2 = new Car();
        car2.setBrand("奔驰");
        car2.setColor("black");
        car2.setMaxSpeed("225");

        carList.add(car1);
        carList.add(car2);

        return carList;

    }
}
