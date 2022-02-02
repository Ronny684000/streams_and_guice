package guicetask.models;

import com.google.inject.Inject;

public class Tire {

    @Inject
    public Tire() {}

    public void printInfo() {
        System.out.println("Its a tire");
    }
}
