package io.codeforall.forsome.Background;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends Background{

    private Picture logo;
    private Picture announcement;
    private int announcementInitialX;
    private int announcementInitialY;

    public StartMenu(){
        this.logo = new Picture();
    }

    @Override
    public void createBackground(){
        this.background.load("resources/duck-hunt.png");
        super.createBackground();
        this.background.grow(160,160);
        this.background.translate(160,150);
        createLogo();
        createAnnouncement();
    }

    public void createLogo() {
        this.logo.load("resources/logo.png");
        this.logo.draw();
        this.logo.grow(-50,-50);
        this.logo.translate(100,50);

    }

    public void createAnnouncement(){
        this.announcement = new Picture(130,410, "resources/start-announcement.png");
        this.announcement.draw();
        this.announcement.grow(-180,-30);
        this.announcementInitialX = announcement.getX();
        this.announcementInitialY = announcement.getY();

    }

    public void moveAnnouncement(){
        this.announcement.translate(20,20);
    }
    public void deleteAnnouncement(){
        this.announcement.delete();
    }


}
