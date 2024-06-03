package io.codeforall.forsome.Targets;

public class Target implements Destructible, Movable {

    //PROPRIEDADES
    private int x;
    private int y;
    private boolean isActive;

    public Target(int x, int y) {
        this.x = x;
        this.y = y;
        this.isActive = true;
        createTarget();
    }

    @Override
    public void createTarget() {

    }

    @Override
    public void deleteTarget() {
        this.isActive = false;
    }

    @Override
    public void move() {
    if (isActive) {
        x += 1; // Movimento básico, incrementa a posição x
    }
    }

    @Override
    public void checkCollision() {

    }
}
