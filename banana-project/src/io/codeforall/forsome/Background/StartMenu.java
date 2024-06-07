package io.codeforall.forsome.Background;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends Background{

    private Picture logo;
    private Picture announcement;

    public StartMenu(){
        this.background = new Picture(PADDING,PADDING,"resources/duck-hunt.png");
    }

    @Override
    public void createBackground(){
        super.createBackground();
        createLogo();
        createAnnouncement();
    }

    public void createLogo() {
        this.logo = new Picture(PADDING,PADDING,"resources/logo.png");
        this.logo.draw();
        this.logo.translate(170,100);

    }

    public void createAnnouncement(){
        this.announcement = new Picture(222,340, "resources/start-announcement.png");
        this.announcement.draw();

    }
}
