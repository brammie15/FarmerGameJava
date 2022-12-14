package dev.brammie15;

import com.raylib.java.raymath.Vector2;

import java.util.Random;

public final class Constants {
    public static final int TILE_WIDTH = 16;
    public static final int TILE_HEIGHT = 16;
    public static final int TILE_X = 10;
    public static final int TILE_Y = 5;
    public static final int SCALE = 10;
    public static final int WINDOW_WIDTH = TILE_WIDTH * TILE_X * SCALE;
    public static final int WINDOW_HEIGHT = TILE_HEIGHT * TILE_Y * SCALE;
    public static final int TICK_RATE = 30;
    public static final Random rand = new Random();

    public static final Vector2 ZERO = new Vector2(0, 0);
    public static final Vector2 ONE = new Vector2(1, 1);
    public static final Vector2 SCALE_VECTOR = new Vector2(SCALE, SCALE);
}
