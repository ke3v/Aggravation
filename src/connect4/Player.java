
package connect4;

import java.awt.Color;

public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[4];
    private int points;
    private Color color;
/*
How to Add Code to Repository
1: git add -A
2: git commit -m "new Code"
3: git push origin master


How to Get Code from Repository
1: git pull origin master

How to Get Clone from Repository
1: git clone LINK


*/    
    public static void Reset() {
        if (players[0] == null) {
            players[0] = new Player(Color.green);
            players[1] = new Player(Color.blue);
            players[2] = new Player(Color.yellow);
            players[3] = new Player(Color.red);            
        }
        currentTurn = players[0];
    }
    Player(Color _color) {
        points = 0;
        color = _color;
    }
    public Color getColor() {
        return (color);
    }
    
    public void addPoints(int value) {
        points += value;
    }
    public int getPoints() {
        return (points);
    }
    public static Player getPlayer1() {
        return (players[0]);
    }
    public static Player getPlayer2() {
        return (players[1]);
    }
    public static Player getPlayer3() {
        return (players[2]);
    }
    public static Player getPlayer4() {
        return (players[3]);
    }    
    public static Player getCurrentPlayer() {
        return(currentTurn);
    }   
    public static Player getOtherPlayer() {
        if (currentTurn == players[0])
            return (players[1]);
        return(players[0]);
    }   
    public static void switchTurn() {
        if (currentTurn == players[0])
            currentTurn = players[1];
        else
            currentTurn = players[0];
    }
}
