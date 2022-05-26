package com.jenginetetris.Scenes;

public class Game {
    int difficulty;
    long score;
    float speed;
    public void startGame(int initialDifficulty){
        difficulty = initialDifficulty;
        score = 0;
        speed = 1;
    }



    public void setScore(long newScore){
        score = newScore;
    }
    public void updateScore(long points){
        score += points;
    }
}
