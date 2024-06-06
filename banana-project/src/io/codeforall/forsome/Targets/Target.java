package io.codeforall.forsome.Targets;

import io.codeforall.forsome.Grid.GameGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Target implements Destructible, Movable {
    // Propriedades
    private int x;
    private int y;
    private boolean isActive;
    private TargetType type;
    private GameGrid gameGrid;
    private static final int STEP_SIZE = 20; // Tamanho do passo do movimento

    // Construtor
    public Target(int x, int y, TargetType type, GameGrid gameGrid) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.isActive = true;
        this.gameGrid = gameGrid;
        createTarget();
    }

    @Override
    public void createTarget() {
        // Carregar a imagem correspondente ao tipo de alvo
       /*String imagePath = "";
         switch (type) {
            case MEKIE:
                imagePath = "resources/aim-small.png";
                break;
             case MAFALDA:
                imagePath = "resources/aim-small.png";
                break;
             case PAPANOZK:
                imagePath = "resources/aim-small.png";
                break;
        } */
        //Picture teste = new Picture();
        //teste.load("resources/aim-small.png");
        //teste.draw();
        System.out.println("Target created at position (" + x + ", " + y + ") with type " + type);
    }
    // NEW DELETE TARGET
    @Override
    public void deleteTarget() {
        this.isActive = false;
        //player.removeTarget(this);
        System.out.println("Target at position (" + x + ", " + y + ") is deleted.");
    }

    @Override
    public void move() {
        if (isActive) {
            if (x < gameGrid.getWidth()) {
                x += STEP_SIZE; // Move para a direita para dentro da tela
            } else {
                x = -STEP_SIZE; // Reinicia a posição horizontal quando sai do lado direito da tela
            }
            System.out.println(type + " Target moved to position (" + x + ", " + y + ")");
        } else {
            System.out.println("Cannot move. Target is inactive.");
        }
    }

    @Override
    public void checkCollision(Target target) {
        // Implementação do método de verificação de colisão
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


