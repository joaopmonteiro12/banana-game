package io.codeforall.forsome.Targets;

import java.util.Random;

public class TargetFactory {
    private static final int GRID_WIDTH = 100; //???
    private static final int GRID_HEIGHT = 100; // ????

    private Random random;

    public TargetFactory() {
        random = new Random();
    }

    public Target createTarget(TargetType type) {
        int x = random.nextInt(GRID_WIDTH);
        int y = random.nextInt(GRID_HEIGHT);

        return new Target(x, y, type);
    }
}
