package org.academiadecodigo.jogo.FinalScreens;

import org.academiadecodigo.jogo.FirstScreens.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WinScreen implements Screen {
    //Properties
    private Picture winGameScreen;

    //Constructor
    public WinScreen() {
        winGameScreen = new Picture(10, 10, "resources/FinalScreens/WinScreen/image_win_screen.png");
    }

    //Methods
    @Override
    public void showScreen() {
        winGameScreen.draw();
    }

    @Override
    public void deleteScreen() {
        winGameScreen.delete();
    }
}
