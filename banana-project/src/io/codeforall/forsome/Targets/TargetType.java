package io.codeforall.forsome.Targets;

public enum TargetType {
    MAFALDA("resources/mafalda.png"),
    PAPANOZK("resources/nozkgollum.png"),
    MEKIE("resources/mekie.png"),
    HENRIQUE("resources/henrique.png");

    String file;

    TargetType (String file){
       this.file = file;
    }

    public String getPath(){
        return this.file;
    }

}
