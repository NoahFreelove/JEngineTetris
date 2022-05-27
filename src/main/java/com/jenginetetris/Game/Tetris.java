package com.jenginetetris.Game;

import com.jenginetetris.Main;
import javafx.scene.paint.Color;

public class Tetris {
    private TetrisType type;
    private Block[] blocks;
    private int x, y;
    private int rotation;
    private boolean isFalling;
    private Color blockColor;
    private boolean hasMovedThisTick;
    public Tetris(TetrisType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.rotation = 0;
        this.isFalling = false;
        this.blocks = new Block[4];
        determineColor();
        generateChildren();
        isFalling = true;
    }

    private void determineColor(){
        switch (type)
        {
            case T -> blockColor = Color.RED;
            case L -> blockColor = Color.BLUE;
            case Z -> blockColor = Color.GREEN;
            case SQUARE -> blockColor = Color.YELLOW;
            case STRAIGHT -> blockColor = Color.ORANGE;
            case REVERSEL -> blockColor = Color.PURPLE;
            case REVERSEZ -> blockColor = Color.BROWN;
        }
    }
    public void generateChildren(){
        switch (type)
        {
            case L -> {
                blocks[0] = new Block(x, y, this);
                blocks[1] = new Block(x, y+1, this);
                blocks[2] = new Block(x, y+2, this);
                blocks[3] = new Block(x+1, y, this);
            }
            case T -> {
                blocks[0] = new Block(x, y, this);
                blocks[1] = new Block(x+1, y, this);
                blocks[2] = new Block(x+2, y, this);
                blocks[3] = new Block(x+1, y+1, this);
            }
            case Z -> {
                blocks[0] = new Block(x, y, this);
                blocks[1] = new Block(x+1, y, this);
                blocks[2] = new Block(x+1, y+1, this);
                blocks[3] = new Block(x+2, y+1, this);
            }
            case REVERSEZ -> {
                blocks[0] = new Block(x, y+1, this);
                blocks[1] = new Block(x+1, y+1, this);
                blocks[2] = new Block(x+1, y, this);
                blocks[3] = new Block(x+2, y, this);
            }
            case SQUARE ->
            {
                blocks[0] = new Block(x, y, this);
                blocks[1] = new Block(x+1, y, this);
                blocks[2] = new Block(x, y+1, this);
                blocks[3] = new Block(x+1, y+1, this);
            }
            case STRAIGHT ->
            {
                blocks[0] = new Block(x, y, this);
                blocks[1] = new Block(x+1, y, this);
                blocks[2] = new Block(x+2, y, this);
                blocks[3] = new Block(x+3, y, this);
            }
            case REVERSEL ->
            {
                blocks[0] = new Block(x, y, this);
                blocks[1] = new Block(x+1, y, this);
                blocks[2] = new Block(x+1, y+2, this);
                blocks[3] = new Block(x+1, y+3, this);
            }
        }
    }

    public void addToScene(){
        for(Block block : blocks) {
            Main.gameScene.add(block);
        }
    }
    public void remove(){
        for(Block block : blocks) {
            Main.gameScene.remove(block);
        }
    }

    public boolean requestMove(int deltaX, int deltaY){
        for(Block block : blocks){
            if(!block.requestMove(deltaX, deltaY))
            {
                if(deltaY != 0)
                {
                    GameManager.activeTetrisHitGround();
                    isFalling = false;
                }
                return false;
            }
        }
        for (Block block : blocks) {
            block.move(deltaX, deltaY);
        }
        x += deltaX;
        y += deltaY;
        return true;
    }

    public boolean hasMovedThisTick() {
        return hasMovedThisTick;
    }

    public void setHasMovedThisTick(boolean hasMovedThisTick) {
        this.hasMovedThisTick = hasMovedThisTick;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public Color getBlockColor() {
        return blockColor;
    }

    public boolean isFalling() {
        return isFalling;
    }

}
