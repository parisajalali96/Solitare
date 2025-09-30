package org.example.Controllers;

import org.example.Models.GameState;

public class GameController {
    private GameState gameState;

    public GameController(){
        gameState = new GameState();
    }

    public GameState getGameState() {
        return gameState;
    }
}
