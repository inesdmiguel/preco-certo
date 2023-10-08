package org.academiadecodigo.jogo;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Coin {
    //Properties
    private Picture coin1;
    private Picture coin2;
    private Picture coin3;
    private Picture coin4;
    private Picture coin5;
    private boolean coin1Won;
    private boolean coin2Won;
    private boolean coin3Won;
    private boolean coin4Won;
    private boolean coin5Won;

    //Constructor
    public Coin() {
        coin1 = new Picture(1197, 43, "resources/Coin/image_coin.png");
        coin2 = new Picture(1131, 43, "resources/Coin/image_coin.png");
        coin3 = new Picture(1065, 50, "resources/Coin/image_coin.png");
        coin4 = new Picture(1000, 50, "resources/Coin/image_coin.png");
        coin5 = new Picture(934, 50, "resources/Coin/image_coin.png");
    }

    //Getters && Setters
    public boolean isCoin1Won() {
        return coin1Won;
    }

    public boolean isCoin2Won() {
        return coin2Won;
    }

    public boolean isCoin3Won() {
        return coin3Won;
    }

    public boolean isCoin4Won()  {
        return coin4Won;
    }

    public boolean isCoin5Won() {
        return coin5Won;
    }


    //Methods
    public void showCoin1() {
        coin1.draw();
        coin1Won = true;
    }

    public void showCoin2() {
        coin1.draw();
        coin2.draw();
        coin2Won = true;
    }

    public void showCoin3() {
        coin1.draw();
        coin2.draw();
        coin3.draw();
        coin3Won = true;
    }

    public void showCoin4() {
        coin1.draw();
        coin2.draw();
        coin3.draw();
        coin4.draw();
        coin4Won = true;
    }

    public void showCoin5() {
        coin1.draw();
        coin2.draw();
        coin3.draw();
        coin4.draw();
        coin5.draw();
        coin5Won = true;
    }

    public void deleteAllCoins() {
        coin1.delete();
        coin2.delete();
        coin3.delete();
        coin4.delete();
        coin5.delete();
    }
}
