package com.jenginetetris.Game;

import com.JEngine.Core.Identity;
import com.JEngine.Core.Position.Transform;
import com.JEngine.Game.PlayersAndPawns.Player;
import com.JEngine.Utility.Input;
import com.jenginetetris.Scenes.GameManager;
import javafx.scene.input.KeyCode;

public class TetrisController extends Player {
    public TetrisController() {
        super(Transform.exSimpleTransform(0,0), null, new Identity("controller"));
    }

    @Override
    public void Update() {
        if (Input.Down) {
            GameManager.moveDown();
        }
    }

    @Override
    public void onKeyPressed(KeyCode key)
    {
        if(key == KeyCode.LEFT || key == KeyCode.A)
        {
            GameManager.moveLeft();
        }
        else if(key == KeyCode.RIGHT || key == KeyCode.D)
        {
            GameManager.moveRight();
        }
        else if(key == KeyCode.UP || key == KeyCode.W)
        {
            GameManager.rotate();
        }
    }
}
