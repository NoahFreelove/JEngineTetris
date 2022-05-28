package com.jenginetetris.Game;

public class TetrisRotator {

    public static void rotateBlocks(Block[] blocks, int rotation, Tetris t)
    {
        switch (t.getType())
        {
            case T -> {
                switch (rotation) {
                    case 0,360 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 2, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY() + 1)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX() + 1, t.getY());
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX() + 2, t.getY());
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() + 1, t.getY() + 1);
                                }
                            }
                        }
                    }
                    case 90 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY() -1)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY());
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX() +1, t.getY()+1);
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() + 1, t.getY() - 1);
                                }
                            }
                        }
                    }
                    case 180 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 2, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() +1, t.getY() -1)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY());
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX() +2, t.getY());
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() +1, t.getY() - 1);
                                }
                            }
                        }
                    }
                    case 270 ->{
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY()-1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+2, t.getY())) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY()+1);
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY()-1);
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() +2, t.getY());
                                }
                            }
                        }
                    }
                }
            }
            case L -> {
                switch (rotation) {
                    case 0,360 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() , t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY() + 2)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY() + 2)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX(), t.getY() + 1);
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX(), t.getY()+2);
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() + 1, t.getY() + 2);
                                }
                            }
                        }
                    }
                    case 90 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 2, t.getY())) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX(), t.getY()+1);
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX() +1, t.getY());
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() + 2, t.getY());
                                }
                            }
                        }
                    }
                    case 180 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() +1, t.getY() +2)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY());
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX() +1, t.getY()+1);
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() +1, t.getY() + 2);
                                }
                            }
                        }
                    }
                    case 270 ->{
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+2, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+2, t.getY()-1)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY());
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX()+2, t.getY());
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() +2, t.getY()-1);
                                }
                            }
                        }
                    }
                }
            }
            case Z -> {}
            case SQUARE -> {
                // square doesn't rotate
            }
            case STRAIGHT -> {
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
            case J -> {
                switch (rotation) {
                    case 0,360 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY()+2)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1 , t.getY()+2)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY() + 1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY()+2);
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY() + 2);
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY()+1);
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() + 1, t.getY());
                                }
                            }
                        }
                    }
                    case 90 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 1, t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX() + 2, t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX(), t.getY()+1);
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX() +1, t.getY()+1);
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() + 2, t.getY()+1);
                                }
                            }
                        }
                    }
                    case 180 -> {
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY() +2)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY());
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX(), t.getY()+1);
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX(), t.getY() + 2);
                                }
                            }
                        }
                    }
                    case 270 ->{
                        boolean couldNotRotate = false;
                        for (int i = 0; i < blocks.length; i++) {
                            if (i == 0) {
                                if (!blocks[i].requestMoveAbsolute(t.getX(), t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 1) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+1, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 2) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+2, t.getY())) {
                                    couldNotRotate = true;
                                }
                            } else if (i == 3) {
                                if (!blocks[i].requestMoveAbsolute(t.getX()+2, t.getY()+1)) {
                                    couldNotRotate = true;
                                }
                            }
                        }
                        if (!couldNotRotate) {
                            for (int i = 0; i < blocks.length; i++) {
                                if(i == 0)
                                {
                                    blocks[i].setPos(t.getX(), t.getY());
                                }
                                else if(i == 1)
                                {
                                    blocks[i].setPos(t.getX()+1, t.getY());
                                }
                                else if(i == 2)
                                {
                                    blocks[i].setPos(t.getX()+2, t.getY());
                                }
                                else if(i == 3)
                                {
                                    blocks[i].setPos(t.getX() +2, t.getY()+1);
                                }
                            }
                        }
                    }
                }
            }
            case S -> {}
        }
    }
}
