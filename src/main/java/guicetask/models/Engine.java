package guicetask.models;

import com.google.inject.Inject;
import lombok.Data;

@Data
public class Engine {

    private Fuel fuel;

    @Inject
    public Engine(Fuel fuel) {
        this.fuel = fuel;
    }

    public void printInfo() {
        System.out.println("Its an engine");
    }
}
