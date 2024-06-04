package io.codeforall.forsome.Targets;

import java.util.Random;

public class Target implements Destructible, Movable {
    // Propriedades
    private int x;
    private int y;
    private boolean isActive;
    private static final int GRID_WIDTH = 100; //???
    private static final int GRID_HEIGHT = 100; // ????

    // Construtor
    public Target(int x, int y) {
        this.x = x;
        this.y = y;
        this.isActive = true;
        createTarget();
    }

    @Override
    public void createTarget() {
        System.out.println("Target created at position (" + x + ", " + y + ")");
    }

    @Override
    public void deleteTarget() {
        this.isActive = false;
        System.out.println("Target at position (" + x + ", " + y + ") is deleted.");
    }

    @Override
    public void move() {
        if (isActive) {
            x -= 1; // Movimento para a esquerda
            if (x < 0) { // Se o alvo sair da tela pela esquerda
                deleteTarget();
            } else {
                System.out.println("Target moved to position (" + x + ", " + y + ")");
            }
        } else {
            System.out.println("Cannot move. Target is inactive.");
        }
    }

    @Override
    public void checkCollision(Target target) {
        // Esta implementação não é necessária aqui
    }

    // Métodos adicionais que podem ser úteis
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isActive() {
        return isActive;
    }
}

