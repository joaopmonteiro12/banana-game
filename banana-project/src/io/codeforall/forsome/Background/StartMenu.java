package io.codeforall.forsome.Background;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends Background{

    private Picture logo;
    private Picture announcement;
    private Text currentHighScore;

    public StartMenu(){
        this.background = new Picture(PADDING,PADDING,"src/resources/duck-hunt.png");
    }

    @Override
    public void createBackground(){
        super.createBackground();
        createLogo();
        createAnnouncement();
    }

    public void createLogo() {
        this.logo = new Picture(PADDING,PADDING,"src/resources/logo.png");
        this.logo.draw();
        this.logo.translate(170,100);

    }

    public void createAnnouncement(){
        this.announcement = new Picture(222,340, "src/resources/start-announcement.png");
        this.announcement.draw();

    }

    public void setCurrentHighScore(int currentHighScore){
        String str = "" + currentHighScore;
        this.currentHighScore = new Text(400,400,str);
        this.currentHighScore.draw();
    }
}
