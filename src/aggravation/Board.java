package aggravation;
import java.awt.*;

public class Board {
    private final static int NUM_CONNECT_WIN = 4;    
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
    private final static int NUM_ROWS = 9;
    private final static int NUM_COLUMNS = 9;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    private static Player winner = null;
    private static int diceVal = 0;
    private static boolean diceRolled = false;
    private static boolean chosePiece = false;
    
    public static void Reset() {
 
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                board[zi][zx] = null;//new Piece(Color.CYAN, true);
            }
        }
        winner = null;
        diceVal = (int)(Math.random()*6+1);
        diceRolled = false;
        chosePiece = false;
        
        board[0][0] = new Piece(Color.RED);
        board[0][1] = new Piece(Color.RED);
        board[1][0] = new Piece(Color.RED);
        
        board[8][0] = new Piece(Color.YELLOW);
        board[8][1] = new Piece(Color.YELLOW);
        board[7][0] = new Piece(Color.YELLOW);
        
        board[8][8] = new Piece(Color.BLUE);
        board[8][7] = new Piece(Color.BLUE);
        board[7][8] = new Piece(Color.BLUE);
        
        board[0][8] = new Piece(Color.GREEN);
        board[1][8] = new Piece(Color.GREEN);
        board[0][7] = new Piece(Color.GREEN);

    }
    
    
    

    static final int numRows = 9;
    static final int numColumns = 9;
    

    static final int PATH = 0;
    static final int WALL = 1;

    

       
    public static Piece[][] getBoard() {
        return (board);
    }
    
    public static void CheckWin() {
        
        if (winner != null)
            return;
 
        
    }
    

    public static Player checkWinWholeBoard()
    {
        int numConsecutive = 0;
        Color colorMatch = null;

        int totalPoints = 0;

        return (null);
    }        
           
    public static void AddPiecePixel(int xpixel,int ypixel) {
        
        if (winner != null)
            return;
        
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;

        int zcol = 0;
        int zrow = 0;
 
        
        
        if (xpixel-Window.getX(0) > 0 &&
            ypixel-Window.getY(0) > 0 &&
            xpixel-Window.getX(0) < xdelta*NUM_COLUMNS &&
            ypixel-Window.getY(0) < ydelta*NUM_ROWS)
        {
            zcol = (xpixel-Window.getX(0))/xdelta;
            zrow = (ypixel-Window.getY(0))/ydelta;
            if(zcol == 4 && zrow == 4 && !diceRolled) {
                diceVal = (int)(Math.random()*6+1);
                if(diceVal == 6) {
                diceRolled = true;
                chosePiece = false;
                }
                else if(diceVal == 1) {
                    diceRolled = true;
                    chosePiece = false;
                    
                }
                else {
                    if(Player.checkAllStart(Player.getCurrentPlayer())) {
                        diceRolled = false;
                        chosePiece = false;
                        Player.switchTurn();
                    }
                    else {
                        diceRolled = true;
                        chosePiece = false;
                    }
                }
            }
            // Starting Branch
            if(board[zrow][zcol] != null && board[zrow][zcol].getColor() == Player.getCurrentPlayer().getColor() && 
                diceRolled && !chosePiece && Player.checkStart(Player.getCurrentPlayer(), zrow, zcol)) {
                
                
                if(Player.getFirstSpot() == null){
                    Player.placeStart(diceVal);
                    board[zrow][zcol] = null;
                    diceRolled = false;

                    if(diceVal == 6 ) 
                    {

                    }
                    else if(diceVal != 6)
                    {
                        chosePiece = false;
                        Player.switchTurn();
                    }
                }
                else{
                    Player.switchTurn();
                    diceRolled = false;
                }
            
            }
            
            // Not Starting Branch
            if(board[zrow][zcol] != null && board[zrow][zcol].getColor() == Player.getCurrentPlayer().getColor() && 
                !chosePiece) {
                
                if(diceRolled) {
                    int theDiceVal = diceVal;
                    if(Player.getCurrentPlayer().getDirection()) 
                    {
                        Move(zrow,zcol);
                    }
                    else 
                    {
                        
                        board[zrow][zcol] = null;
                    }
                    diceRolled = false;
                    chosePiece = false;
                    Player.switchTurn();
                }
                else if(!diceRolled) {
                    board[zrow][zcol] = null;
                    diceRolled = false;
                    chosePiece = false;
                    Player.switchTurn();
                }
                
            }
        }        
        
    }
    public static void Move(int row, int col) {
        int theDiceVal = diceVal;
        int xdir = 0;
        int ydir = 0;
        int zrow = row;
        int zcol = col;
        boolean notMoved = true;
        System.out.println("spot " + row + "," + col);
        
        while (theDiceVal > 0)
        {
            notMoved = true;
            // RED CORNER
            if (row == 2 && col == 0)
            {
                System.out.println("kms");
                row = 1;
                col = 1;
            }
            else if (row == 1 && col == 1){
                
                row = 0;
                col = 2;
            }
            else if (row == 0 && col == 2){
                
                row = 0;
                col = 3;
            }
            else if (row == 0 && col == 3){
                
                row = 0;
                col = 4;
            }
            else if (row == 0 && col == 4){
                
                row = 0;
                col = 5;
            }
            else if (row == 0 && col == 5){
                
                row = 0;
                col = 6;
            }
            
            // GREEN CORNER
            else if (row == 0 && col == 6)
            {
                
                row = 1;
                col = 7;
            }
            else if (row == 1 && col == 7){
                
                row = 2;
                col = 8;
            }
            else if (row == 2 && col == 8){
                
                row = 3;
                col = 8;
            }
            else if (row == 3 && col == 8){
                
                row = 4;
                col = 8;
            }
            else if (row == 4 && col == 8){
                
                row = 5;
                col = 8;
            }
            
            // BLUE CORNER
            else if (row == 5 && col == 8)
            {
                
                row = 6;
                col = 8;
            }
            else if (row == 6 && col == 8)
            {
                
                row = 7;
                col = 7;
            }
            else if (row == 7 && col == 7){
                
                row = 8;
                col = 6;
            }
            else if (row == 8 && col == 6){
                
                row = 8;
                col = 5;
            }
            else if (row == 8 && col == 5){
                
                row = 8;
                col = 4;
            }
            else if (row == 8 && col == 4){
                
                row = 8;
                col = 3;
            }
            else if (row == 8 && col == 3){
                
                row = 8;
                col = 2;
            }
            
            // YELLOW CORNER
            else if (row == 8 && col == 2)
            {
                
                row = 7;
                col = 1;
            }
            else if (row == 7 && col == 1){
                
                row = 6;
                col = 0;
            }
            else if (row == 6 && col == 0){
                
                row = 5;
                col = 0;
            }
            else if (row == 5 && col == 0){
                
                row = 4;
                col = 0;
            }
            else if (row == 4 && col == 0){
                
                row = 3;
                col = 0;
            }
            else if (row == 3 && col == 0){
                
                row = 2;
                col = 0;
            }
            //board[row][col] = new Piece(Player.getCurrentPlayer().getColor());
            theDiceVal--;
        }
        System.out.println(row + " , " + col);
        board[row][col] = new Piece(Player.getCurrentPlayer().getColor());
        board[zrow][zcol] = null;
        
        
        
        
        
//        while(theDiceVal > 0) {
//            if(board[zrow][zcol] != null && (board[zrow][zcol] == board[2][0] || board[zrow][zcol] == board[1][1] || board[zrow][zcol] == board[0][2])) {
//                if(Player.getCurrentPlayer().getDirection()) {
//                    
//                }
//            }
//        }
    }

    public static void Draw(Graphics2D g) {
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
 //draw grid
 // Middle Popper
        g.setColor(Color.WHITE); 
        g.fillRect(Window.getX(4*xdelta),
        Window.getY(4*ydelta),xdelta,ydelta);
//Top Row        
        g.fillRect(Window.getX(2*xdelta),
        Window.getY(0*ydelta),xdelta * 5,ydelta);          
//Bottom Row
        g.fillRect(Window.getX(2*xdelta),
        Window.getY(8*ydelta),xdelta * 5,ydelta);                
//Left Row        
        g.fillRect(Window.getX(0*xdelta),
        Window.getY(2*ydelta),xdelta,ydelta * 5);         
//Right Row
        g.fillRect(Window.getX(8*xdelta),
        Window.getY(2*ydelta),xdelta,ydelta * 5);        
//TopLeft Corner        
        g.fillRect(Window.getX(1*xdelta),
        Window.getY(1*ydelta),xdelta,ydelta);
//TopRight Corner
        g.fillRect(Window.getX(7*xdelta),
        Window.getY(1*ydelta),xdelta,ydelta);
//BottomRight Corner        
        g.fillRect(Window.getX(7*xdelta),
        Window.getY(7*ydelta),xdelta,ydelta);
//BottemLeft Corner
        g.fillRect(Window.getX(1*xdelta),
        Window.getY(7*ydelta),xdelta,ydelta);
//Winning Area
        g.fillRect(Window.getX(2*xdelta),
        Window.getY(6*ydelta),xdelta,ydelta);        
        g.fillRect(Window.getX(3*xdelta),
        Window.getY(5*ydelta),xdelta,ydelta);
        
        
        g.fillRect(Window.getX(2*xdelta),
        Window.getY(2*ydelta),xdelta,ydelta);        
        g.fillRect(Window.getX(3*xdelta),
        Window.getY(3*ydelta),xdelta,ydelta); 
        
        g.fillRect(Window.getX(5*xdelta),
        Window.getY(3*ydelta),xdelta,ydelta);        
        g.fillRect(Window.getX(6*xdelta),
        Window.getY(2*ydelta),xdelta,ydelta);   
        
        g.fillRect(Window.getX(2*xdelta),
        Window.getY(6*ydelta),xdelta,ydelta);        
        g.fillRect(Window.getX(3*xdelta),
        Window.getY(5*ydelta),xdelta,ydelta);         

        g.fillRect(Window.getX(5*xdelta),
        Window.getY(5*ydelta),xdelta,ydelta);        
        g.fillRect(Window.getX(6*xdelta),
        Window.getY(6*ydelta),xdelta,ydelta); 

        
        g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.PLAIN,30));
        if(!diceRolled)
            g.drawString("Roll dice guy", 200,100); 
        if (winner == Player.getPlayer1()) {
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Player 1 has Won", 200,70);              
        }
        else if (winner == Player.getPlayer2()) {
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Player 2 has Won", 200,70);              
        }
        else {
            g.setFont(new Font("Arial",Font.PLAIN,30));
            if (Player.getCurrentPlayer() == Player.getPlayer1())
                g.drawString("Green's turn", 200,70);
            if(Player.getCurrentPlayer() == Player.getPlayer2())
                g.drawString("Blue's turn", 200,70); 
            if(Player.getCurrentPlayer() == Player.getPlayer3())
                g.drawString("Yellow's turn", 200,70); 
            if(Player.getCurrentPlayer() == Player.getPlayer4())
                g.drawString("Red's turn", 200,70); 
            for (int zi = 0;zi<NUM_ROWS;zi++)
            {
                for (int zx = 0;zx<NUM_COLUMNS;zx++)
                {
                    if (board[zi][zx] != null)
                    {
                        g.setColor(Player.getBGColor());
                        if(board[zi][zx].getColor() == Player.getCurrentPlayer().getColor() && diceRolled && (diceVal == 1 || diceVal == 6) && Player.getFirstSpot() == null) {
                            g.fillRect(Window.getX(zx*xdelta),
                            Window.getY(zi*ydelta),xdelta,ydelta);
                        }
                        else if(board[zi][zx].getColor() == Player.getCurrentPlayer().getColor() && diceRolled) {
                            if(!Player.checkStart(Player.getCurrentPlayer(), zi, zx))
                            g.fillRect(Window.getX(zx*xdelta),
                            Window.getY(zi*ydelta),xdelta,ydelta);
                        }
                    }
                }
            } 
        }
        
        g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.PLAIN,30));
        g.drawString("" + diceVal,Window.getX(4*xdelta)+30,
        Window.getY(4*ydelta)+40);
        
                
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                if (board[zi][zx] != null)
                {
                    board[zi][zx].draw(g,zi,zx,xdelta,ydelta);
                }
            }
        } 
        
    }
}
