package connect4;
import java.awt.*;

public class Piece {
    private Color color;
    boolean rect = false;
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
        rect = false;
    }
    Piece(Color _color, boolean _rect)
    {
        color = _color;
        rect = _rect;
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
        if(!rect)
        g.fillOval(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
        if(rect)
        g.fillRect(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
           
    }
    
}
