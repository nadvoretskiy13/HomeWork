package main.java.homeworks.homework16.races;

import main.java.homeworks.homework16.cars.Car;
import java.util.ArrayList;
import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants = new ArrayList<>();

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
    }

    public void addParticipant(Car car) {
        participants.add(car);
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public abstract Car determineWinner();
}


