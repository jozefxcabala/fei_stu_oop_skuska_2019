import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@Getter
@Setter
@NoArgsConstructor
abstract public class Shape extends Rectangle{
    protected Color color;

    public Shape(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    abstract public void drawShape(Graphics g);
}
