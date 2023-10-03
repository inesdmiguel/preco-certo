package org.academiadecodigo.jogo.FirstScreens;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RulesScreen implements Screen{
    //Properties
    private Picture background;
    private Picture textTitle;
    private Picture textRules;
    private Picture textPressSpace;

    //Constructor
    public RulesScreen() {
        background = new Picture(10, 10, "resources/StartScreen/background_blue.png");
        textTitle = new Picture(371, 72, "resources/RulesScreen/text_title_regras.png");
        textRules = new Picture(72, 211, "resources/RulesScreen/text_rules.png");
        textPressSpace = new Picture(26, 650, "resources/RulesScreen/text_space_continue.png");
    }

    //Methods
    @Override
    public void showScreen() {
        background.draw();
        textTitle.draw();
        textRules.draw();
        textPressSpace.draw();
    }

    @Override
    public void deleteScreen() {
        background.delete();
        textTitle.delete();
        textRules.delete();
        textPressSpace.delete();
    }

}
