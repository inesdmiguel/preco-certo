package org.academiadecodigo.jogo;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Coins {
    //Properties
    private Picture coin1;
    private Picture coin2;
    private Picture coin3;
    private Picture coin4;
    private Picture coin5;
    private boolean coin1drawn;
    private boolean coin2drawn;
    private boolean coin3drawn;
    private boolean coin4drawn;
    private boolean coin5drawn;

    //Constructor
    public Coins() {
        coin1 = new Picture(1197, 43, "resources/Coin/image_coin.png");
        coin2 = new Picture(1131, 43, "resources/Coin/image_coin.png");
        coin3 = new Picture(1065, 50, "resources/Coin/image_coin.png");
        coin4 = new Picture(1000, 50, "resources/Coin/image_coin.png");
        coin5 = new Picture(934, 50, "resources/Coin/image_coin.png");
    }

    //Methods
    public boolean showCoin1() {
        coin1.draw();
        return coin1drawn = true;
    }

    public boolean showCoin2() {
        coin2.draw();
        return coin2drawn = true;
    }

    public boolean showCoin3() {
        coin3.draw();
        return coin3drawn = true;
    }

    public boolean showCoin4() {
        coin4.draw();
        return coin4drawn = true;
    }

    public boolean showCoin5() {
        coin5.draw();
        return coin5drawn = true;
    }

    public void deleteAllCoins() {
        coin1.delete();
        coin2.delete();
        coin3.delete();
        coin4.delete();
        coin5.delete();
    }
}
