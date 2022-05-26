package com.jenginetetris.Game;

import com.JEngine.Core.GameImage;
import com.JEngine.Core.Identity;
import com.JEngine.Core.Position.Transform;
import com.JEngine.Game.PlayersAndPawns.Pawn;

public class Block extends Pawn {
    public Block(Transform transform, GameImage newSprite, Identity identity) {
        super(transform, newSprite, identity);
    }
}
