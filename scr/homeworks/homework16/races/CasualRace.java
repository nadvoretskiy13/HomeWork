package homeworks.homework16.races;

import homeworks.homework09.cars.Car;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public Car determineWinner() {
        return getParticipants().stream()
                .max((a, b) -> {
                    int scoreA = a.getHorsepower() / a.getAcceleration() + a.getSuspension() + a.getDurability();
                    int scoreB = b.getHorsepower() / b.getAcceleration() + b.getSuspension() + b.getDurability();
                    return Integer.compare(scoreA, scoreB);
                })
                .orElse(null);
    }
}
