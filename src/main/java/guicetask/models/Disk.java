package guicetask.models;

import com.google.inject.Inject;

public class Disk {

    @Inject
    public Disk() {}

    public void printInfo() {
        System.out.println("Its a disk");
    }
}
