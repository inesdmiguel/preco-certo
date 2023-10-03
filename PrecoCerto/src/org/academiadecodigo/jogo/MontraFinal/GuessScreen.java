package org.academiadecodigo.jogo.MontraFinal;

import org.academiadecodigo.jogo.FirstScreens.Screen;
import org.academiadecodigo.jogo.Options.Options;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GuessScreen implements Screen {

    //Properties
    private Picture background;
    private Picture title;
    private Picture whiteBackground;
    private Picture productList;

    //Unclicked Yellow Buttons
    private Picture yellowButtonUnclickedA;
    private Picture yellowButtonUnclickedB;
    private Picture yellowButtonUnclickedC;
    private Picture yellowButtonUnclickedD;

    //Clicked Yellow Buttons
    private Picture yellowButtonClickedA;
    private Picture yellowButtonClickedB;
    private Picture yellowButtonClickedC;
    private Picture yellowButtonClickedD;

    //Clicked Green Button
    private Picture greenButtonClickedC;

    //Unclicked Green Button
    private Picture greenButtonUnclickedC;

    //Clicked Red Buttons
    private Picture redButtonClickedA;
    private Picture redButtonClickedB;
    private Picture redButtonClickedD;

    //Price Options
    private Picture priceOptionA;
    private Picture priceOptionB;
    private Picture priceOptionC;
    private Picture priceOptionD;

    //Constructor
    public GuessScreen() {
        background = new Picture(10, 10, "resources/StartScreen/background_blue.png");
        title = new Picture(140, 49, "resources/MontraFinal/MargemDeErro/title_montra_final.png");
        whiteBackground = new Picture(216, 195, "resources/MontraFinal/ProductScreen/background_product_white.png");
        productList = new Picture(234, 196, "resources/MontraFinal/GuessScreen/text_product_list.png");
        yellowButtonUnclickedA = new Picture(68, 588, "resources/MontraFinal/GuessScreen/button_yellow_unclicked.png");
        yellowButtonUnclickedB = new Picture(359, 588, "resources/MontraFinal/GuessScreen/button_yellow_unclicked.png");
        yellowButtonUnclickedC = new Picture(650, 588, "resources/MontraFinal/GuessScreen/button_yellow_unclicked.png");
        yellowButtonUnclickedD = new Picture(941, 588, "resources/MontraFinal/GuessScreen/button_yellow_unclicked.png");
        yellowButtonClickedA = new Picture(68, 588, "resources/MontraFinal/GuessScreen/button_yellow_clicked.png");
        yellowButtonClickedB = new Picture(359, 588, "resources/MontraFinal/GuessScreen/button_yellow_clicked.png");
        yellowButtonClickedC = new Picture(650, 588, "resources/MontraFinal/GuessScreen/button_yellow_clicked.png");
        yellowButtonClickedD = new Picture(941, 588, "resources/MontraFinal/GuessScreen/button_yellow_clicked.png");
        greenButtonClickedC = new Picture(650, 588, "resources/MontraFinal/GuessScreen/button_green_clicked.png");
        greenButtonUnclickedC = new Picture (650, 588, "resources/MontraFinal/GuessScreen/button_green_unclicked.png");
        redButtonClickedA = new Picture(68, 588, "resources/MontraFinal/GuessScreen/button_red_clicked.png");
        redButtonClickedB = new Picture(359, 588, "resources/MontraFinal/GuessScreen/button_red_clicked.png");
        redButtonClickedD = new Picture(941, 588, "resources/MontraFinal/GuessScreen/button_red_clicked.png");
        priceOptionA = new Picture(85, 615, "resources/MontraFinal/GuessScreen/text_option_A.png");
        priceOptionB = new Picture(374, 615, "resources/MontraFinal/GuessScreen/text_option_B.png");
        priceOptionC = new Picture(666, 615, "resources/MontraFinal/GuessScreen/text_option_C.png");
        priceOptionD = new Picture(956, 615, "resources/MontraFinal/GuessScreen/text_option_D.png");
    }

    //Methods
    @Override
    public void showScreen() {
        background.draw();
        title.draw();
        whiteBackground.draw();
        productList.draw();
        yellowButtonUnclickedA.draw();
        yellowButtonUnclickedB.draw();
        yellowButtonUnclickedC.draw();
        yellowButtonUnclickedD.draw();
        priceOptionA.draw();
        priceOptionB.draw();
        priceOptionC.draw();
        priceOptionD.draw();
    }

    @Override
    public void deleteScreen() {
        background.delete();
        whiteBackground.delete();
        productList.delete();
    }

    //Methods that change the yellow button to clicked
    public void clickOptionA() {
        yellowButtonClickedA.draw();
        priceOptionA.draw();
    }

    public void clickOptionB() {
        yellowButtonClickedB.draw();
        priceOptionB.draw();
    }

    public void clickOptionC() {
        yellowButtonClickedC.draw();
        priceOptionC.draw();
    }

    public void clickOptionD() {
        yellowButtonClickedD.draw();
        priceOptionD.draw();
    }

    //Methods that show that the chosen option is wrong, and also show the correct option
    public void optionAIncorrect() {
        redButtonClickedA.draw();
        priceOptionA.draw();
        yellowButtonClickedA.delete();
        greenButtonUnclickedC.draw();
    }

    public void optionBIncorrect() {
        redButtonClickedB.draw();
        priceOptionB.draw();
        yellowButtonClickedB.delete();
        greenButtonUnclickedC.draw();
    }

    public void optionDIncorrect() {
        redButtonClickedD.draw();
        priceOptionD.draw();
        yellowButtonClickedD.delete();
        greenButtonUnclickedC.draw();
    }

    //Method to show that the chosen option is correct
    public void optionCCorrect() {
        greenButtonClickedC.draw();
        priceOptionC.draw();
        yellowButtonClickedC.delete();
    }

    public boolean isOptionIncorrect(Options options) {
        switch (options) {
            case A:
                return true;
            case B:
                return true;
            case D:
                return true;
        }
        return false;
    }

    public boolean isOptionCorrect(Options options) {
        if (options == Options.C) {
            return true;

        } else return false;
    }
}
