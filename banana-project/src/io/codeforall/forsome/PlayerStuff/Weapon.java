package io.codeforall.forsome.PlayerStuff;

public class Weapon {

    private Aimer aimer;
    private int maxBullets = 25;
    private int remainingBullets = 5;
    private int bulletsLeft;


    public Weapon(int maxBullets, int remainingBullets, int bulletsLeft) {
        this.maxBullets = maxBullets;
        this.remainingBullets = remainingBullets;
        this.bulletsLeft = maxBullets;

    }

    public int getRemainingBullets() {
        return this.remainingBullets;
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


    public void reload() {
        if (bulletsLeft > 0) {
            remainingBullets = remainingBullets+5;
            System.out.println("Weapon reloaded.");
            switch (bulletsLeft) {
                case 20: picture5.delete();
                break;
                case 15: picture4.delete();
                break;
                case 10: picture3.delete();
                break;
                case 5: picture2.delete();
                break;
                case 0: picture1.delete();
            }
        }
        System.out.println("You are out of ammo..");
    }
}
