package org.academiadecodigo.jogo.FinalScreens;

import org.academiadecodigo.jogo.FirstScreens.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver implements Screen {
    //Properties
    private Picture gameOverImage;

    //Constructor
    public GameOver() {
        gameOverImage = new Picture(10, 10, "resources/FinalScreens/GameOver/image_game_over.png");
    }

    //Methods
    @Override
    public void showScreen() {
        gameOverImage.draw();
    }

    @Override
    public void deleteScreen() {
        gameOverImage.delete();
    }
}
