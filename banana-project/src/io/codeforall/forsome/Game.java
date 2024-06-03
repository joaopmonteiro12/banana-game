package io.codeforall.forsome;

import io.codeforall.forsome.Grid.Grid;
import io.codeforall.forsome.PlayerStuff.Player;
import io.codeforall.forsome.Targets.Target;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    public final int MAX_TARGETS = 25;
    private Grid grid;
    private int delay;
    private Player player;
    private Target[] targets;
    private Keyboard keyboard;
    private int highScore;
    private boolean gameOver;
    private int maxTargets;

}
