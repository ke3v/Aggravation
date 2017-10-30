
package connect4;
import java.awt.*;

public class Board {
    private final static int NUM_CONNECT_WIN = 4;    
    
    private final static int NUM_ROWS = 9;
    private final static int NUM_COLUMNS = 9;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    private static Player winner = null;
    
    public static void Reset() {
 
        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                board[zi][zx] = null;
            }
        }
        winner = null;

    }
    
    public static void CheckWin() {
        
        if (winner != null)
            return;
        
        winner = checkWinWholeBoard();
    }
    

    public static Player checkWinWholeBoard()
    {
        int numConsecutive = 0;
        Color colorMatch = null;

        int totalPoints = 0;
//Check for horizontal win.        
        for (int row=0;row<NUM_ROWS;row++)
        {
            for (int col=0;col<NUM_COLUMNS;col++)
            {

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    totalPoints = 0;
                    colorMatch = null;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;      
                    totalPoints += board[row][col].getValue();
                    if (numConsecutive == NUM_CONNECT_WIN)
                    {
                        for(int i=0; i<=3; i++)
                            board[row][col-i].setColor(Color.GREEN);
                        Player.getOtherPlayer().addPoints(totalPoints);
                        return(Player.getOtherPlayer());
                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                    totalPoints = board[row][col].getValue();
                    colorMatch = board[row][col].getColor();
                }        
             
            }            
            colorMatch = null;
            numConsecutive = 0; 
            totalPoints = 0;
        }
        
//Check for vertical win.       
        colorMatch = null;
        numConsecutive = 0;        
        totalPoints = 0;
        for (int col=0;col<NUM_COLUMNS;col++)
        {
            for (int row=0;row<NUM_ROWS;row++)
            {

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    totalPoints = 0;
                    colorMatch = null;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;                    
                    totalPoints += board[row][col].getValue();
                    
                    if (numConsecutive == NUM_CONNECT_WIN)
                    {
                        for(int i=0; i<=3; i++)
                            board[row-i][col].setColor(Color.GREEN);
                        Player.getOtherPlayer().addPoints(totalPoints);
                        return(Player.getOtherPlayer());

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                    totalPoints = board[row][col].getValue();
                    
                    colorMatch = board[row][col].getColor();
                }        
                             
                
     
            }            
            colorMatch = null;
            numConsecutive = 0;        
            totalPoints = 0;
            
        }    
        
//Check for diagonal win to the right and up.
        colorMatch = null;
        numConsecutive = 0;
        totalPoints = 0;
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            int row = zrow;
            for (int col=0;row>=0;col++)
            {

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    totalPoints = 0;
                    
                    colorMatch = null;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;                    
                    totalPoints += board[row][col].getValue();
                    
                    if (numConsecutive == NUM_CONNECT_WIN)
                    {
                        for(int i=0; i<=3; i++)
                            board[row+i][col-i].setColor(Color.GREEN);
                        Player.getOtherPlayer().addPoints(totalPoints);
                        return(Player.getOtherPlayer());

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                    totalPoints = board[row][col].getValue();
                    colorMatch = board[row][col].getColor();
                }        
             

                row--;
            }
            colorMatch = null;
            numConsecutive = 0;        
            totalPoints = 0;

        }
        
        colorMatch = null;
        numConsecutive = 0;
        totalPoints = 0;
        for (int zcol=1;zcol<NUM_COLUMNS;zcol++)
        {
            int col = zcol;
            for (int row=NUM_ROWS-1;col<NUM_COLUMNS;row--)
            {              

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    totalPoints = 0;
                    colorMatch = null;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;                    
                    totalPoints += board[row][col].getValue();
                    
                    if (numConsecutive == NUM_CONNECT_WIN)
                    {
                        for(int i=0; i<=3; i++)
                            board[row+i][col-i].setColor(Color.GREEN);
                        Player.getOtherPlayer().addPoints(totalPoints);
                        return(Player.getOtherPlayer());

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                    totalPoints = board[row][col].getValue();
                    colorMatch = board[row][col].getColor();
                }        
             
     
                col++;
            }
            colorMatch = null;
            numConsecutive = 0;        
            totalPoints = 0;

        }
        
