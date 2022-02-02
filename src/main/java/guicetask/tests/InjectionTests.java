package guicetask.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guicetask.models.Car;
import guicetask.modules.CarModule;

public class InjectionTests {

    public static void main(String[] args) {
        Injector carInjector = Guice.createInjector(new CarModule());
        Car car = carInjector.getInstance(Car.class);
        car.printInfo();
        car.getEngine().printInfo();
        car.getLeftBackWheel().printInfo();
        car.getLeftBackWheel().getDisk().printInfo();
        car.getLeftBackWheel().getTire().printInfo();
        car.getEngine().getFuel().printInfo();
    }
}
