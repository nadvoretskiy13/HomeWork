package homework09;
import java.util.ArrayList;
import java.util.List;

public class Race {
    // Приватные поля
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    // Конструктор по умолчанию
    public Race() {
        participants = new ArrayList<>();
    }

    // Конструктор с параметрами
    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        participants = new ArrayList<>();
    }

    // Метод добавления участника
    public void addParticipant(Car car) {
        participants.add(car);
    }

    // Метод удаления участника
    public boolean removeParticipant(Car car) {
        return participants.remove(car);
    }

    // Геттеры и сеттеры
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prizePool=" + prizePool +
                ", participants=" + participants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return length == race.length &&
                prizePool == race.prizePool &&
                route.equals(race.route) &&
                participants.equals(race.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prizePool, participants);
    }
}