//Check for diagonal win to the right and down.
        colorMatch = null;
        numConsecutive = 0;      
        totalPoints = 0;
        
        for (int zrow=NUM_ROWS-1;zrow>=0;zrow--)
        {
            int row = zrow;
            for (int col=0;row<NUM_ROWS;col++)
            {

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    totalPoints = 0;
                    colorMatch = null;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;                    
                    totalPoints += board[row][col].getValue();
                    
                    if (numConsecutive == NUM_CONNECT_WIN)
                    {
                        for(int i=0; i<=3; i++)
                            board[row-i][col-i].setColor(Color.GREEN);
                        Player.getOtherPlayer().addPoints(totalPoints);
                        return(Player.getOtherPlayer());

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                    totalPoints = board[row][col].getValue();
                    colorMatch = board[row][col].getColor();
                }        
              
     
                row++;
            }
            colorMatch = null;
            numConsecutive = 0;        
            totalPoints = 0;
            
        }
        
        colorMatch = null;
        numConsecutive = 0;
        totalPoints = 0;
        for (int acol=1;acol<NUM_COLUMNS;acol++)
        {
            int col = acol;
            for (int row=0;col<NUM_COLUMNS;row++)
            {              

                if (board[row][col] == null)
                {        
                    numConsecutive = 0;
                    totalPoints = 0;
                    colorMatch = null;
                }
                else if (board[row][col].getColor() == colorMatch)
                {   
                    numConsecutive++;                    
                    totalPoints += board[row][col].getValue();
                    
                    if (numConsecutive == NUM_CONNECT_WIN)
                    {
                        for(int i=0; i<=3; i++)
                            board[row-i][col-i].setColor(Color.GREEN);
                        Player.getOtherPlayer().addPoints(totalPoints);
                        return(Player.getOtherPlayer());

                    }
                }
                else if (board[row][col].getColor() != colorMatch)
                {                                   
                    numConsecutive = 1;
                    totalPoints = board[row][col].getValue();
                    colorMatch = board[row][col].getColor();
                }        
                   
                
                col++;
            }
            colorMatch = null;
            numConsecutive = 0;        
            totalPoints = 0;
        }
             
        return (null);
    }        
    
    public static void AddPiecePixel(int xpixel,int ypixel) {
        
        if (winner != null)
            return;
        
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;

        int zcol = 0;
        int zrow = 0;
 
        if (xpixel-Window.getX(0) < 0) {
            for (int zi = 0;zi<NUM_ROWS;zi++)
            {
                int spot = 0;
                for(int zx=0; zx<NUM_COLUMNS; zx++) {
                    Piece curr = board[zi][zx];
                    if(curr != null) {
                        if(spot!=zx)
                            board[zi][zx] = null;
                        board[zi][spot++] = curr;
                    }
                    
                }
            }
            Player.switchTurn();
        }
        
        if (xpixel-Window.getX(0) > xdelta*NUM_COLUMNS) {
            for (int zi = 0;zi<NUM_ROWS;zi++)
            {
                int spot = NUM_COLUMNS-1;
                for(int zx=NUM_COLUMNS-1; zx>=0; zx--) {
                    Piece curr = board[zi][zx];
                    if(curr != null) {
                        if(spot!=zx)
                            board[zi][zx] = null;
                        board[zi][spot--] = curr;
                    }
                    
                }
            }
            Player.switchTurn();
        }
        
        if (xpixel-Window.getX(0) > 0 &&
            ypixel-Window.getY(0) > 0 &&
            xpixel-Window.getX(0) < xdelta*NUM_COLUMNS &&
            ypixel-Window.getY(0) < ydelta*NUM_ROWS)
        {
            zcol = (xpixel-Window.getX(0))/xdelta;
            zrow = (ypixel-Window.getY(0))/ydelta;

            Color currentColor = Player.getCurrentPlayer().getColor();
            if (board[zrow][zcol] != null && board[zrow][zcol].getColor() != currentColor)
            {
                int i=zrow-1;
                for (;i >=0 && board[i][zcol] != null;i--) {
                    board[i+1][zcol] =  board[i][zcol];
                }
                board[i+1][zcol] = null;
                Player.switchTurn();

            }
            else
            {
                int i= NUM_ROWS-1;
                for (;i>-1 && board[i][zcol] != null;i--);
                if (i >= 0) {
                    board[i][zcol] = new Piece(Player.getCurrentPlayer().getColor());
                    Player.switchTurn();
                }
            }
        }        
        
    }

    public static void Draw(Graphics2D g) {
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
 //draw grid
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
                
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
        
        g.setFont(new Font("Arial",Font.PLAIN,20));
        g.setColor(Player.getPlayer1().getColor());
        g.drawString("Player1 = " + Player.getPlayer1().getPoints(), 25,70);              
        g.setColor(Player.getPlayer2().getColor());
        g.drawString("Player2 = " + Player.getPlayer2().getPoints(), 520,70);              
        
        if (winner == Player.getPlayer1()) {
            g.setColor(Player.getPlayer1().getColor());
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Player 1 has Won", 200,70);              
        }
        else if (winner == Player.getPlayer2()) {
            g.setColor(Player.getPlayer2().getColor());
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Player 2 has Won", 200,70);              
        }
        else {
            g.setColor(Player.getCurrentPlayer().getColor());
            g.setFont(new Font("Arial",Font.PLAIN,30));
            if (Player.getCurrentPlayer() == Player.getPlayer1())
                g.drawString("Player 1's turn", 200,70);              
            else
                g.drawString("Player 2's turn", 200,70);              
        }
        
    }
}
