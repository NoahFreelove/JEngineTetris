package com.jenginetetris.Game;

import com.JEngine.Core.GameImage;
import com.JEngine.Core.Identity;
import com.JEngine.Core.Position.Transform;
import com.JEngine.Core.Position.Vector3;
import com.JEngine.Game.PlayersAndPawns.Pawn;
import com.JEngine.Utility.ImageProcessing.GenerateSolidTexture;

public class Block extends Pawn {
    private Tetris parent;
    private int x,y;
    public Block(int x, int y, Tetris parent) {
        super(Transform.simpleTransform(new Vector3(GameManager.borderLength + x*GameManager.blockSize, GameManager.borderHeight + y*GameManager.blockSize)),
                new GameImage(GenerateSolidTexture.generateImage(32,32,0xFF00FF00)), new Identity("block"));
        this.parent = parent;
        this.x = x;
        this.y = y;
    }

    public Tetris getParent() {
        return parent;
    }

    public void setParent(Tetris parent) {
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean requestMove(int deltaX, int deltaY) {
        if(x + deltaX < 0 || x + deltaX >= GameManager.width || y + deltaY < 0 || y + deltaY >= GameManager.height)
            return false;
        if(GameManager.blocks[x+deltaX][y+deltaY] == null){
            return true;
        }
        if(GameManager.blocks[x+deltaX][y+deltaY].getParent() == getParent()){
            return true;
        }
        return false;
    }

    public void move(int deltaX, int deltaY) {
        GameManager.blocks[x][y] = null;
        x += deltaX;
        y += deltaY;
        GameManager.blocks[x][y] = this;
    }

    @Override
    public void Update(){
        setPosition(new Vector3(GameManager.borderLength + x*GameManager.blockSize, GameManager.borderHeight + y*GameManager.blockSize));
    }


}
