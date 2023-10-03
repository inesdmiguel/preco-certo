package org.academiadecodigo.jogo.FirstScreens;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartScreen implements Screen {

    //Properties
    private Picture background;
    private Picture textTitle;
    private Picture textPressSpace;
    private Picture yellowButtonNormal;
    private Picture textStartButton;
    private Picture fernandoMendes;

    //Constructor
    public StartScreen()  {
        background = new Picture(10, 10, "resources/StartScreen/picture_background.png");
        textTitle = new Picture(235, 98, "resources/StartScreen/text_title_black_shadow.png");
        textPressSpace = new Picture(26, 650, "resources/StartScreen/text_press_space.png");
        yellowButtonNormal = new Picture(500, 524, "resources/StartScreen/button_yellow_normal.png");
        textStartButton = new Picture(515, 534, "resources/StartScreen/text_start_button.png");
        fernandoMendes = new Picture (890, 130, "resources/StartScreen/image_fernando_mendes_bigger.png");
    }

    //Methods
    @Override
    public void showScreen() {
        background.draw();
        textTitle.draw();
        fernandoMendes.draw();
        textPressSpace.draw();
        yellowButtonNormal.draw();
        textStartButton.draw();
    }

    @Override
    public void deleteScreen() {
        background.delete();
        textTitle.delete();
        textPressSpace.delete();
        yellowButtonNormal.delete();
        textStartButton.delete();
        fernandoMendes.delete();
    }

}