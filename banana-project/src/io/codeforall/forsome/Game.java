package io.codeforall.forsome;

import io.codeforall.forsome.Background.Background;
import io.codeforall.forsome.Background.GameBackground;
import io.codeforall.forsome.Grid.Grid;
import io.codeforall.forsome.Grid.GameGrid;
import io.codeforall.forsome.Grid.GridFactory;
import io.codeforall.forsome.Targets.Movable;
import io.codeforall.forsome.Targets.Target;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import io.codeforall.forsome.Background.StartMenu;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    public final int MAX_TARGETS = 25;
    private Grid grid;
    private int delay;
    private Player player;
    private Target[] targets;
    private Keyboard keyboard;
    private Background background;
    private int highScore;
    private int currentScore;
    private boolean gameOver;
    private int maxTargets;

    public Game(int cols, int rows, int delay) {
        createCanvas(cols, rows);
        this.grid = GridFactory.makeGrid(cols, rows);
        this.delay = delay;
        this.gameOver = false;
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

        this.background = new StartMenu();
        this.background.createBackground();

       /* if(background instanceof StartMenu){
            StartMenu startMenu = (StartMenu) background;


        }*/

    }

    public void startGame() {
        //BACKGROUND && GRID
        grid.init();
        this.background = new GameBackground();
        this.background.createBackground();
        this.currentScore = 0;
        String score = "Score: " + this.currentScore;
        this.maxTargets = MAX_TARGETS;

        //SCORE
        Text playerScore = new Text(900, 30, score);
        playerScore.draw();
        playerScore.grow(40, 30);

        this.player = new Player(0,grid);

        //while (!gameOver){
        //}
    }
}
