package io.codeforall.forsome.Background;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameBackground extends Background {
    @Override
    public void createBackground() {
        this.background.load("resources/duck-hunt-full.png");
        super.createBackground();
        this.background.grow(160, 160);
        this.background.translate(160, 150);
        Picture vegetation = new Picture();
        vegetation.load("resources/vegetation.png");
        vegetation.draw();
        vegetation.grow(160, 160);
        vegetation.translate(160, 150);
        createGun();

    }

    public void createGun() {
        Picture weapon = new Picture();
        weapon.load("resources/gun.png");
        weapon.draw();
        weapon.grow(-120,-120);
        weapon.translate(300,518);
    }
}
