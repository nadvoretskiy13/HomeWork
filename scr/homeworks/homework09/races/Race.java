package homeworks.homework09.races;
import homeworks.homework09.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants = new ArrayList<>();

    public Race() {}

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

    public int getLength() {
        return length;
    }

    public String getRoute() {
        return route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public abstract Car determineWinner();

    @Override
    public String toString() {
        return String.format("Route: %s (%d km), Prize Pool: $%d, Participants: %d",
                route, length, prizePool, participants.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race)) return false;
        Race race = (Race) o;
        return length == race.length &&
                prizePool == race.prizePool &&
                Objects.equals(route, race.route) &&
                Objects.equals(participants, race.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prizePool, participants);
    }
}


