package io.codeforall.forsome.Targets;

public enum TargetType {
    MAFALDA("src/resources/mafalda.png", 100),
    PAPANOZK("src/resources/nozkgollum.png", 100),
    MEKIE("src/resources/mekie.png",100),
    HENRIQUE("src/resources/henrique.png",-200);

    String file;
    int points;

    TargetType (String file, int points){
       this.file = file;
       this.points = points;
    }

    public String getPath(){
        return this.file;
    }
    public int getPoints(){
        return this.points;
    }

}
