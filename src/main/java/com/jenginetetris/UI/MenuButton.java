package com.jenginetetris.UI;

import com.JEngine.Core.Position.Vector2;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class MenuButton extends Button {

    public MenuButton(Vector2 startPos, float scale, String text, Color borderColor, Color textColor, EventHandler onClick) {
        super(text);

        setScaleX(scale);
        setScaleY(scale);

        // set the width and height
        setPrefWidth(scale * 128);
        setPrefHeight(scale * 64);
        setLayoutX(startPos.x);
        setLayoutY(startPos.y);
        // remove background
        setStyle("-fx-border-color: transparent;");

        // set the text color
        setTextFill(textColor);

        // set the border color
        setStyle("-fx-background-color: #" + borderColor.toString().substring(2) + ";");

        setOnAction(onClick);
    }
}
