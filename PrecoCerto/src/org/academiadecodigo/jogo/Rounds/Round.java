package org.academiadecodigo.jogo.Rounds;

import org.academiadecodigo.jogo.Options.Options;

public abstract class Round{
    //Properties
    private Options correctOption;
    private int points;

    //Constructor
    public Round(){
        this.points = 0;
    }

    //Methods
    public boolean isOptionCorrect(Options chosenOption){
        if (correctOption == chosenOption){
            points += 10;
            return true;
        }
        return false;
    }
}
