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
            x -= 1; // Movimento básico para a esquerda
            if (x > 0) { // se o alvo sair da tela
                deleteTarget();
            }
        }

        System.out.println("Target inative");
    }

    @Override
    public void checkCollision(Target target) {

    }
// talvez seja útil

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
