package guicetask.models;

import com.google.inject.Inject;

public class Fuel {

    @Inject
    public Fuel() {}

    public void printInfo() {
        System.out.println("Its a fuel");
    }
}
