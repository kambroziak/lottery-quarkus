package pl.kambroziak.quarkus.entity;

import java.util.List;

public class GameDescriptor {

    private List<Integer> randomNumbers;

    private int gameLevel;

    public GameDescriptor(List<Integer> randomNumbers, int gameLevel) {
        this.randomNumbers = randomNumbers;
        this.gameLevel = gameLevel;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public int getGameLevel() {
        return gameLevel;
    }
}
