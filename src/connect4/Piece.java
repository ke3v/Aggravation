package connect4;
import java.awt.*;

public class Piece {
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
    Piece(Color _color)
    {
        color = _color;
    }
    public Color getColor()
    {
        return (color);
    }
    public void setColor(Color _color) {
        color = _color;
    }
    
    public void draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta) {
        g.setColor(color); 
        g.fillOval(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
           
    }
    
}
