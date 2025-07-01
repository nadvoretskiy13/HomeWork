package homework03;

import java.time.LocalDate;
import java.util.Scanner;

public class Television {
    Scanner scan = new Scanner(System.in);
    private String model;
    private int screenSize;
    private String screenResolution;
    private int productionYear;

    public Television(String model, int screenSize, String screenResolution, int productionYear) {
        this.model = model;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.productionYear = productionYear;
    }
    public Television(String model, int screenSize, String screenResolution) {
        this.model = model;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
    }
    public Television(String model, int screenSize) {
        this.model = model;
        this.screenSize = screenSize;
    }
    public String toString() {
        return "Television{" +
                "model=" + model +
                ", screenSize" + screenSize +
                ", screenResolution" + screenResolution +
                ", productionYear" + productionYear +
                '}';
        }

    }


