package io.codeforall.forsome;

import io.codeforall.forsome.Background.Background;
import io.codeforall.forsome.Background.GameBackground;
import io.codeforall.forsome.Background.GameOverBackground;
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

    public final int MAX_TARGETS = 15;
    private Grid grid;
    private int delay;
    private Player player;
    private List<Target> targets;
    private Background background;
    private int highScore;
    private int currentScore;
    private boolean gameOver;
    private int maxTargets;
    private GameState gameState;

    public Game(int cols, int rows, int delay) {
        createCanvas(cols, rows);
        this.grid = GridFactory.makeGrid(cols, rows);
        this.delay = delay;
        this.gameOver = false;
        this.gameState = GameState.START;
        this.maxTargets = MAX_TARGETS;
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

        GameGrid gameGrid = null;
        if (grid instanceof GameGrid) {
            gameGrid = (GameGrid) grid;
        }

        if (this.gameState == GameState.START) {
            this.background = new StartMenu();
            this.background.createBackground();

            while (this.gameState == GameState.START) {
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
            this.player.setPlaying(true);
            this.targets = new ArrayList<>(MAX_TARGETS);

            for (int i = 0; i < MAX_TARGETS; i++) {
                targets.add(TargetFactory.createTarget(gameGrid));
            }


            //SCORE
            Text playerScore = new Text(720, 30, score);
            playerScore.draw();
            playerScore.grow(30, 20);

            this.player = new Player(0, grid);

            while (this.gameState == GameState.GAME && !this.gameOver) {

                for (Target target : targets) {
                    target.createTarget(target.getX(), target.getY(), target.getFilepath());
                    while (target.isActive()) {
                        player.getWeapon().getAimer().move();
                        player.shoot(target);
                        target.move();

                        Thread.sleep(this.delay);

                        if (!target.isActive()) {
                            target.deleteTarget();
                            targets.remove(target);
                            continue;
                        }

                        if (this.gameOver || this.player.getWeapon().getBulletsLeft() == 0) {
                            this.gameState = GameState.GAMEOVER;
                        }
                    }

                }
            }
        }

        if (this.gameState == GameState.GAMEOVER) {
            this.background = new GameOverBackground();
            this.background.createBackground();

            while (this.gameState == GameState.GAMEOVER) {
                Thread.sleep(this.delay);
            }
            this.background = new StartMenu();
            this.background.createBackground();
        }
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    private enum GameState {
        START,
        GAME,
        GAMEOVER
    }

    public void changeState() {

        if (this.player.changeGameState()) {
            this.gameState = GameState.GAME;
        }

    }
}
