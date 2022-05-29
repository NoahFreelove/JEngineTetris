package com.jenginetetris.Scenes;

import com.JEngine.Core.GameImage;
import com.JEngine.Core.GameObject;
import com.JEngine.Core.Identity;
import com.JEngine.Core.Position.Transform;
import com.JEngine.Core.Position.Vector2;
import com.JEngine.Game.PlayersAndPawns.Sprite;
import com.JEngine.Game.Visual.Scenes.GameScene;
import com.JEngine.Game.Visual.Scenes.SceneManager;
import com.JEngine.Utility.About.GameInfo;
import com.JEngine.Utility.ImageProcessing.GenerateSolidTexture;
import com.JEngine.Utility.Misc.GameTimer;
import com.jenginetetris.Game.Block;
import com.jenginetetris.Game.Tetris;
import com.jenginetetris.Game.TetrisController;
import com.jenginetetris.Game.TetrisType;
import com.jenginetetris.Main;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class GameManager extends GameScene {
    public static int borderLength = 100;
    public static int borderHeight = 18;

    public static int blockSize = 32;
    public static Block[][] blocks;
    public static ArrayList<Tetris> allTetris = new ArrayList<>(1);
    public static Tetris activeTetris;
    public static TetrisType heldTetris = null;
    public static TetrisType nextTetris;
    public static int width = 10;
    public static int height = 20;

    public static boolean isPaused = false;
    public static boolean hasHeldThisTick = false;
    public static GameTimer gt;
    private Text gameNameText;
    private Text scoreText;
    public static Sprite background = new Sprite(Transform.exSimpleTransform(new Vector2(borderLength, height)), new GameImage(GenerateSolidTexture.generateImage(blockSize*width, blockSize*height, 0xFF2daaff)), new Identity("background"));
    public static long score;
    public GameManager() {
        super("Game Scene");
        add(background);
        gameNameText = new Text();
        gameNameText.setTranslateX(40);
        gameNameText.setFill(Color.WHITE);
        gameNameText.setRotate(-90);
        gameNameText.setTranslateY(360);
        gameNameText.setScaleX(2);
        gameNameText.setScaleY(2);

        addUI(gameNameText);
        score = 0;

        scoreText = new Text("Score: " + score);
        scoreText.setTranslateX(420);
        scoreText.setFill(Color.WHITE);
        scoreText.setRotate(90);
        scoreText.setTranslateY(360);
        scoreText.setScaleX(2);
        scoreText.setScaleY(2);
        addUI(scoreText);

    }

    public void StartGame(){
        score = 0;
        isPaused = false;
        for (GameObject obj: Main.gameScene.getObjects()){
            if(obj instanceof Block)
            {
                Main.gameScene.remove(obj);
                obj.setActive(false);
            }
        }
        allTetris = new ArrayList<>(1);
        gameNameText.setText(GameInfo.getAppName());
        blocks = new Block[width][height];
        add(new TetrisController());
        gt = new GameTimer(800, args -> {
            if(!isPaused){
                updateBlocks();
            }
        });
        gt.start();
        nextTetris = new Tetris(width/2,0).getType();
    }

    public void addTetris(Tetris t){
        allTetris.add(t);
        for (Block b: t.getBlocks()) {
            if(blocks[b.getX()][b.getY()] !=null)
            {
             if(b.getY()<2)
             {
                 if(!isPaused)
                 {
                     isPaused = true;
                     LoseScreen.addScore(score);
                     SceneManager.switchScene(new LoseScreen());
                 }
             }
            }
            blocks[b.getX()][b.getY()] = b;
            //System.out.println("Added block at " + b.getX() + " " + b.getY());
        }
        t.addToScene();
        activeTetris = t;
    }

    void updateBlocks(){
        for(int x = width-1; x > -1; x--){
            for(int y = height-1; y >-1; y--){
                if(blocks[x][y] != null){
                    if(blocks[x][y].getParent() !=null){
                        /*if(!blocks[x][y].getParent().isFalling())
                            continue;*/
                        if(!blocks[x][y].getParent().hasMovedThisTick())
                        {
                            blocks[x][y].getParent().setHasMovedThisTick(true);
                            blocks[x][y].getParent().requestMove(0,1);
                        }
                    }

                }
            }
        }
        updateBlockArrayBasedOnSceneContent();
        //printASCII();
        checkLines();
        resetHasMovedStatus();
    }

    public void checkLines(){
        int totalLines = 0;
        for(int y = 0; y < height; y++){
            boolean isLine = true;
            for(int x = 0; x < width; x++){
                if(blocks[x][y] == null){
                    isLine = false;
                    break;
                }else {
                    if(blocks[x][y].getParent().isFalling())
                    {
                        isLine = false;
                        break;
                    }
                }
            }

            if(isLine){
                for (int i = 0; i < width; i++) {
                    for (Tetris t : allTetris) {
                        if(blocks[i][y] != null)
                        {
                            blocks[i][y].setActive(false);
                            SceneManager.getActiveScene().remove(blocks[i][y]);
                            t.removeBlock(blocks[i][y]);
                            blocks[i][y] = null;
                        }
                    }
                }
                totalLines++;
            }
        }
        updateBlockArrayBasedOnSceneContent();
        if(totalLines > 0){
            //printASCII();
            /*for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    if(blocks[x][y] != null){
                        blocks[x][y].getParent().setFalling(true);
                    }
                }
            }*/
            for(int y = height-1; y > 0; y--){
                for(int x = width-1; x > 0; x--){
                    if(blocks[x][y] != null){

                        if(!blocks[x][y].getParent().isHasMovedLine())
                        {
                            blocks[x][y].getParent().setHasMovedLine(true);
                            blocks[x][y].getParent().requestMove(0,totalLines);
                        }
                    }
                }
            }
            score += totalLines * 100L;
            scoreText.setText("Score: " + score);
            resetHasMovedLineStatus();
            //printASCII();
        }
    }
    // When some blocks move down they can overwrite their children, so we need to update the array
    void updateBlockArrayBasedOnSceneContent(){
        blocks = new Block[width][height];
        for (GameObject go: SceneManager.getActiveScene().getObjects()) {
            if(go == null)
                continue;
            if(go instanceof Block && !go.isQueuedForDeletion() && go.getActive()){
                Block b = (Block) go;
                blocks[b.getX()][b.getY()] = b;
            }
        }
    }
    public static void addNextTetris(){
        activeTetris = new Tetris(nextTetris, width/2,0);
        Main.gameScene.addTetris(activeTetris);

    }

    public static void activeTetrisHitGround(){
        activeTetris = null;
        // Create new random block
        nextTetris = new Tetris(width/2,0).getType();
        addNextTetris();
        hasHeldThisTick = false;
    }

    public static void holdTetris(){
        if(hasHeldThisTick)
            return;
        hasHeldThisTick = true;
        if(heldTetris == null){
           heldTetris = activeTetris.getType();
           activeTetris.remove();
           allTetris.remove(activeTetris);
           nextTetris = new Tetris(width/2,0).getType();
        }
        else {
            TetrisType tmp = heldTetris;
            heldTetris = activeTetris.getType();
            activeTetris.remove();
            allTetris.remove(activeTetris);
            nextTetris = new Tetris(tmp, width/2,0).getType();

        }
        activeTetris = null;
        Main.gameScene.updateBlockArrayBasedOnSceneContent();
        addNextTetris();

    }

    // helpful debugging method
    public static void printASCII(){
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
    void resetHasMovedLineStatus(){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                if(blocks[x][y] != null){
                    if(blocks[x][y].getParent() !=null){
                        blocks[x][y].getParent().setHasMovedLine(false);
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
    public static void moveDown(){
        if(activeTetris !=null) {
            activeTetris.requestMove(0, 1);
        }
    }

    public static void rotate(){
        if(activeTetris !=null) {
            activeTetris.rotate();
        }
    }

}
