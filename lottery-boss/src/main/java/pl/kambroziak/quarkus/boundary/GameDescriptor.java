package pl.kambroziak.quarkus.boundary;

import java.util.List;

public class GameDescriptor {

    private List<Integer> randomNumbers;

    private int gameLevel;

    public GameDescriptor(List<Integer> randomNumbers, int gameLevel) {
        this.randomNumbers = randomNumbers;
        this.gameLevel = gameLevel;
    }

    @Override
    public String toString() {
        return "GameDescriptor{" +
                "randomNumbers=" + randomNumbers +
                ", gameLevel=" + gameLevel +
                '}';
    }
}
