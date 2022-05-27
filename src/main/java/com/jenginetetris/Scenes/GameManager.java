package com.jenginetetris.Scenes;

import com.JEngine.Game.Visual.Scenes.GameScene;
import com.JEngine.Game.Visual.Scenes.SceneManager;
import com.JEngine.Utility.Misc.GameTimer;
import com.jenginetetris.Game.Block;
import com.jenginetetris.Game.Tetris;

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
        gt = new GameTimer(100, args -> {
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
        //printASCII();
        checkLines();
    }

    public void checkLines(){
        int totalLines = 0;
        for(int y = 0; y < height; y++){
            boolean isLine = true;
            for(int x = 0; x < width; x++){
                if(blocks[x][y] == null){
                    isLine = false;
                    break;
                }
            }
            updateBlockArray();

            if(isLine){
                for (int i = 0; i < width; i++) {
                    for (Tetris t : allTetris) {
                        if(blocks[i][y] != null)
                        {
                            SceneManager.getActiveScene().remove(blocks[i][y]);
                            t.removeBlock(blocks[i][y]);
                            blocks[i][y] = null;
                        }
                    }
                }
                totalLines++;
            }
        }
        updateBlockArray();

        if(totalLines > 0){
            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    if(blocks[x][y] != null){
                        blocks[x][y].getParent().requestMove(0, totalLines);
                    }
                }
            }
            printASCII();

            updateBlockArray();

            printASCII();

        }
    }

    // When some blocks move down they can overwrite their children, so we need to update the array
    void updateBlockArray(){
        blocks = new Block[width][height];
        for(Tetris t: allTetris){
            boolean allNull = true;
            for (Block b: t.getBlocks()) {
                if(b == null)
                {
                    System.out.println("Block is null " + t.getType());
                    continue;
                }
                if (b.getX() >= 0 && b.getX() < width && b.getY() >= 0 && b.getY() < height)
                {
                    blocks[b.getX()][b.getY()] = b;
                    allNull = false;
                }
            }

            if(allNull)
            {
                //System.out.println("All null");
                allTetris.remove(t);
            }else {
                //System.out.println("Not all null" + t.getType());
            }
        }
    }

    public static void activeTetrisHitGround(){
        activeTetris = null;
    }

    // helpful debugging method
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

    // reset the move status on the blocks
    // there is a hasMoved status on Tetris's  (tetri?) so we don't update it twice.
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
