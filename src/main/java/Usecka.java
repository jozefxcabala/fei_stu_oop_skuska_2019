import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Line2D;

@Getter
@Setter
@NoArgsConstructor
public class Usecka extends Shape {
    public Usecka(Color color, int x, int y, int width, int height){
        super(x, y, width, height);
        this.color = color;
    }

    public void changeActualEndPoint(int x, int y){
        this.width = x;
        this.height = y;
    }

    public void drawShape(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));

        g.setColor(getColor());
        g.drawLine(this.x, this.y, this.width, this.height);
    }
}
