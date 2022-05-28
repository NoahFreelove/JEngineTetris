package com.jenginetetris.Game;

public class TetrisRotator {

    public static void rotateBlocks(Block[] blocks, int rotation, Tetris t)
    {
        switch (t.getType())
        {
            case T -> {
            }
            case L -> {}
            case Z -> {}
            case SQUARE -> {
                // square doesn't rotate
            }
            case STRAIGHT -> {
                System.out.println(rotation);
                switch (rotation)
                {
                    case 0,360,180-> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if(!blocks[i].requestMoveAbsolute(t.getX(),t.getY()+i))
                            {
                                couldNotRotate = true;
                            }
                        }
                        if(!couldNotRotate)
                        {
                            for (int i = 0; i < blocks.length; i++) {
                                blocks[i].setPos(t.getX(), t.getY()+i);
                            }
                        }

                    }
                    case 90,270-> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if(!blocks[i].requestMoveAbsolute(t.getX()+i,t.getY()))
                            {
                                couldNotRotate = true;
                            }
                        }
                        if(!couldNotRotate)
                        {
                            for (int i = 0; i < blocks.length; i++) {
                                blocks[i].setPos(t.getX()+i, t.getY());
                            }
                        }
                    }
                }
            }
            case J -> {}
            case S -> {}
        }
    }
}
