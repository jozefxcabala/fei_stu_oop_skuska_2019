import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Plus extends Rectangle{
    private Color color;

    public Plus(){

    }

    public Plus(Color color, int x, int y, int width, int height){
        super(x, y, width, height);
        this.color = color;
    }

    public void drawShape(Graphics g) {
        g.setColor(color);
        g.fillRect(this.x,((this.y)+(this.height)/(3)), this.width, (this.height)/(3));
        g.fillRect( (this.x)+((this.width)/(3)), this.y, ((this.width)/(3)), this.height);
    }
}
