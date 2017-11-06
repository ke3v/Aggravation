
package aggravation;

import java.awt.Color;
import java.awt.Graphics2D;

public class BoardPieces {
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
    BoardPieces(Color _color)
    {
        color = Color.white;
        rect = false;
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
        g.fillRect(Window.getX(column*xdelta),
        Window.getY(row*ydelta),xdelta,ydelta);
           
    }
}
