package homeworks.homework16.races;

import homeworks.homework16.cars.Car;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
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

    public abstract Car determineWinner();

    @Override
    public String toString() {
        return String.format("Route: %s (%d km), Prize Pool: $%d, Participants: %d",
                route, length, prizePool, participants.size());
    }
}



