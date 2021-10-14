/*@author Carmelo Marsana*/
package org.marsana.tictactoe;

import java.awt.event.ActionEvent;

public class Mechanics extends Window{
    private String turn = "X";
    public String getTurn(){
        if(turn.equals("X"))
            return "X";
        else if(turn.equals("O"))
            return "O";
        else
            return "W";
    }
    private boolean spotIsValid(int i, int j){
        //if the spot is already selected return false
        if(!gridButton[i][j].getText().equals("-"))
            return false;
        else
            return true;
    }
    private void switchTurn(){
        if(turn.equals("X")){
            turn = "O";
            status.setText("Player 'O' turn");
        }else if(turn.equals("O")){
            turn = "X";
            status.setText("Player 'X' turn");
        }
    }
    private boolean hasDrew(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(gridButton[i][j].getText().equals("-"))
                    return false;
        return true;
    }
    private void makeUnclickable(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                gridButton[i][j].setEnabled(false);
        
    }
    private void onClick(int i, int j){
        if(spotIsValid(i,j)){
            gridButton[i][j].setText(turn);        
            if(hasWon()){
                status.setText("Player '" + turn + "' won!");
                makeUnclickable();
            }
            else if(hasDrew()){
                status.setText("Draw!");
                makeUnclickable();
            }
            else
                switchTurn();
        }
    }
    public void moveListener(){
        gridButton[0][0].addActionListener((ActionEvent e) -> {
            onClick(0, 0);
        });
        gridButton[0][1].addActionListener((ActionEvent e) -> {
            onClick(0, 1);
        });
        gridButton[0][2].addActionListener((ActionEvent e) -> {
            onClick(0, 2);
        });
        gridButton[1][0].addActionListener((ActionEvent e) -> {
            onClick(1, 0);
        });
        gridButton[1][1].addActionListener((ActionEvent e) -> {
            onClick(1, 1);
        });
        gridButton[1][2].addActionListener((ActionEvent e) -> {
            onClick(1, 2);
        });
        gridButton[2][0].addActionListener((ActionEvent e) -> {
            onClick(2, 0);
        });
        gridButton[2][1].addActionListener((ActionEvent e) -> {
            onClick(2, 1);
        });
        gridButton[2][2].addActionListener((ActionEvent e) -> {
            onClick(2, 2);
        });
    }
    //check if someone has won by checking all the possible combinations
    private boolean hasWon(){
        //check for diagonals combination
        
        //check for x
        if(gridButton[0][0].getText().equals("X") && gridButton[1][1].getText().equals("X") 
                && gridButton[2][2].getText().equals("X")){
            return true;
        }
        else if(gridButton[2][0].getText().equals("X") && gridButton[1][1].getText().equals("X") 
                && gridButton[0][2].getText().equals("X")){
            return true;
        }
        //check for o
        if(gridButton[0][0].getText().equals("O") && gridButton[1][1].getText().equals("O") 
                && gridButton[2][2].getText().equals("O")){
            return true;
        }
        else if(gridButton[2][0].getText().equals("O") && gridButton[1][1].getText().equals("O")
                && gridButton[0][2].getText().equals("O")){
            return true;
        }
        
        //check for horizontal combination
        
        //check for x
        if(gridButton[0][0].getText().equals("X") && gridButton[0][1].getText().equals("X")
                && gridButton[0][2].getText().equals("X")){
            return true;
        }
        else if(gridButton[1][0].getText().equals("X") && gridButton[1][1].getText().equals("X")
                && gridButton[1][2].getText().equals("X")){
            return true;
        }
        else if(gridButton[2][0].getText().equals("X") && gridButton[2][1].getText().equals("X")
                && gridButton[2][2].getText().equals("X")){
            return true;
        }
        //check for o
        if(gridButton[0][0].getText().equals("O") && gridButton[0][1].getText().equals("O")
                && gridButton[0][2].getText().equals("O")){
            return true;
        }
        else if(gridButton[1][0].getText().equals("O") && gridButton[1][1].getText().equals("O")
                && gridButton[1][2].getText().equals("O")){
            return true;
        }
        else if(gridButton[2][0].getText().equals("O") && gridButton[2][1].getText().equals("O")
                && gridButton[2][2].getText().equals("O")){
            return true;
        }
       
        //check for vertical comnbination
       
        //check for x
        if(gridButton[0][0].getText().equals("X") && gridButton[1][0].getText().equals("X")
                && gridButton[2][0].getText().equals("X")){
            return true;
        }
        else if(gridButton[0][1].getText().equals("X") && gridButton[1][1].getText().equals("X")
                && gridButton[2][1].getText().equals("X")){
            return true;
        }
        else if(gridButton[0][2].getText().equals("X") && gridButton[1][2].getText().equals("X")
                && gridButton[2][2].getText().equals("X")){
            return true;
        }
        //check for o
        if(gridButton[0][0].getText().equals("O") && gridButton[1][0].getText().equals("O")
                && gridButton[2][0].getText().equals("O")){
            return true;
        }
        else if(gridButton[0][1].getText().equals("O") && gridButton[1][1].getText().equals("O")
                && gridButton[2][1].getText().equals("O")){
            return true;
        }
        else if(gridButton[0][2].getText().equals("O") && gridButton[1][2].getText().equals("O")
                && gridButton[2][2].getText().equals("O")){
            return true;
        }
        //finally if no one has won
        else
            return false;
    }
}
