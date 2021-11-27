package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int lastRound;

    public RacingGame(List<Car> cars, int lastRound) {
        this.cars = cars;
        this.lastRound = lastRound;
    }

    public int getLastRound() {
        return this.lastRound;
    }

    public void play() {
        cars.forEach((Car car) -> car.run(new RandomMoveStrategy()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        Car winner = Collections.max(cars);
        return cars.stream()
                .filter((Car car) -> car.isSamePosition(winner))
                .collect(Collectors.toList());
    }
}
