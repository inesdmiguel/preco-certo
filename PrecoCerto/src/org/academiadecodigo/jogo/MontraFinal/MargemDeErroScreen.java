package org.academiadecodigo.jogo.MontraFinal;

import org.academiadecodigo.jogo.FirstScreens.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MargemDeErroScreen implements Screen {
    //Properties
    private Picture background;
    private Picture title;
    private Picture yellowButtonUnclicked;
    private Picture yellowButtonClicked;
    private Picture textButton;
    private Picture blueBox;
    private Picture greenBox;
    private Picture orangeBox;
    private Picture pinkBox;
    private Picture purpleBox;
    private Picture yellowBox;
    private Picture greyBox5;
    private Picture greyBox10;
    private Picture greyBox25;
    private Picture greyBox30;
    private Picture greyBox50;
    private Picture greyBox100;
    private Picture text5;
    private Picture text10;
    private Picture text25;
    private Picture text30;
    private Picture text50;
    private Picture text100;

    private int[] marginValues = {5, 10, 25, 30, 50, 100};

    //Constructor
    public MargemDeErroScreen() {
        background = new Picture(10, 10, "resources/StartScreen/background_blue.png");
        title = new Picture(140, 49, "resources/MontraFinal/MargemDeErro/title_montra_final.png");
        yellowButtonUnclicked = new Picture(500, 580, "resources/StartScreen/button_yellow_normal.png");
        yellowButtonClicked = new Picture(500, 580, "resources/MontraFinal/MargemDeErro/button_yellow_clicked.png");
        textButton = new Picture(515, 603, "resources/MontraFinal/MargemDeErro/text_button_choose.png");
        blueBox = new Picture(805, 194, "resources/MontraFinal/MargemDeErro/blue_box.png");
        greenBox = new Picture(143, 194, "resources/MontraFinal/MargemDeErro/green_box.png");
        orangeBox = new Picture(474, 194, "resources/MontraFinal/MargemDeErro/orange_box.png");
        pinkBox = new Picture(805, 367, "resources/MontraFinal/MargemDeErro/pink_box.png");
        purpleBox = new Picture(143, 367, "resources/MontraFinal/MargemDeErro/purple_box.png");
        yellowBox = new Picture(474, 367, "resources/MontraFinal/MargemDeErro/yellow_box.png");
        text5 = new Picture(266, 393, "resources/MontraFinal/MargemDeErro/text_5.png");
        text10 = new Picture(570, 393, "resources/MontraFinal/MargemDeErro/text_10.png");
        text25 = new Picture(224, 220, "resources/MontraFinal/MargemDeErro/text_25.png");
        text30 = new Picture(886, 220, "resources/MontraFinal/MargemDeErro/text_30.png");
        text50 = new Picture(886, 393, "resources/MontraFinal/MargemDeErro/text_50.png");
        text100 = new Picture(527, 220, "resources/MontraFinal/MargemDeErro/text_100.png");
        greyBox5 = new Picture(143, 367, "resources/MontraFinal/MargemDeErro/grey_box.png");
        greyBox10 = new Picture(474, 367, "resources/MontraFinal/MargemDeErro/grey_box.png");
        greyBox25 = new Picture(143, 194, "resources/MontraFinal/MargemDeErro/grey_box.png");
        greyBox30 = new Picture(805, 194, "resources/MontraFinal/MargemDeErro/grey_box.png");
        greyBox50 = new Picture(805, 367, "resources/MontraFinal/MargemDeErro/grey_box.png");
        greyBox100 = new Picture(474, 194, "resources/MontraFinal/MargemDeErro/grey_box.png");
    }

    //Methods
    @Override
    public void showScreen() {
        background.draw();
        title.draw();
        yellowButtonUnclicked.draw();
        textButton.draw();
        blueBox.draw();
        greenBox.draw();
        orangeBox.draw();
        pinkBox.draw();
        purpleBox.draw();
        yellowBox.draw();
        text5.draw();
        text10.draw();
        text25.draw();
        text30.draw();
        text50.draw();
        text100.draw();
    }

    @Override
    public void deleteScreen() {
        background.delete();
        title.delete();
        yellowButtonUnclicked.delete();
        textButton.delete();
        blueBox.delete();
        greenBox.delete();
        orangeBox.delete();
        pinkBox.delete();
        purpleBox.delete();
        yellowBox.delete();
        text5.delete();
        text10.delete();
        text25.delete();
        text30.delete();
        text50.delete();
        text100.delete();
    }

    public void clickYellowButton() {
        yellowButtonClicked.draw();
        textButton.draw();
        yellowButtonUnclicked.delete();
    }

    public int randomMargin() {
        int random = (int) Math.random() * 5;
        return marginValues[random];
    }

    public void chooseMargin() {
        switch (randomMargin()) {
            case 5:
                greyBox10.draw();
                greyBox25.draw();
                greyBox30.draw();
                greyBox50.draw();
                greyBox100.draw();
                text10.draw();
                text25.draw();
                text30.draw();
                text50.draw();
                text100.draw();
                break;
            case 10:
                greyBox5.draw();
                greyBox25.draw();
                greyBox30.draw();
                greyBox50.draw();
                greyBox100.draw();
                text5.draw();
                text25.draw();
                text30.draw();
                text50.draw();
                text100.draw();
                break;
            case 25:
                greyBox5.draw();
                greyBox10.draw();
                greyBox30.draw();
                greyBox50.draw();
                greyBox100.draw();
                text5.draw();
                text10.draw();
                text30.draw();
                text50.draw();
                text100.draw();
                break;
            case 30:
                greyBox5.draw();
                greyBox10.draw();
                greyBox25.draw();
                greyBox50.draw();
                greyBox100.draw();
                text5.draw();
                text10.draw();
                text25.draw();
                text50.draw();
                text100.draw();
                break;
            case 50:
                greyBox5.draw();
                greyBox10.draw();
                greyBox25.draw();
                greyBox30.draw();
                greyBox100.draw();
                text5.draw();
                text10.draw();
                text25.draw();
                text30.draw();
                text100.draw();
                break;
            case 100:
                greyBox5.draw();
                greyBox10.draw();
                greyBox25.draw();
                greyBox30.draw();
                greyBox50.draw();
                text5.draw();
                text10.draw();
                text25.draw();
                text30.draw();
                text50.draw();
                break;
        }
    }

}
