package io.codeforall.forsome;

import io.codeforall.forsome.Background.Background;
import io.codeforall.forsome.Background.GameBackground;
import io.codeforall.forsome.Grid.Grid;
import io.codeforall.forsome.Grid.GameGrid;
import io.codeforall.forsome.Grid.GridFactory;
import io.codeforall.forsome.Targets.Target;
import io.codeforall.forsome.Targets.TargetFactory;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import io.codeforall.forsome.Background.StartMenu;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public final int MAX_TARGETS = 25;
    private Grid grid;
    private int delay;
    private Player player;
    private List<Target> targets;
    private Keyboard keyboard;
    private Background background;
    private int highScore;
    private int currentScore;
    private boolean gameOver;
    private int maxTargets;
    private GameState gameState;
    private Picture picture;

    public Game(int cols, int rows, int delay) {
        createCanvas(cols, rows);
        this.grid = GridFactory.makeGrid(cols, rows);
        this.delay = delay;
        this.gameOver = false;
        this.gameState = GameState.START;
    }

    public void createCanvas(int cols, int rows) {
        Canvas.getInstance();

        if (grid instanceof GameGrid) {
            GameGrid gameGrid = (GameGrid) grid;
            Canvas.limitCanvasWidth(gameGrid.rowToY(rows));
            Canvas.limitCanvasHeight(gameGrid.columnToX(cols));
        }
    }

    public void startGame() throws InterruptedException {
        this.player = new Player(0, grid);

        if (this.gameState == GameState.START) {
            this.background = new StartMenu();
            this.background.createBackground();

            while(this.gameState == GameState.START){
                Thread.sleep(this.delay);
                changeState();
            }
        }

        if (this.gameState == GameState.GAME) {
            grid.init();
            this.background = new GameBackground();
            this.background.createBackground();
            this.currentScore = 0;
            String score = "Score: " + this.currentScore;
            this.maxTargets = MAX_TARGETS;

            this.targets = new ArrayList<>();
            TargetFactory targetFactory = new TargetFactory((GameGrid) grid);
            // Criar apenas um alvo inicial
            targets.add(targetFactory.createTarget());

            this.player.setTargets(targets);
            this.player.startTargetMovement();

            //SCORE
            Text playerScore = new Text(720, 30, score);
            playerScore.draw();
            playerScore.grow(30, 20);

            this.player = new Player(0, grid);

            while(this.gameState == GameState.GAME){

                player.getWeapon().getAimer().move();

                Thread.sleep(this.delay);

                if(this.gameOver){
                    break;
                }
            }
        }

        if (this.gameState == GameState.GAMEOVER){
            while (this.gameState == GameState.GAMEOVER){

            }
        }




    }

    private void setGameState(GameState gameState){
        this.gameState = gameState;
    }


    private enum GameState {
        START,
        GAME,
        GAMEOVER
    }

    public void changeState(){

        if (this.player.changeGameState()){
            this.gameState = GameState.GAME;
        }

    }
}
