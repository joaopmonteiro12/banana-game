package io.codeforall.forsome.Targets;

import io.codeforall.forsome.Grid.GameGrid;

public class Henrique extends Target{
    public Henrique(int x, int y,String file, GameGrid gameGrid) {
        super(x, y,TargetType.HENRIQUE,file, gameGrid);
    }
}
