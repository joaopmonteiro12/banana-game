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

}
