package io.codeforall.forsome;

import io.codeforall.forsome.Background.Background;
import io.codeforall.forsome.Grid.Grid;
import io.codeforall.forsome.Grid.GameGrid;
import io.codeforall.forsome.Grid.GridFactory;
import io.codeforall.forsome.PlayerStuff.Player;
import io.codeforall.forsome.Targets.Target;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import io.codeforall.forsome.Background.StartMenu;

public class Game {

    public final int MAX_TARGETS = 25;
    private Grid grid;
    private int delay;
    private Player player;
    private Target[] targets;
    private Keyboard keyboard;
    private Background background;
    private int highScore;
    private boolean gameOver;
    private int maxTargets;

    public Game(int cols, int rows, int delay) {
        createCanvas(cols, rows);
        this.grid = GridFactory.makeGrid(cols, rows);
        this.delay = delay;


    }

    public void createCanvas(int cols, int rows) {
        Canvas.getInstance();

        if (grid instanceof GameGrid) {
            GameGrid gameGrid = (GameGrid) grid;
            Canvas.limitCanvasWidth(gameGrid.rowToY(rows));
            Canvas.limitCanvasHeight(gameGrid.columnToX(cols));
        }
    }

    public void init() throws InterruptedException {
        grid.init();
        this.background = new StartMenu();
        this.background.createBackground();

        if(background instanceof StartMenu){
            StartMenu startMenu = (StartMenu) background;


        }

    }

}
