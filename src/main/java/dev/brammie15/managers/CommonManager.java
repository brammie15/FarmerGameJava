package dev.brammie15.managers;

public interface CommonManager {
    //Only called after Raylib has been initalized
    void init(GameManager gameManager);

    void dispose();

}
