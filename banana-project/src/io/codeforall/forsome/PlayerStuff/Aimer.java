package io.codeforall.forsome.PlayerStuff;

import io.codeforall.forsome.Targets.Movable;
import io.codeforall.forsome.Targets.Target;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Aimer implements Movable {
    // Propriedades
    private int x;
    private int y;


    // Construtor
    public Aimer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move() {
        x += 1; // Move para a direita
        y += 1; // Move para baixo
        System.out.println("Aimer moved to position (" + x + ", " + y + ")");
    }

    @Override
    public void checkCollision(Target target) {
        if (x == target.getX() && y == target.getY()) {
            System.out.println("Collision detected at position (" + x + ", " + y + ")");
            target.deleteTarget();
        }
        System.out.println("No collision at position (" + x + ", " + y + ")");
    }


    // Métodos adicionais
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
