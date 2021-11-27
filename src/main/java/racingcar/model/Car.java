package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car() {
        this("", 1);
    }

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public int getPosition() {
        return this.position;
    }

    public void run(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }
}
