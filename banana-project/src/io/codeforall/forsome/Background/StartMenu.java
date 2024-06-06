package io.codeforall.forsome.Background;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends Background{

    private Picture logo;
    private Picture announcement;
    private int announcementInitialX;
    private int announcementInitialY;

    public StartMenu(){
        this.background = new Picture(PADDING,PADDING,"resources/duck-hunt.png");
    }

    @Override
    public void createBackground(){
        super.createBackground();
        //this.background.grow();
        //this.background.translate(100,90);
        createLogo();
        createAnnouncement();
    }

    public void createLogo() {
        this.logo = new Picture(PADDING,PADDING,"resources/logo.png");
        this.logo.draw();
        this.logo.grow(-280,-80);
        this.logo.translate(-80,-80);

    }

    public void createAnnouncement(){
        this.announcement = new Picture(100,300, "resources/start-announcement.png");
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
