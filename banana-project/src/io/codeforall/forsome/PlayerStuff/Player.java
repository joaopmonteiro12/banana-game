package io.codeforall.forsome.PlayerStuff;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.security.Key;

public class Player {

    private int score;
    private Weapon weapon;
    private Keyboard keyboard;

public Player(int score) {
    this.score=score;
}

public int getScore() {
    return this.score;
}
public void winPoints(int points) {
    this.score=this.score+points;
}
public void loosePoints(int points) {
    if (this.score >= points) {
        this.score = this.score - points;
    }
}


}

