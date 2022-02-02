package guicetask.models;

import com.google.inject.Inject;
import lombok.Data;

@Data
public class Wheel {

    private Tire tire;
    private Disk disk;

    @Inject
    public Wheel(Tire tire, Disk disk) {
        this.tire = tire;
        this.disk = disk;
    }

    public void printInfo() {
        System.out.println("Its a wheel");
    }
}
