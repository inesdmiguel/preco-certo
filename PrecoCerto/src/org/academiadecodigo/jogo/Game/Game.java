package org.academiadecodigo.jogo.Game;
import org.academiadecodigo.jogo.Coins;
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
    private Coins coins;
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

    //Booleans
    private boolean rightClicked;
    private boolean spaceClicked;
    private boolean passedRound1;
    private boolean passedRound2;
    private boolean passedRound3;
    private boolean passedRound4;
    private boolean passedRound5;
    private boolean enterClicked;
    private boolean passedMargemErro;
    private boolean choosedMargemErro;
    private boolean productChoosed;
    private boolean showingMargemErro;
    private boolean gameEnd;


    //Constructor
    public Game() {
        keyboard = new Keyboard(this);
        createKeyboardEvents();
        startScreen = new StartScreen();
        rulesScreen = new RulesScreen();
        coins = new Coins();
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
        hasCoin = new boolean[5];
    }

    //Methods
    public void start() {
        startScreen.showScreen();
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
                if (!spaceClicked) {
                    startScreen.deleteScreen();
                    rulesScreen.showScreen();
                    spaceClicked = true;
                } else if (!rightClicked) {
                    rulesScreen.deleteScreen();
                    round1.showScreen();
                    rightClicked = true;
                }
                break;

            case KeyboardEvent.KEY_ENTER:
                if(spaceClicked && rightClicked && passedRound5 && !enterClicked){
                    enterClicked = true;
                    margemDeErroScreen.showScreen();
                    System.out.println("margem de erro");
                    break;
                }
                else if (spaceClicked && rightClicked && passedRound5 && !passedMargemErro){
                    passedMargemErro = true;
                    margemDeErroScreen.chooseMargin();
                    System.out.println("escolheu margem erro");
                }
                else if (spaceClicked && rightClicked && passedRound5 && !showingMargemErro && !choosedMargemErro){
                    choosedMargemErro = true;
                    showingMargemErro = true;
                    margemDeErroScreen.clickYellowButton();
                    System.out.println("aparece margem");
                }
                else if (spaceClicked && rightClicked && passedRound5 && choosedMargemErro && showingMargemErro && !productChoosed){
                    productChoosed = true;
                    productScreen.showScreen();
                    System.out.println("aparecem produtos");
                }
                else if (spaceClicked && rightClicked && productChoosed){
                    guessScreen.showScreen();
                }
                break;
            case KeyboardEvent.KEY_A:
                if (round2.isOptionCorrect(Options.A) && spaceClicked && rightClicked && passedRound1 && !passedRound2) {
                    passedRound2 = true;
                    round2.showOptionCorrectA();
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    System.out.println("passou round 2 correto");
                    countCoins++;
                    round2.deleteScreen();
                    round3.showScreen();
                    coins.showCoin2();
                    break;
                }
                if (guessScreen.isOptionIncorrect(Options.A) && spaceClicked && rightClicked && passedRound5 && !gameEnd){
                    gameEnd = true;
                    gameOver.showScreen();
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                }
                if (round1.isOptionIncorrect(Options.A) && spaceClicked && rightClicked && !passedRound1) {
                    passedRound1 = true;
                    System.out.println("passou round 1 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round1.deleteScreen();
                    round2.showScreen();
                    //round1.showOptionWrongA();
                    break;
                }
                if (round3.isOptionIncorrect(Options.A) && spaceClicked && rightClicked && passedRound1 && passedRound2 && !passedRound3) {
                    passedRound3 = true;
                    System.out.println("passou round 3 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round3.deleteScreen();
                    round4.showScreen();
                    //round3.showOptionWrongA();
                    break;
                }
                if (round4.isOptionIncorrect(Options.A) && spaceClicked && rightClicked && passedRound1 && passedRound2 && passedRound3 && !passedRound4) {
                    passedRound4 = true;
                    System.out.println("passou round 4 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round4.deleteScreen();
                    round5.showScreen();
                    // round4.showOptionWrongA();
                    break;
                }
                if (round5.isOptionIncorrect(Options.A) && spaceClicked && rightClicked && passedRound1 && passedRound2 && passedRound3 && passedRound4 && !passedRound5) {
                    passedRound5 = true;
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
                    //round5.showOptionWrongA();
                    break;
                }
                break;

            case KeyboardEvent.KEY_B:
                //roundCorrectOptions();
                if (guessScreen.isOptionIncorrect(Options.B) && spaceClicked && rightClicked && passedRound5 && !gameEnd){
                    gameEnd = true;
                    gameOver.showScreen();
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                }
                if (round1.isOptionIncorrect(Options.B) && spaceClicked && rightClicked && !passedRound1) {
                    passedRound1 = true;
                    System.out.println("passou round 1 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round1.deleteScreen();
                    round2.showScreen();
                    //round2.showScreen();
                    break;
                }
                if (round2.isOptionIncorrect(Options.B) && spaceClicked && rightClicked && passedRound1 && !passedRound2) {
                    passedRound2 = true;
                    System.out.println("passou round 2 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round2.deleteScreen();
                    round3.showScreen();
                    //round3.showScreen();
                    break;
                }
                if (round3.isOptionCorrect(Options.B) && spaceClicked && rightClicked && passedRound1 && passedRound2 && !passedRound3) {  //Done
                    passedRound3 = true;
                    countCoins++;
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    System.out.println("passou round 3 correto");
                    round3.deleteScreen();
                    round4.showScreen();
                    coins.showCoin3();
                    //round4.showScreen();
                    break;
                }
                if (round4.isOptionIncorrect(Options.B) && spaceClicked && rightClicked && passedRound1 && passedRound2 && passedRound3 && !passedRound4) {
                    passedRound4 = true;
                    System.out.println("passou round 4 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round4.deleteScreen();
                    round5.showScreen();
                    //round5.showScreen();
                    break;
                }
                if (round5.isOptionIncorrect(Options.B) && spaceClicked && rightClicked && passedRound1 && passedRound2 && passedRound3 && passedRound4 && !passedRound5) {
                    // round6.showScreen();
                    passedRound5 = true;
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
                    break;
                }
            case KeyboardEvent.KEY_C:
                if (round5.isOptionCorrect(Options.C) && spaceClicked && rightClicked && passedRound1 && passedRound2 && passedRound3 && passedRound4 && !passedRound5) {
                    //correct round 5
                    passedRound5 = true;
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
                if (guessScreen.isOptionCorrect(Options.C) && spaceClicked && rightClicked && passedRound5 && !gameEnd){
                    gameEnd = true;
                    winScreen.showScreen();
                    Sound.playSound("/Sound/espetaculo.wav", 3000);
                }
                if (round1.isOptionCorrect(Options.C) && spaceClicked && rightClicked && !passedRound1) {
                    //correct round 1
                    passedRound1 = true;
                    countCoins++;
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    System.out.println("passou round 1 correto");
                    round1.deleteScreen();
                    round2.showScreen();
                    coins.showCoin1();
                    break;
                }
                if (round2.isOptionIncorrect(Options.C) && spaceClicked && rightClicked && passedRound1 && !passedRound2) {
                    passedRound2 = true;
                    System.out.println("passou round 2 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round2.deleteScreen();
                    round3.showScreen();
                    //round2.showOptionWrongC();
                    break;
                }
                if (round3.isOptionIncorrect(Options.C) && spaceClicked && rightClicked && passedRound1 && passedRound2 && !passedRound3) {
                    passedRound3 = true;
                    System.out.println("passou round 3 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round3.deleteScreen();
                    round4.showScreen();
                    //round3.showOptionWrongC();
                    break;
                }
                if (round4.isOptionIncorrect(Options.C) && spaceClicked && rightClicked && passedRound1 && passedRound2 && passedRound3 && !passedRound4) {
                    passedRound4 = true;
                    System.out.println("passou round 4 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round4.deleteScreen();
                    round5.showScreen();
                    //round4.showOptionWrongC();
                    break;
                }
                break;

            case KeyboardEvent.KEY_D:
                if(guessScreen.isOptionIncorrect(Options.D) && spaceClicked && rightClicked && passedRound5 && !gameEnd){
                    gameEnd = true;
                    gameOver.showScreen();
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                }
                if (round1.isOptionIncorrect(Options.D) && spaceClicked && rightClicked && !passedRound1) {
                    passedRound1 = true;
                    System.out.println("passou round 1 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round1.deleteScreen();
                    round2.showScreen();
                    //round5.showScreen();
                    break;
                }
                if (round2.isOptionIncorrect(Options.D) && spaceClicked && rightClicked && passedRound1 && !passedRound2) {
                    passedRound2 = true;
                    System.out.println("passou round 2 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round2.deleteScreen();
                    round3.showScreen();
                    //round3.showScreen();
                    break;
                }
                if (round3.isOptionIncorrect(Options.D) && spaceClicked && rightClicked && passedRound1 && passedRound2 && !passedRound3) {  //Done
                    passedRound3 = true;
                    System.out.println("passou round 3 incorreto");
                    Sound.playSound("/Sound/guessed_wrong.wav", 1000);
                    round3.deleteScreen();
                    round4.showScreen();
                    //round4.showScreen();
                    break;
                }
                if (round4.isOptionCorrect(Options.D) && spaceClicked && rightClicked && passedRound1 && passedRound2 && passedRound3 && !passedRound4) {
                    passedRound4 = true;
                    countCoins++;
                    Sound.playSound("/Sound/guessed_right.wav", 2200);
                    System.out.println("passou round 4 correto");
                    round4.deleteScreen();
                    round5.showScreen();
                    coins.showCoin4();
                    break;
                }
                if (round5.isOptionIncorrect(Options.D) && spaceClicked && rightClicked && passedRound1 && passedRound2 && passedRound3 && passedRound4 && !passedRound5) {
                    passedRound5 = true;
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
                    break;
                }
            case KeyboardEvent.KEY_RIGHT:
                if (productScreen.isProduct1Showing()){
                    productScreen.setProduct1Showing(false);
                    productScreen.deleteProduct1();
                    productScreen.showProduct2();
                    System.out.println("aparece produto 2");
                    break;
                }
                if (productScreen.isProduct2Showing()){
                    productScreen.setProduct2Showing(false);
                    productScreen.deleteProduct2();
                    productScreen.showProduct3();
                    System.out.println("aparece produto 3");
                    break;
                }
                if (productScreen.isProduct3Showing()){
                    productScreen.setProduct3Showing(false);
                    productScreen.deleteProduct3();
                    productScreen.showProduct4();
                    System.out.println("aparece produto 4");
                    break;
                }
                if (productScreen.isProduct4Showing()){
                    productScreen.setProduct4Showing(false);
                    productScreen.deleteProduct4();
                    productScreen.showProduct5();
                    System.out.println("aparece produto 5");
                    break;
                }
                if (productScreen.isProduct5Showing()){
                    productScreen.setProduct5Showing(false);
                    productScreen.deleteProduct5();
                    productScreen.showProduct6();
                    System.out.println("aparece produto 6");
                    break;
                }
                if (productScreen.isProduct6Showing()){
                    productScreen.setProduct6Showing(false);
                    productScreen.deleteProduct5();
                    productScreen.showProduct6();
                    System.out.println("nao devia acontecer nada");
                    break;
                }
            case KeyboardEvent.KEY_LEFT:
                if (productScreen.isProduct6Showing()){
                    productScreen.setProduct6Showing(false);
                    productScreen.deleteProduct6();
                    productScreen.showProduct5();
                    break;
                }
                if (productScreen.isProduct5Showing()){
                    productScreen.setProduct5Showing(false);
                    productScreen.deleteProduct5();
                    productScreen.showProduct4();
                    break;
                }
                if (productScreen.isProduct4Showing()){
                    productScreen.setProduct4Showing(false);
                    productScreen.deleteProduct4();
                    productScreen.showProduct3();
                    break;
                }
                if (productScreen.isProduct3Showing()){
                    productScreen.setProduct3Showing(false);
                    productScreen.deleteProduct3();
                    productScreen.showProduct2();
                    break;
                }
                if (productScreen.isProduct2Showing()){
                    productScreen.setProduct2Showing(false);
                    productScreen.deleteProduct2();
                    productScreen.showProduct1();
                    break;
                }

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void passFinalRound() {
        for (int i = 0; i < hasCoin.length; i++) {
            if (hasCoin[i] == true) {
                countCoins++;
            }
        }
    }

}