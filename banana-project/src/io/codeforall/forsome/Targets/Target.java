package io.codeforall.forsome.Targets;

import java.util.Random;

public class Target implements Destructible, Movable {
    // Propriedades
    private int x;
    private int y;
    private boolean isActive;
    private TargetType type;

    private static final int GRID_WIDTH = 100; //???
    private static final int GRID_HEIGHT = 100; // ????


    // Construtor
    public Target(int x, int y, TargetType type) {
        this.x = x;
        this.y = y;
        this.type = type;
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

    public void move() {
        if (isActive) {
            int direction = new Random().nextInt(4);
            switch (direction) {
                case 0: // move left
                    if (x > 0) {
                        x -= 1;
                    }
                    break;
                case 1: // move right
                    if (x < GRID_WIDTH - 1) {
                        x += 1;
                    }
                    break;
                case 2: // move up
                    if (y > 0) {
                        y -= 1;
                    }
                    break;
                case 3: // move down
                    if (y < GRID_HEIGHT - 1) {
                        y += 1;
                    }
                    break;
            }
            System.out.println(type + " Target moved to position (" + x + ", " + y + ")");
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

