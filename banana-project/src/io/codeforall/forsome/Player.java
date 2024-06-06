package io.codeforall.forsome;

import io.codeforall.forsome.Grid.GameGrid;
import io.codeforall.forsome.Grid.Grid;
import io.codeforall.forsome.Targets.Movable;
import io.codeforall.forsome.Targets.Target;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {

    private int score;
    private Weapon weapon;
    private Keyboard keyboard;
    private Grid grid;
    private boolean isPlaying;

    public Player(int score, Grid grid) {
        this.score = score;
        this.keyboard = new Keyboard(this);
        this.weapon = new Weapon();
        addKeyboard();
        this.grid = grid;
        this.isPlaying = false;

    }

    public int getScore() {
        return this.score;
    }

    public void winPoints(int points) {
        this.score = this.score + points;
    }

    public void loosePoints(int points) {
        if (this.score >= points) {
            this.score = this.score - points;
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon() {
        this.weapon = weapon;
    }

    public void shoot() {
        weapon.fire();
    }

        /*public void weaponReload() {
            weapon.reload();
        }*/

    //KEYBOARD STUFF
    public void addKeyboard() {
        KeyboardEvent moveRightPress = new KeyboardEvent();
        moveRightPress.setKey(KeyboardEvent.KEY_RIGHT);
        moveRightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRightPress);

        KeyboardEvent moveRightRelease = new KeyboardEvent();
        moveRightRelease.setKey(KeyboardEvent.KEY_RIGHT);
        moveRightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveRightRelease);

        KeyboardEvent moveLeftPress = new KeyboardEvent();
        moveLeftPress.setKey(KeyboardEvent.KEY_LEFT);
        moveLeftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeftPress);

        KeyboardEvent moveLeftRelease = new KeyboardEvent();
        moveLeftRelease.setKey(KeyboardEvent.KEY_LEFT);
        moveLeftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveLeftRelease);

        KeyboardEvent moveUpPress = new KeyboardEvent();
        moveUpPress.setKey(KeyboardEvent.KEY_UP);
        moveUpPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUpPress);

        KeyboardEvent moveUpRelease = new KeyboardEvent();
        moveUpRelease.setKey(KeyboardEvent.KEY_UP);
        moveUpRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveUpRelease);

        KeyboardEvent moveDownPress = new KeyboardEvent();
        moveDownPress.setKey(KeyboardEvent.KEY_DOWN);
        moveDownPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDownPress);

        KeyboardEvent moveDownRelease = new KeyboardEvent();
        moveDownRelease.setKey(KeyboardEvent.KEY_DOWN);
        moveDownRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(moveDownRelease);

        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKey(KeyboardEvent.KEY_SPACE);
        startGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(startGame);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int keyPressed = keyboardEvent.getKey();
        if (keyPressed == keyboardEvent.KEY_RIGHT) {
            this.weapon.aimer.isMovingRight = true;
        }
        if (keyPressed == keyboardEvent.KEY_LEFT) {
            this.weapon.aimer.isMovingLeft = true;
        }
        if (keyPressed == keyboardEvent.KEY_UP) {
            this.weapon.aimer.isMovingUp = true;
        }
        if (keyPressed == keyboardEvent.KEY_DOWN) {
            this.weapon.aimer.isMovingDown = true;
        }
        if (keyPressed == keyboardEvent.KEY_SPACE){
            this.isPlaying = true;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int keyReleased = keyboardEvent.getKey();
        if (keyReleased == keyboardEvent.KEY_RIGHT) {
            this.weapon.aimer.isMovingRight = false;
        }
        if (keyReleased == keyboardEvent.KEY_LEFT) {
            this.weapon.aimer.isMovingLeft = false;
        }
        if (keyReleased == keyboardEvent.KEY_UP) {
            this.weapon.aimer.isMovingUp = false;
        }
        if (keyReleased == keyboardEvent.KEY_DOWN) {
            this.weapon.aimer.isMovingDown = false;
        }
    }

    public boolean changeGameState (){
        return isPlaying;
    }

    //NESTED AIMER
    public class Aimer implements Movable {
        // Propriedades

        private boolean isMovingRight;
        private boolean isMovingLeft;
        private boolean isMovingUp;
        private boolean isMovingDown;

        private int x;
        private int y;
        private Picture aimer;


        // Construtor
        public Aimer(int x, int y) {
            this.isMovingRight = false;
            this.isMovingLeft = false;
            this.isMovingUp = false;
            this.isMovingDown = false;
            this.aimer = new Picture();
            createAimer();
            this.x = x;
            this.y = y;
        }

        @Override
        public void move() {

            GameGrid gameGrid = null;

            if (grid instanceof GameGrid) {
                gameGrid = (GameGrid) grid;
            }

            if (this.isMovingRight) {
                if (this.aimer.getMaxX() < gameGrid.getWidth()) {
                    this.aimer.translate(10, 0);
                }
            }
            if (this.isMovingLeft) {
                if (this.aimer.getX() > 0) {
                    this.aimer.translate(-10, 0);
                }
            }
            if (this.isMovingUp) {
                if (this.aimer.getY() > 0) {
                    this.aimer.translate(0, -10);
                }
            }
            if (this.isMovingDown) {
                if (this.aimer.getMaxY() < gameGrid.getHeight()) {
                    this.aimer.translate(0, 10);
                }
            }

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

        //CREATE AIMER
        public void createAimer() {
            this.aimer.load("resources/aim-small.png");
            this.aimer.draw();
            this.aimer.translate(500,450);
        }

    }

    //NESTED WEAPON
    public class Weapon {



        private Aimer aimer;
        private int maxBullets;
        private int remainingBullets;
        private int bulletsLeft;


        public Weapon() {
            this.aimer = new Aimer(0, 0);
            this.maxBullets = 25;
            this.remainingBullets = 5;
            this.bulletsLeft = maxBullets;

        }

        public int getRemainingBullets() {
            return this.remainingBullets;
        }

        public Aimer getAimer() {
            return aimer;
        }

        public void setAimer(Aimer aimer) {
            this.aimer = aimer;
        }

        public void fire() {
            if (remainingBullets > 0) {
                System.out.println("Pew pew! Shots fired.");
                remainingBullets--;
                bulletsLeft--;
            } else if (bulletsLeft > 0) {
                System.out.println("RELOAD RELOAD RELOAD");
            } else
                System.out.println("Game Over!!");
        }


            /*public void reload() {
                if (bulletsLeft > 0) {
                    remainingBullets = remainingBullets + 5;
                    System.out.println("Weapon reloaded.");
                    switch (bulletsLeft) {
                        case 20:
                            picture5.delete();
                            break;
                        case 15:
                            picture4.delete();
                            break;
                        case 10:
                            picture3.delete();
                            break;
                        case 5:
                            picture2.delete();
                            break;
                        case 0:
                            picture1.delete();
                    }
                }
                System.out.println("You are out of ammo..");
            }*/
    }
}


