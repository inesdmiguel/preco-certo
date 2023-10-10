package org.academiadecodigo.jogo.Game;
import org.academiadecodigo.jogo.Coin;
import org.academiadecodigo.jogo.FinalScreens.GameOver;
import org.academiadecodigo.jogo.FinalScreens.WinScreen;
import org.academiadecodigo.jogo.MontraFinal.GuessScreen;
import org.academiadecodigo.jogo.MontraFinal.MargemDeErroScreen;
import org.academiadecodigo.jogo.MontraFinal.MontraFinalTitleScreen;
import org.academiadecodigo.jogo.MontraFinal.ProductScreen;
import org.academiadecodigo.jogo.Rounds.*;
import org.academiadecodigo.jogo.FirstScreens.RulesScreen;
import org.academiadecodigo.jogo.FirstScreens.StartScreen;
import org.academiadecodigo.jogo.Options.Options;
import org.academiadecodigo.jogo.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler{
    //Properties
    public Keyboard keyboard;
    private Coin coins;
    boolean[] hasCoin;
    private int countCoins;

    //Starting Screens
    private StartScreen startScreen;
    private RulesScreen rulesScreen;

    //Rounds
    private Round1 round1;
    private Round2 round2;
    private Round3 round3;
    private Round4 round4;
    private Round5 round5;

    //Montra Final
    private MontraFinalTitleScreen montraFinalTitleScreen;
    private MargemDeErroScreen margemDeErroScreen;
    private ProductScreen productScreen;
    private GuessScreen guessScreen;
    private GameOver gameOver;
    private WinScreen winScreen;

    //Constructor
    public Game() {
        keyboard = new Keyboard(this);
        createKeyboardEvents();
        startScreen = new StartScreen();
        rulesScreen = new RulesScreen();
        round1 = new Round1();
        round2 = new Round2();
        round3 = new Round3();
        round4 = new Round4();
        round5 = new Round5();
        montraFinalTitleScreen = new MontraFinalTitleScreen();
        margemDeErroScreen = new MargemDeErroScreen();
        productScreen = new ProductScreen();
        guessScreen = new GuessScreen();
        gameOver = new GameOver();
        winScreen = new WinScreen();
        coins = new Coin();
        hasCoin = new boolean[5];
    }

    //Methods
    public void start() {
        startScreen.showScreen();
        Sound.playSound("/Sound/game_intro.wav", 7000);
    }

    //Keyboard Events
    public void createKeyboardEvents() {
        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventEnter = new KeyboardEvent();
        keyboardEventEnter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventEnter.setKey(KeyboardEvent.KEY_ENTER);
        keyboard.addEventListener(keyboardEventEnter);


        KeyboardEvent keyboardEventA = new KeyboardEvent();
        keyboardEventA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventA.setKey(KeyboardEvent.KEY_A);
        keyboard.addEventListener(keyboardEventA);

        KeyboardEvent keyboardEventB = new KeyboardEvent();
        keyboardEventB.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventB.setKey(KeyboardEvent.KEY_B);
        keyboard.addEventListener(keyboardEventB);

        KeyboardEvent keyboardEventC = new KeyboardEvent();
        keyboardEventC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventC.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(keyboardEventC);

        KeyboardEvent keyboardEventD = new KeyboardEvent();
        keyboardEventD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventD.setKey(KeyboardEvent.KEY_D);
        keyboard.addEventListener(keyboardEventD);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(keyboardEventRight);
    }

    //Overrides
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                if (!startScreen.getRequestNext()) {
                    startScreen.deleteScreen();
                    rulesScreen.showScreen();
                } else if (!rulesScreen.getRequestNext()) {
                    rulesScreen.deleteScreen();
                    round1.showScreen();
                }
                break;

            case KeyboardEvent.KEY_A:
                if (rulesScreen.getRequestNext() && !round1.getRequestNext()) {
                    round1.showOptionWrongA();
                    System.out.println("passou round 1 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round1.deleteScreen();
                    round2.showScreen();
                    break;
                }

                if (round1.getRequestNext() && !round2.getRequestNext()) {
                    round2.showOptionCorrectA();
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    System.out.println("passou round 2 correto");
                    countCoins++;
                    round2.deleteScreen();
                    round3.showScreen();
                    if (coins.isCoin1Won()) {
                        coins.showCoin2();
                    } else {
                        coins.showCoin1();
                    }
                    break;
                }

                if (round2.getRequestNext() && !round3.getRequestNext()) {
                    round3.showOptionWrongA();
                    System.out.println("passou round 3 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round3.deleteScreen();
                    round4.showScreen();
                    if (coins.isCoin1Won() && !coins.isCoin2Won()) {
                        coins.showCoin1();
                    } else if (coins.isCoin2Won()) {
                        coins.showCoin2();
                    }
                    break;
                }

                if (round3.getRequestNext() && !round4.getRequestNext()) {
                    round4.showOptionWrongA();
                    System.out.println("passou round 4 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round4.deleteScreen();
                    round5.showScreen();
                    if (coins.isCoin1Won() && !coins.isCoin2Won()) {
                        coins.showCoin1();
                    } else if (coins.isCoin2Won() && !coins.isCoin3Won()) {
                        coins.showCoin2();
                    } else if (coins.isCoin3Won()) {
                        coins.showCoin3();
                    }
                    break;
                }

                if (round4.getRequestNext() && !round5.getRequestNext()) {
                    round5.showOptionWrongA();
                    System.out.println("passou round 5 incorreto");
                    if (countCoins >= 3) {
                        round5.deleteScreen();
                        montraFinalTitleScreen.showScreen();
                        System.out.println("You have " + countCoins + " coins");
                        System.out.println("Aparecimento da montra final");
                    } else {
                        Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                        round5.deleteScreen();
                        gameOver.showScreen();
                        System.out.println("You have " + countCoins + " coins");
                        System.out.println("Não sabe o preço certo!");
                        break;
                    }
                    break;
                }

                if (productScreen.getRequestNext() && !guessScreen.getRequestNext()) {
                    gameOver.showScreen();
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                }
                break;


            case KeyboardEvent.KEY_B:
                if (rulesScreen.getRequestNext() && !round1.getRequestNext()) {
                    round1.showOptionWrongB();
                    System.out.println("passou round 1 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round1.deleteScreen();
                    round2.showScreen();
                    break;
                }

                if (round1.getRequestNext() && !round2.getRequestNext()) {
                    round2.showOptionWrongB();
                    System.out.println("passou round 2 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round2.deleteScreen();
                    round3.showScreen();
                    if (coins.isCoin1Won()) {
                        coins.showCoin1();
                    }
                    break;
                }

                if (round2.getRequestNext() && !round3.getRequestNext()) {
                    round3.showOptionCorrectB();
                    countCoins++;
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    System.out.println("passou round 3 correto");
                    round3.deleteScreen();
                    round4.showScreen();
                    if (!coins.isCoin1Won()) {
                        coins.showCoin1();
                    } else if (coins.isCoin1Won() && !coins.isCoin2Won()) {
                        coins.showCoin2();
                    } else if (coins.isCoin1Won() && coins.isCoin2Won()) {
                        coins.showCoin1();
                        coins.showCoin3();
                    }
                    break;
                }

                if (round3.getRequestNext() && !round4.getRequestNext()) {
                    round4.showOptionWrongB();
                    System.out.println("passou round 4 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round4.deleteScreen();
                    round5.showScreen();
                    if (coins.isCoin1Won() && !coins.isCoin2Won()) {
                        coins.showCoin1();
                    } else if (coins.isCoin2Won() && !coins.isCoin3Won()) {
                        coins.showCoin2();
                    } else if (coins.isCoin3Won()) {
                        coins.showCoin3();
                    }
                    break;
                }

                if (round4.getRequestNext() && !round5.getRequestNext()) {
                    round5.showOptionWrongB();
                    System.out.println("passou round 5 incorreto");
                    if (countCoins >= 3) {
                        round5.deleteScreen();
                        coins.deleteAllCoins();
                        montraFinalTitleScreen.showScreen();
                        System.out.println("You have " + countCoins + " coins");
                        System.out.println("Aparecimento da montra final");
                    } else {
                        round5.deleteScreen();
                        coins.deleteAllCoins();
                        Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                        gameOver.showScreen();
                        System.out.println("You have " + countCoins + " coins");
                        System.out.println("Não sabe o preço certo!");
                        break;
                    }

                    if (productScreen.getRequestNext() && !guessScreen.getRequestNext()) {
                        gameOver.showScreen();
                        Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    }

                    break;
                }

            case KeyboardEvent.KEY_C:
                if (rulesScreen.getRequestNext() && !round1.getRequestNext()) {
                    round1.showOptionCorrectC();
                    countCoins++;
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    System.out.println("passou round 1 correto");
                    round1.deleteScreen();
                    round2.showScreen();
                    coins.showCoin1();
                    break;
                }

                if (round1.getRequestNext() && !round2.getRequestNext()) {
                    round2.showOptionWrongC();
                    System.out.println("passou round 2 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round2.deleteScreen();
                    round3.showScreen();
                    if (coins.isCoin1Won()) {
                        coins.showCoin1();
                    }
                    break;
                }

                if (round2.getRequestNext() && !round3.getRequestNext()) {
                    round3.showOptionWrongC();
                    System.out.println("passou round 3 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round3.deleteScreen();
                    round4.showScreen();
                    if (coins.isCoin1Won() && !coins.isCoin2Won()) {
                        coins.showCoin1();
                    } else if (coins.isCoin2Won() && !coins.isCoin3Won()) {
                        coins.showCoin2();
                    }
                    break;
                }

                if (round3.getRequestNext() && !round4.getRequestNext()) {
                    round4.showOptionWrongC();
                    System.out.println("passou round 4 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round4.deleteScreen();
                    round5.showScreen();
                    if (coins.isCoin1Won() && !coins.isCoin2Won()) {
                        coins.showCoin1();
                    }
                    break;
                }

                if (round4.getRequestNext() && !round5.getRequestNext()) {
                    round5.showOptionCorrectC();
                    countCoins++;
                    System.out.println("passou round 5 correto");
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    if (countCoins >= 3) {
                        round5.deleteScreen();
                        coins.deleteAllCoins();
                        montraFinalTitleScreen.showScreen();
                        System.out.println("You have " + countCoins + " coins");
                        System.out.println("Aparecimento da montra final");
                    } else {
                        round5.deleteScreen();
                        coins.deleteAllCoins();
                        Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                        gameOver.showScreen();
                        System.out.println("You have " + countCoins + " coins");
                        System.out.println("Não sabe o preço certo!");
                        break;
                    }
                    break;
                }

                if (productScreen.getRequestNext() && !guessScreen.getRequestNext()) {
                    winScreen.showScreen();
                    Sound.playSound("/Sound/espetaculo.wav", 3000);
                }

                break;

            case KeyboardEvent.KEY_D:
                if (rulesScreen.getRequestNext() && !round1.getRequestNext()) {
                    round1.showOptionWrongD();
                    System.out.println("passou round 1 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round1.deleteScreen();
                    round2.showScreen();
                    break;
                }

                if (round1.getRequestNext() && !round2.getRequestNext()) {
                    round2.showOptionWrongD();
                    System.out.println("passou round 2 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round2.deleteScreen();
                    round3.showScreen();
                    break;
                }
                if (round2.getRequestNext() && !round3.getRequestNext()) {
                    round3.showOptionWrongD();
                    System.out.println("passou round 3 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round3.deleteScreen();
                    round4.showScreen();
                    break;
                }

                if (round3.getRequestNext() && !round4.getRequestNext()) {
                    round4.showOptionCorrectD();
                    countCoins++;
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    System.out.println("passou round 4 correto");
                    round4.deleteScreen();
                    round5.showScreen();
                    if (!coins.isCoin1Won()) {
                        coins.showCoin1();
                    } else if (coins.isCoin1Won() && !coins.isCoin2Won()) {
                        coins.showCoin2();
                    } else if (coins.isCoin1Won() && coins.isCoin2Won() && !coins.isCoin3Won()) {
                        coins.showCoin3();
                    } else if (coins.isCoin1Won() && coins.isCoin2Won() && coins.isCoin3Won() && !coins.isCoin4Won()) {
                        coins.showCoin4();
                    }
                    break;
                }

                if (round4.getRequestNext() && !round5.getRequestNext()) {
                    round5.showOptionWrongD();
                    System.out.println("passou round 5 incorreto");
                    if (countCoins >= 3) {
                        round5.deleteScreen();
                        coins.deleteAllCoins();
                        montraFinalTitleScreen.showScreen();
                        System.out.println("You have " + countCoins + " coins");
                        System.out.println("Aparecimento da montra final");
                    } else {
                        round5.deleteScreen();
                        coins.deleteAllCoins();
                        Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                        gameOver.showScreen();
                        System.out.println("You have " + countCoins + " coins");
                        System.out.println("Não sabe o preço certo!");
                        break;
                    }

                    if(productScreen.getRequestNext() && !guessScreen.getRequestNext()) {
                        gameOver.showScreen();
                        Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    }

                    break;
                }
            case KeyboardEvent.KEY_ENTER:
                if(round5.getRequestNext() && !montraFinalTitleScreen.getRequestNext()) {
                    montraFinalTitleScreen.deleteScreen();
                    margemDeErroScreen.showScreen();
                    System.out.println("margem de erro");
                    break;
                }

                else if (montraFinalTitleScreen.getRequestNext() && !margemDeErroScreen.getHasChosenMargin()) {
                    margemDeErroScreen.chooseMargin();
                    System.out.println("escolheu margem erro");
                    break;
                }

                else if (margemDeErroScreen.getHasChosenMargin() && !margemDeErroScreen.getRequestNext()) {
                    margemDeErroScreen.deleteScreen();
                    productScreen.showScreen();
                    System.out.println("aparecem produtos");
                    break;
                }

                else if (margemDeErroScreen.getRequestNext() && !productScreen.getRequestNext()) {
                    productScreen.deleteScreen();
                    guessScreen.showScreen();
                    break;
                }

                break;

            case KeyboardEvent.KEY_RIGHT:
                if (productScreen.isProduct1Showing()){
                    productScreen.deleteProduct1();
                    productScreen.showProduct2();
                    System.out.println("Product 2 appears.");
                    break;
                }

                if (productScreen.isProduct2Showing()){
                    productScreen.deleteProduct2();
                    productScreen.showProduct3();
                    System.out.println("Product 3 appears.");
                    break;
                }

                if (productScreen.isProduct3Showing()){
                    productScreen.deleteProduct3();
                    productScreen.showProduct4();
                    System.out.println("Product 4 appears.");
                    break;
                }

                if (productScreen.isProduct4Showing()){
                    productScreen.deleteProduct4();
                    productScreen.showProduct5();
                    System.out.println("Product 5 appears.");
                    break;
                }

                if (productScreen.isProduct5Showing()){
                    productScreen.deleteProduct5();
                    productScreen.showProduct6();
                    System.out.println("Product 6 appears.");
                    break;
                }
                if (productScreen.isProduct6Showing()){
                    productScreen.deleteProduct5();
                    productScreen.showProduct6();
                    System.out.println("Nothing happens.");
                    break;
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (productScreen.isProduct6Showing()){
                    productScreen.deleteProduct6();
                    productScreen.showProduct5();
                    break;
                }

                if (productScreen.isProduct5Showing()){
                    productScreen.deleteProduct5();
                    productScreen.showProduct4();
                    break;
                }

                if (productScreen.isProduct4Showing()){
                    productScreen.deleteProduct4();
                    productScreen.showProduct3();
                    break;
                }

                if (productScreen.isProduct3Showing()){
                    productScreen.deleteProduct3();
                    productScreen.showProduct2();
                    break;
                }

                if (productScreen.isProduct2Showing()){
                    productScreen.deleteProduct2();
                    productScreen.showProduct1();
                    break;
                }
            break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void goToFinalRound() {
        for (int i = 0; i < hasCoin.length; i++) {
            if (hasCoin[i] == true) {
                countCoins++;
            }
        }
    }

}