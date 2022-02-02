package guicetask.models;

import com.google.inject.Inject;
import lombok.Data;

@Data
public class Car {

    private Wheel leftBackWheel;
    private Wheel rightBackWheel;
    private Wheel leftForwardWheel;
    private Wheel rightForwardWheel;
    private Engine engine;

    @Inject
    public Car(Wheel leftBackWheel, Wheel rightBackWheel,
               Wheel leftForwardWheel, Wheel rightForwardWheel, Engine engine) {
        this.leftForwardWheel = leftForwardWheel;
        this.rightBackWheel = rightBackWheel;
        this.rightForwardWheel = rightForwardWheel;
        this.leftBackWheel = leftBackWheel;
        this.engine = engine;
    }

    public void printInfo() {
        System.out.println("Its a car");
    }
}
