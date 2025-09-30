package org.example.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.example.Controllers.GameController;
import org.example.Models.*;

import java.util.List;

public class GameView implements Screen {
    private SpriteBatch batch;
    private GameController gameController;

    private Card selectedCard = null;
    private Pile selectedPile = null;

    private List<TableauPile> tableaus;
    private List<FoundationPile> foundations;
    private DeckPile deck;
    private WastePile waste;

    public GameView(GameController gameController) {
        this.gameController = gameController;
        tableaus = gameController.getGameState().getTableaus();
        foundations = gameController.getGameState().getFoundations();
        deck = gameController.getGameState().getDeck();
        waste = gameController.getGameState().getWaste();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                handleClick(screenX, Gdx.graphics.getHeight() - screenY);
                return true;
            }
        });
    }

    private void handleClick(int x, int y) {
        for (TableauPile pile : tableaus) {
            if (!pile.isEmpty()) {
                Card top = pile.peek();
                if (isCardClicked(top, x, y)) {
                    selectCard(top, pile);
                    return;
                }
            }
        }

        if (!waste.isEmpty()) {
            Card top = waste.peek();
            if (isCardClicked(top, x, y)) {
                selectCard(top, waste);
                return;
            }
        }

        if (selectedCard != null) {
            for (TableauPile pile : tableaus) {
                if (pile.isMoveValid(selectedCard)) {
                    selectedPile.removeCard();
                    pile.addCard(selectedCard);
                    selectedCard = null;
                    selectedPile = null;
                    return;
                }
            }
            for (FoundationPile pile : foundations) {
                if (pile.isMoveValid(selectedCard)) {
                    selectedPile.removeCard();
                    pile.addCard(selectedCard);
                    selectedCard = null;
                    selectedPile = null;
                    return;
                }
            }

            selectedCard = null;
            selectedPile = null;
        }
    }

    private boolean isCardClicked(Card card, int x, int y) {
        // TODO
        return false;
    }

    private void selectCard(Card card, Pile pile) {
        selectedCard = card;
        selectedPile = pile;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
