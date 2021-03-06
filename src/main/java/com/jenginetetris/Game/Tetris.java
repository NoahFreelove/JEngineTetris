package com.jenginetetris.Game;

import com.jenginetetris.Main;
import com.jenginetetris.Scenes.GameManager;

public class Tetris {
    private TetrisType type;
    private Block[] blocks;
    private int x, y;
    private int rotation;
    private boolean isFalling;
    private int blockColor;
    private boolean hasMovedThisTick;
    private boolean hasMovedLine;
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

    public Tetris(int x, int y) {
        this(TetrisType.values()[(int) (Math.random() * TetrisType.values().length)], x, y);
    }

    private void determineColor(){
        switch (type)
        {
            case T -> blockColor = 0xFFFF00FF;
            case L -> blockColor = 0xFFFFA500;
            case Z -> blockColor = 0xFF00FF00;
            case SQUARE -> blockColor = 0xFFFFFF00;
            case STRAIGHT -> blockColor =  0xFF00FFFF;
            case J -> blockColor = 0xFFFFC0CB;
            case S -> blockColor = 0xFFFF0000;
        }
    }
    public void generateChildren(){
        switch (type)
        {
            case L -> {
                blocks[0] = new Block(x, y, this);
                blocks[1] = new Block(x, y+1, this);
                blocks[2] = new Block(x, y+2, this);
                blocks[3] = new Block(x+1, y+2, this);
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
            case S -> {
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
                blocks[1] = new Block(x, y+1, this);
                blocks[2] = new Block(x, y+2, this);
                blocks[3] = new Block(x, y+3, this);
            }
            case J ->
            {
                blocks[0] = new Block(x, y+2, this);
                blocks[1] = new Block(x+1, y+2, this);
                blocks[2] = new Block(x+1, y+1, this);
                blocks[3] = new Block(x+1, y, this);
            }
        }
    }

    public void addToScene(){
        for(Block block : blocks) {
            Main.gameScene.add(block);
        }
    }
    public void remove(){
        int i = 0;
        for(Block block : blocks) {
            Main.gameScene.remove(block);
            blocks[i] = null;
            i++;
        }
    }

    public boolean requestMove(int deltaX, int deltaY){
        for(Block block : blocks){
            if(block == null || block.isQueuedForDeletion() || !block.getActive())
                continue;
            if(!block.requestMove(deltaX, deltaY))
            {
                if(deltaY != 0)
                {
                    if(GameManager.activeTetris == this)
                    {
                        GameManager.activeTetrisHitGround();
                    }
                    isFalling = false;
                }
                return false;
            }
        }
        for (Block block : blocks) {
            if(block == null)
                continue;
            block.move(deltaX, deltaY);
        }
        x += deltaX;
        y += deltaY;
        return true;
    }
    public void rotate(){
        if(!isFalling)
            return;
        rotation+=90;
        if(rotation >= 360)
            rotation = 0;
        TetrisRotator.rotateBlocks(blocks, rotation, this);
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

    public int getBlockColor() {
        return blockColor;
    }

    public boolean isFalling() {
        return isFalling;
    }

    public TetrisType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRotation() {
        return rotation;
    }

    public boolean isHasMovedThisTick() {
        return hasMovedThisTick;
    }

    public void removeBlock(Block b) {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] == b) {
                blocks[i] = null;
            }
        }
    }

    public int getNotNulls() {
        int count = 0;
        for (Block block : blocks) {
            if (block != null)
                count++;
        }
        return count;
    }

    public void setFalling(boolean falling) {
        isFalling = falling;
    }

    private void faceDown(){

    }
    private void faceLeft(){}
    private void faceRight(){}

    public void setHasMovedLine(boolean b) {
        hasMovedLine = b;
    }

    public boolean isHasMovedLine() {
        return hasMovedLine;
    }
}
