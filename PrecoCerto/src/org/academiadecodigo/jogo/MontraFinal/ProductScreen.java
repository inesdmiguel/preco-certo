package org.academiadecodigo.jogo.MontraFinal;

import org.academiadecodigo.jogo.FirstScreens.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ProductScreen implements Screen {
    //Properties
    private Picture background;
    private Picture title;
    private Picture imageViagem;
    private Picture imageGomas;
    private Picture imageTrotinete;
    private Picture imageMagalhães;
    private Picture imageToy;
    private Picture imageDuck;
    private Picture buttonGuess;
    private Picture buttonText;
    private Picture yellowButtonLeft;
    private Picture yellowButtonRight;
    private Picture greyButtonLeft;
    private Picture greyButtonRight;

    //Booleans
    private boolean product1Showing;
    private boolean product2Showing;
    private boolean product3Showing;
    private boolean product4Showing;
    private boolean product5Showing;
    private boolean product6Showing;
    private boolean requestNext;


    //Constructor
    public ProductScreen() {
        background = new Picture(10, 10, "resources/StartScreen/background_blue.png");
        title = new Picture(140, 49, "resources/MontraFinal/MargemDeErro/title_montra_final.png");
        imageDuck = new Picture(216, 195, "resources/MontraFinal/ProductScreen/image_product_duck.png");
        imageToy = new Picture(216, 195, "resources/MontraFinal/ProductScreen/image_product_toy.png");
        imageMagalhães = new Picture(216, 195, "resources/MontraFinal/ProductScreen/image_product_magalhães.png");
        imageTrotinete = new Picture(216, 195, "resources/MontraFinal/ProductScreen/image_product_trotinete.png");
        imageViagem = new Picture(216, 195, "resources/MontraFinal/ProductScreen/image_product_viagem.png");
        imageGomas = new Picture(216, 195, "resources/MontraFinal/ProductScreen/image_product_gomas.png");
        buttonGuess = new Picture(500, 610, "resources/StartScreen/button_yellow_normal.png");
        buttonText = new Picture(520, 625, "resources/MontraFinal/ProductScreen/text_button_guess.png");
        yellowButtonLeft = new Picture(72, 338, "resources/MontraFinal/ProductScreen/button_yellow_left.png");
        yellowButtonRight = new Picture(1104, 338, "resources/MontraFinal/ProductScreen/button_yellow_right.png");
        greyButtonLeft = new Picture(72, 338, "resources/MontraFinal/ProductScreen/button_grey_left.png");
        greyButtonRight = new Picture(1104, 338, "resources/MontraFinal/ProductScreen/button_grey_right.png");
    }

    //Getters && Setters
    public boolean isProduct1Showing() {
        return product1Showing;
    }

    public boolean isProduct2Showing() {
        return product2Showing;
    }

    public boolean isProduct3Showing() {
        return product3Showing;
    }

    public boolean isProduct4Showing() {
        return product4Showing;
    }

    public boolean isProduct5Showing() {
        return product5Showing;
    }

    public boolean isProduct6Showing() {
        return product6Showing;
    }

    public boolean getRequestNext() {
        return requestNext;
    }

    public void setProduct1Showing(boolean product1Showing) {
        this.product1Showing = product1Showing;
    }

    public void setProduct2Showing(boolean product2Showing) {
        this.product2Showing = product2Showing;
    }

    public void setProduct3Showing(boolean product3Showing) {
        this.product3Showing = product3Showing;
    }

    public void setProduct4Showing(boolean product4Showing) {
        this.product4Showing = product4Showing;
    }

    public void setProduct5Showing(boolean product5Showing) {
        this.product5Showing = product5Showing;
    }

    public void setProduct6Showing(boolean product6Showing) {
        this.product6Showing = product6Showing;
    }

    //Methods
    @Override
    public void showScreen() {
        background.draw();
        title.draw();
        buttonGuess.draw();
        buttonText.draw();
        showProduct1();
        greyButtonLeft.draw();
        yellowButtonRight.draw();
    }

    @Override
    public void deleteScreen() {
        requestNext = true;
        background.delete();
        title.delete();
        buttonGuess.delete();
        buttonText.delete();
        deleteProduct1();
        deleteProduct2();
        deleteProduct3();
        deleteProduct4();
        deleteProduct5();
        deleteProduct6();
        yellowButtonLeft.delete();
        yellowButtonRight.delete();
        greyButtonLeft.delete();
        greyButtonRight.delete();
    }

    //Methods to show products
    public boolean showProduct1() {
        imageDuck.draw();
        return product1Showing = true;
    }

    public boolean showProduct2() {
        imageToy.draw();
        return product2Showing = true;
    }

    public boolean showProduct3() {
        imageMagalhães.draw();
        return product3Showing = true;
    }

    public boolean showProduct4() {
        imageTrotinete.draw();
        return product4Showing = true;
    }

    public boolean showProduct5() {
        imageViagem.draw();
        return product5Showing = true;
    }

    public boolean showProduct6() {
        imageGomas.draw();
        return product6Showing = true;
    }

    //Methods to delete products
    public void deleteProduct1() {
        product1Showing = false;
        imageDuck.delete();
    }

    public void deleteProduct2() {
        product2Showing = false;
        imageToy.delete();
    }

    public void deleteProduct3() {
        product3Showing = false;
        imageMagalhães.delete();
    }

    public void deleteProduct4() {
        product4Showing = false;
        imageTrotinete.delete();
    }

    public void deleteProduct5() {
        product5Showing = false;
        imageViagem.delete();
    }

    public void deleteProduct6() {
        product6Showing = false;
        imageGomas.delete();
    }
}