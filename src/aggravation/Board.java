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

    
    
    static int board2[][] = new int[numRows][numColumns];
    static int board1[][] = {
{WALL,WALL,PATH,PATH,PATH,PATH,PATH,WALL,WALL},
{WALL,PATH,WALL,WALL,WALL,WALL,WALL,PATH,WALL},
{PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH},
{PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH},
{PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH},
{PATH,WALL,WALL,WALL,WALL,WALL,WALL,WALL,PATH},
{WALL,PATH,WALL,WALL,WALL,WALL,WALL,PATH,WALL},
{WALL,WALL,PATH,PATH,PATH,PATH,PATH,WALL,WALL},

    };
       
    
    
    
    
    
    
    
    
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
            if(zcol == 4 && zrow == 4) {
                diceVal = (int)(Math.random()*6+1);
            }
            
        }        
        
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
                        if(board[zi][zx].getColor() == Player.getCurrentPlayer().getColor())
                            g.fillRect(Window.getX(zx*xdelta),
                            Window.getY(zi*ydelta),xdelta,ydelta);
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