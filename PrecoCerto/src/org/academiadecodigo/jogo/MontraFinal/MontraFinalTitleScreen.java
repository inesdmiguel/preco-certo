package org.academiadecodigo.jogo.MontraFinal;
import org.academiadecodigo.jogo.FirstScreens.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MontraFinalTitleScreen implements Screen {
    //Properties
    private Picture background;
    private Picture titleMontraFinal;
    private Picture textPressEnter;

    //Constructor
    public MontraFinalTitleScreen() {
        background = new Picture(10, 10, "resources/MontraFinal/TitleScreen/picture_background_montra_final_title.png");
        titleMontraFinal = new Picture(267, 163, "resources/MontraFinal/TitleScreen/text_title_montra_final.png");
        textPressEnter = new Picture(26, 650, "resources/MontraFinal/TitleScreen/text_press_space_montra.png");
    }

    //Methods
    @Override
    public void showScreen() {
        background.draw();
        titleMontraFinal.draw();
        textPressEnter.draw();
    }

    @Override
    public void deleteScreen() {
        background.delete();
        titleMontraFinal.delete();
        textPressEnter.delete();
    }
}
