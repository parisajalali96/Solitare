package org.example.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashMap;

public class GameAssetManager {

    public static HashMap<String, Texture> textureMap = new HashMap<>(); // texture map to avoid re-instantiation
    public static HashMap<String, Music> playlistMap = new HashMap<>();
    public static Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

    // gets from texture map or loads texture
    public static Texture getOrLoadTexture(String fileName) {
        if(textureMap.containsKey(fileName)) return textureMap.get(fileName);
        Texture texture = new Texture(fileName);
        textureMap.put(fileName, texture);
        return texture;
    }


}
