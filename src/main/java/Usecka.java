import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Usecka {
    private Point startPoint;
    private Point endPoint;
    private Color color;

    public Usecka(){
        this.startPoint = new Point();
        this.endPoint = new Point();
    }
    public Usecka(Color color, Point startPoint, Point endPoint){
        this.color = color;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void changeActualEndPoint(int x, int y){
        this.endPoint.x = x;
        this.endPoint.y = y;
    }

    public void drawShape(Graphics g){
        g.setColor(getColor());
        g.drawLine(getStartPoint().x, getStartPoint().y, getEndPoint().x, getEndPoint().y);
    }
}
