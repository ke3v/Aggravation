
package aggravation;

import java.awt.Color;
import java.awt.Font;

public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[4];
    private int points;
    private Color color;
    private static int count;
    private boolean clockWise;
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
        count = (int)(Math.random()*4);
        currentTurn = players[count];
       
    }
    Player(Color _color) {
        points = 0;
        color = _color;
        int num = ((int)(Math.random()*2));       
        if(num == 1)
            clockWise = true;
        else if(num == 0)
            clockWise = false;
        

        
        
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
    public boolean getDirection() {
        return (clockWise);
    }
    public static void switchTurn() {
        count++;
        
        if(count > 3)
            count = 0;
        
        currentTurn = players[count];
    }
    public static Color getBGColor() {
        if(currentTurn == players[0])
            return(new Color(0,0,0));
        if(currentTurn == players[1])
            return(new Color(0,0,0));
        if(currentTurn == players[2])
            return(new Color(0,0,0));
        if(currentTurn == players[3])
            return(new Color(0,0,0));
        return (new Color(0,0,0));
    }
    public static boolean checkStart(Player thePlayer, int row, int col) {
        if(currentTurn == players[0]) {
            if(Board.getBoard()[row][col]!=null && (Board.getBoard()[row][col] == Board.getBoard()[0][8] || 
                Board.getBoard()[row][col] == Board.getBoard()[1][8] || Board.getBoard()[row][col] == Board.getBoard()[0][7]) ||
                Board.getBoard()[row][col] == Board.getBoard()[2][6] || Board.getBoard()[row][col] == Board.getBoard()[3][5]
                || Board.getBoard()[row][col] == Board.getBoard()[4][4]) {
               return(true); 
            }
        }
        else if(currentTurn == players[1]) {
            if(Board.getBoard()[row][col]!=null && (Board.getBoard()[row][col] == Board.getBoard()[8][8] || 
                Board.getBoard()[row][col] == Board.getBoard()[8][7] || Board.getBoard()[row][col] == Board.getBoard()[7][8]) ||
                Board.getBoard()[row][col] == Board.getBoard()[6][6] || Board.getBoard()[row][col] == Board.getBoard()[5][5]
                || Board.getBoard()[row][col] == Board.getBoard()[4][4]) {
               return(true); 
            }
        }
        else if(currentTurn == players[2]) {
            if(Board.getBoard()[row][col]!=null && (Board.getBoard()[row][col] == Board.getBoard()[8][0] || 
                Board.getBoard()[row][col] == Board.getBoard()[8][1] || Board.getBoard()[row][col] == Board.getBoard()[7][0])
                || Board.getBoard()[row][col] == Board.getBoard()[6][2] || Board.getBoard()[row][col] == Board.getBoard()[5][3]
                || Board.getBoard()[row][col] == Board.getBoard()[4][4]) {
               return(true); 
            }
        }
        else if(currentTurn == players[3]) {
            if(Board.getBoard()[row][col]!=null && (Board.getBoard()[row][col] == Board.getBoard()[0][0] || 
                Board.getBoard()[row][col] == Board.getBoard()[0][1] || Board.getBoard()[row][col] == Board.getBoard()[1][0])
                || Board.getBoard()[row][col] == Board.getBoard()[2][2] || Board.getBoard()[row][col] == Board.getBoard()[3][3]
                || Board.getBoard()[row][col] == Board.getBoard()[4][4])  {
               return(true); 
            }
        }
        
        return(false);
    }
    public static boolean checkWinSpots(int zrow, int zcol) {
            //RED WIN      
                if(Board.getBoard()[zrow][zcol] != null){               
                    if(Board.getBoard()[2][2] == Board.getBoard()[zrow][zcol] || Board.getBoard()[3][3] == Board.getBoard()[zrow][zcol] || Board.getBoard()[4][4] == Board.getBoard()[zrow][zcol]){                
                        return true;
                    }
                }
                //BLUE WIN
                if(Board.getBoard()[zrow][zcol] != null){
                    if(Board.getBoard()[6][6] == Board.getBoard()[zrow][zcol] || Board.getBoard()[5][5] == Board.getBoard()[zrow][zcol]  || Board.getBoard()[4][4] == Board.getBoard()[zrow][zcol]){
                        return true;
                    }
                }
                //GREEN WIN
                if(Board.getBoard()[zrow][zcol] != null){
                    if(Board.getBoard()[2][6] == Board.getBoard()[zrow][zcol] || Board.getBoard()[3][5] == Board.getBoard()[zrow][zcol] || Board.getBoard()[4][4] == Board.getBoard()[zrow][zcol]){
                        return true;  
                    }
                }
                //YELLOW WIN

                if(Board.getBoard()[zrow][zcol] != null){
                    if(Board.getBoard()[6][2] == Board.getBoard()[zrow][zcol] || Board.getBoard()[5][3] == Board.getBoard()[zrow][zcol] || Board.getBoard()[4][4] == Board.getBoard()[zrow][zcol]){
                        return true;  
                    }

                }
                return false;

        }   
    
    public static boolean checkAllStart(Player thePlayer) {
        if(currentTurn == players[0]) {
            if((Board.getBoard()[0][8] != null && 
                Board.getBoard()[1][8] != null &&  Board.getBoard()[0][7] != null)){
               return(true); 
            }
        }
        else if(currentTurn == players[1]) {
            if(Board.getBoard()[8][8] != null && 
                Board.getBoard()[8][7] != null && Board.getBoard()[7][8] != null) {
               return(true); 
            }
        }
        else if(currentTurn == players[2]) {
            if(Board.getBoard()[8][0] != null && 
                Board.getBoard()[8][1] != null && Board.getBoard()[7][0] != null) {
               return(true); 
            }
        }
        else if(currentTurn == players[3]) {
            if(Board.getBoard()[0][0] != null && 
                Board.getBoard()[0][1] != null && Board.getBoard()[1][0] != null) {
               return(true); 
            }
        }
        
        return(false);
    }
    
    public static void placeStart(int diceVal) {
        if(diceVal == 1 || diceVal == 6)
        {
            if(currentTurn == players[0])
            {
                Board.getBoard()[1][7] = new Piece(players[0].color);
            }
            else if(currentTurn == players[1])
            {
               Board.getBoard()[7][7] = new Piece(players[1].color);
            }
            else if(currentTurn == players[2])
            {
                Board.getBoard()[7][1] = new Piece(players[2].color);
            }
            else if(currentTurn == players[3])
            {
                Board.getBoard()[1][1] = new Piece(players[3].color);
            }
        }
    }
    public static Piece getFirstSpot() {
        if(currentTurn == players[0])
        {
            return(Board.getBoard()[1][7]);
        }
        else if(currentTurn == players[1])
        {
           return(Board.getBoard()[7][7]);
        }
        else if(currentTurn == players[2])
        {
            return(Board.getBoard()[7][1]);
        }
        else if(currentTurn == players[3])
        {
            return(Board.getBoard()[1][1]);
        }
        
        return(Board.getBoard()[0][0]);
    }
    public static void placeInOpenStart(Color _color) {
        if(players[0].color == _color)
        {
            if(Board.getBoard()[0][8] == null)
                Board.getBoard()[0][8] = new Piece(players[0].color,0);
            else if(Board.getBoard()[1][8] == null)
                Board.getBoard()[1][8] = new Piece(players[0].color,0);
            else if(Board.getBoard()[0][7] == null)
                Board.getBoard()[0][7] = new Piece(players[0].color,0);
        }
        else if(players[1].color == _color)
        {
           if(Board.getBoard()[8][8] == null)
                Board.getBoard()[8][8] = new Piece(players[1].color,0);
            else if(Board.getBoard()[8][7] == null)
                Board.getBoard()[8][7] = new Piece(players[1].color,0);
            else if(Board.getBoard()[7][8] == null)
                Board.getBoard()[7][8] = new Piece(players[1].color,0);
        }
        else if(players[2].color == _color)
        {
            if(Board.getBoard()[8][0] == null)
                Board.getBoard()[8][0] = new Piece(players[2].color,0);
            else if(Board.getBoard()[8][1] == null)
                Board.getBoard()[8][1] = new Piece(players[2].color,0);
            else if(Board.getBoard()[7][0] == null)
                Board.getBoard()[7][0] = new Piece(players[2].color,0);
        }
        else if(players[3].color == _color)
        {
            if(Board.getBoard()[0][0] == null)
                Board.getBoard()[0][0] = new Piece(players[3].color,0);
            else if(Board.getBoard()[0][1] == null)
                Board.getBoard()[0][1] = new Piece(players[3].color,0);
            else if(Board.getBoard()[1][0] == null)
                Board.getBoard()[1][0] = new Piece(players[3].color,0);
        }
    }
}   
//    public static Player getOtherPlayer() {
//        if (currentTurn == players[0])
//            return (players[1]);
//        return(players[0]);
//    }   
//    public static void switchTurn() {
//        if (currentTurn == players[0])
//            currentTurn = players[1];
//        else
//            currentTurn = players[0];
//    }
