package io.codeforall.forsome.Targets;

import io.codeforall.forsome.Grid.GameGrid;

public class Mafalda extends Target {
    public Mafalda(int x, int y,String file, GameGrid gameGrid) {
        super(x, y,TargetType.MAFALDA, file, gameGrid);
    }
}
