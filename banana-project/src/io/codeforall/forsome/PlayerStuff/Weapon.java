package io.codeforall.forsome.PlayerStuff;

public class Weapon {

    private Aimer aimer;
    private int maxBullets;
    private int remainingBullets;

public Weapon(int maxBullets, int remainingBullets) {
    this.maxBullets=maxBullets;
    this.remainingBullets=remainingBullets;

}

public int getRemainingBullets() {
    return this.remainingBullets;
}

public void fire() {
        if (remainingBullets > 0) {
            System.out.println("Pew pew! Shots fired.");
            remainingBullets--;
        } else {
            System.out.println("You are out of ammo.");
        }
    }

    public void reload() {
        remainingBullets = maxBullets;
        System.out.println("Weapon reloaded.");
    }
}
