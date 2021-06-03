import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Plus{
    private Color color;
    private Rectangle rectangle;

    public Plus(){
        this.rectangle = new Rectangle();
    }
    public Plus(Color color, Rectangle rectangle){
        this.color = color;
        this.rectangle = rectangle;
    }
}
