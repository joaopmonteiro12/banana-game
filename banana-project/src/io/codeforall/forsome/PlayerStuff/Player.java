package io.codeforall.forsome.PlayerStuff;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.security.Key;

public class Player {

    private int score;
    private Weapon weapon;
    private Keyboard keyboard;

    public Player(int score, Weapon weapon) {
        this.score = score;
        this.weapon = weapon;
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

    public void weaponReload() {
        weapon.reload();
    }
}

