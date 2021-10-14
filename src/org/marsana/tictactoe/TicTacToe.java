/*@author Carmelo Marsana*/

/*
*       TO-DO LIST
* [Aggiungere il multiplayer]
*/

package org.marsana.tictactoe;

import java.net.MalformedURLException;

public class TicTacToe {
    public static void main(String[] args) {
        Mechanics mech = new Mechanics();
        try{
            mech.createWindow();
        }catch(MalformedURLException ex) {}
        
        mech.moveListener();
    }
}
