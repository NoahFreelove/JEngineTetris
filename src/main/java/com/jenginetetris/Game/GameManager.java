package com.jenginetetris.Game;

import com.JEngine.Game.Visual.Scenes.GameScene;
import com.JEngine.Utility.Misc.GameTimer;

import java.util.ArrayList;

public class GameManager extends GameScene {
    public static int borderLength = 100;
    public static int borderHeight = 30;

    public static int blockSize = 32;
    public static Block[][] blocks;
    public static ArrayList<Tetris> allTetris = new ArrayList<>(1);
    public static Tetris activeTetris;
    public static int width = 10;
    public static int height = 20;

    public static boolean isPaused = false;

    public static GameTimer gt;
    public GameManager() {
        super("Game Scene");
    }

    public void StartGame(){
        blocks = new Block[width][height];
        gt = new GameTimer(500, args -> {
            if(!isPaused){
                updateBlocks();
            }
        });
        gt.start();
    }

    public void addTetris(Tetris t){
        allTetris.add(t);

        for (Block b: t.getBlocks()) {
            blocks[b.getX()][b.getY()] = b;
            //System.out.println("Added block at " + b.getX() + " " + b.getY());
        }
        t.addToScene();
        activeTetris = t;
    }
    void updateBlocks(){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                if(blocks[x][y] != null){
                    if(blocks[x][y].getParent() !=null){
                        if(!blocks[x][y].getParent().isFalling())
                            continue;
                        if(!blocks[x][y].getParent().hasMovedThisTick())
                        {
                            blocks[x][y].getParent().setHasMovedThisTick(true);
                            blocks[x][y].getParent().requestMove(0,1);
                        }
                    }

                }
            }
        }
        updateBlockArray();
        //printASCII();
        resetHasMovedStatus();
    }
    void updateBlockArray(){
        blocks = new Block[width][height];
        for(Tetris t: allTetris){
            for (Block b: t.getBlocks()) {
                blocks[b.getX()][b.getY()] = b;
            }
        }
    }

    public static void activeTetrisHitGround(){
        activeTetris = null;
    }

    void printASCII(){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(blocks[x][y] != null){
                    System.out.print("X");
                }else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        System.out.println("\n\n\n");

    }

    void resetHasMovedStatus(){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                if(blocks[x][y] != null){
                    if(blocks[x][y].getParent() !=null){
                        blocks[x][y].getParent().setHasMovedThisTick(false);
                    }
                }
            }
        }
    }

    public static void moveLeft(){
        if(activeTetris !=null) {
            activeTetris.requestMove(-1, 0);
        }
    }

    public static void moveRight(){
        if(activeTetris !=null) {
            activeTetris.requestMove(1, 0);
        }
    }

}
