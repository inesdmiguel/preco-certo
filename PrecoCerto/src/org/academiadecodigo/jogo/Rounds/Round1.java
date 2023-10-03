package org.academiadecodigo.jogo.Rounds;

import org.academiadecodigo.jogo.Options.Options;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Round1 extends Round {
    //Properties
    private Picture background;
    private Picture roundTitle;
    private Picture product1;
    private Picture yellowButtonNormalA;
    private Picture yellowButtonNormalB;
    private Picture yellowButtonNormalC;
    private Picture yellowButtonNormalD;
    private Picture greenButtonCorrectC;
    private Picture redButtonWrongA;
    private Picture redButtonWrongB;
    private Picture redButtonWrongD;
    private Picture priceA;
    private Picture priceB;
    private Picture priceC;
    private Picture priceD;
    private boolean correct;

    //Constructor
    public Round1() {
        background = new Picture(10, 10, "resources/StartScreen/background_blue.png");
        roundTitle = new Picture(438, 28, "resources/Round1/text_round1_title.png");
        product1 = new Picture(226, 138, "resources/Round1/image_product_pizza.png");
        yellowButtonNormalA = new Picture(356, 540, "resources/Round1/button_yellow.png");
        yellowButtonNormalB = new Picture(726, 540, "resources/Round1/button_yellow.png");
        yellowButtonNormalC = new Picture(356, 623, "resources/Round1/button_yellow.png");
        yellowButtonNormalD = new Picture(726, 623, "resources/Round1/button_yellow.png");

        redButtonWrongA = new Picture(356, 540, "resources/Round1/button_red.png");
        redButtonWrongB = new Picture(726, 540, "resources/Round1/button_red.png");
        greenButtonCorrectC = new Picture(356, 623, "resources/Round1/button_green.png");
        redButtonWrongD = new Picture(726, 623, "resources/Round1/button_red.png");

        priceA = new Picture(367, 560, "resources/Round1/text_price_A.png");
        priceB = new Picture(737, 560, "resources/Round1/text_price_B.png");
        priceC = new Picture(367, 644, "resources/Round1/text_price_C.png");
        priceD = new Picture(737, 644, "resources/Round1/text_price_D.png");
    }

    //Methods
    public void showScreen() {
        background.draw();
        roundTitle.draw();
        product1.draw();

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
        yellowButtonNormalA.delete();
        yellowButtonNormalB.delete();
        yellowButtonNormalC.delete();
        yellowButtonNormalD.delete();

        redButtonWrongA.delete();
        redButtonWrongB.delete();
        greenButtonCorrectC.delete();
        redButtonWrongD.delete();

        priceA.delete();
        priceB.delete();
        priceC.delete();
        priceD.delete();
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

    public void showOptionWrongA() {
        redButtonWrongA.draw();
        priceA.draw();
        yellowButtonNormalA.delete();
    }

    public void showOptionWrongB() {
        redButtonWrongB.draw();
        priceB.draw();
        yellowButtonNormalB.delete();
    }

    public void showOptionWrongD() {
        redButtonWrongB.draw();
        priceD.draw();
        yellowButtonNormalB.delete();
    }

    public void showOptionCorrectC() {
        greenButtonCorrectC.draw();
        priceC.draw();
        yellowButtonNormalC.delete();
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
