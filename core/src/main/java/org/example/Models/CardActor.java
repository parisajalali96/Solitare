package org.example.Models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CardActor extends Actor {
    private Card card;
    private Texture front;
    private Texture back;
    private boolean faceUp;

    public CardActor(Card card) {
        this.card = card;
        this.front = GameAssetManager.getOrLoadTexture("Pixel Art Card Deck/" +
            card.getSuit().getName() + "/" + card.getRank().getName() + ".png");
        this.back = GameAssetManager.cardBack;
        this.faceUp = card.isFaceUp();

        setSize(64, 90);
    }

    public void draw(SpriteBatch batch, float parentAlpha) {
        batch.draw(faceUp ? front : back, getX(), getY(), getWidth(), getHeight());
    }

    public Card getCard() { return card; }
    public void flip(boolean faceUp) { this.faceUp = faceUp; }
}
