package org.academiadecodigo.jogo.Rounds;
import org.academiadecodigo.jogo.Options.Options;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Round2 extends Round {
    //Properties
    private Picture background;
    private Picture roundTitle;
    private Picture product2;
    private Picture yellowButtonNormalA;
    private Picture yellowButtonNormalB;
    private Picture yellowButtonNormalC;
    private Picture yellowButtonNormalD;
    private Picture greenButtonCorrectA;
    private Picture redButtonWrongB;
    private Picture redButtonWrongC;
    private Picture redButtonWrongD;
    private Picture priceA;
    private Picture priceB;
    private Picture priceC;
    private Picture priceD;

    //Constructor
    public Round2() {
        background = new Picture(10, 10, "resources/StartScreen/background_blue.png");
        roundTitle = new Picture(438, 28, "resources/Round2/text_round2_title.png");
        product2 = new Picture(226, 138, "resources/Round2/image_product_speaker.png");
        yellowButtonNormalA = new Picture(356,540, "resources/Round1/button_yellow.png");
        yellowButtonNormalB = new Picture(726,540, "resources/Round1/button_yellow.png");
        yellowButtonNormalC = new Picture(356, 623, "resources/Round1/button_yellow.png");
        yellowButtonNormalD = new Picture(726, 623, "resources/Round1/button_yellow.png");

        greenButtonCorrectA = new Picture(356, 540, "resources/Round1/button_green.png");
        redButtonWrongB = new Picture(726, 540, "resources/Round1/button_red.png");
        redButtonWrongC = new Picture(356, 623, "resources/Round1/button_red.png");
        redButtonWrongD = new Picture(726, 623, "resources/Round1/button_red.png");

        priceA = new Picture(367, 560, "resources/Round2/text_price_A.png");
        priceB = new Picture(737, 560, "resources/Round2/text_price_B.png");
        priceC = new Picture(367, 644, "resources/Round2/text_price_C.png");
        priceD = new Picture(737, 644, "resources/Round2/text_price_D.png");
    }

    //Methods
    public void showScreen() {
        background.draw();
        roundTitle.draw();
        product2.draw();

        yellowButtonNormalA.draw();
        yellowButtonNormalB.draw();
        yellowButtonNormalC.draw();
        yellowButtonNormalD.draw();

        priceA.draw();
        priceB.draw();
        priceC.draw();
        priceD.draw();
    }

    public void deleteScreen() {
        background.delete();
        roundTitle.delete();
        product2.delete();
        yellowButtonNormalA.delete();
        yellowButtonNormalB.delete();
        yellowButtonNormalC.delete();
        yellowButtonNormalD.delete();

        greenButtonCorrectA.delete();

        redButtonWrongB.delete();
        redButtonWrongC.delete();
        redButtonWrongD.delete();

        priceA.delete();
        priceB.delete();
        priceC.delete();
        priceD.delete();
    }

    public boolean isOptionIncorrect(Options options){
        switch (options){
            case B:
                return true;
            case C:
                return true;
            case D:
                return true;
        }
        return false;
    }

    public boolean isOptionCorrect(Options options) {
        if (options == Options.A) {
            return true;

        } else return false;
    }

    public void showOptionWrongB(){
        redButtonWrongB.draw();
        priceB.draw();
        yellowButtonNormalB.delete();
    }

    public void showOptionWrongC(){
        redButtonWrongC.draw();
        priceC.draw();
        yellowButtonNormalC.delete();
    }

    public void showOptionWrongD(){
        redButtonWrongD.draw();
        priceD.draw();
        yellowButtonNormalD.delete();

    }

    public void showOptionCorrectA(){
        greenButtonCorrectA.draw();
        priceA.draw();
        yellowButtonNormalA.delete();
    }

}
