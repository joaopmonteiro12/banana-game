package io.codeforall.forsome.Targets;

import io.codeforall.forsome.Grid.GameGrid;

import java.util.Random;

public class TargetFactory {

    private GameGrid gameGrid;

    public TargetFactory(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public Target createTarget() {
        Random random = new Random();
        TargetType type = TargetType.values()[random.nextInt(TargetType.values().length)];

        // Define a posição inicial do alvo fora da tela
        int x = -20; // Começa fora da tela à esquerda
        int y = random.nextInt(gameGrid.getHeight()); // Em uma posição aleatória verticalmente

        return new Target(x, y, type, gameGrid);
    }
}
