package cn.zsza.dailyTest.spring4;

/**
 * Created by zs on 2017/5/5.
 * 15:17
 */
public class Car {
    private String brand;
    private String color;
    private String maxSpeed;

    public Car() {
        System.out.println("Car Constructor");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                '}';
    }
}
