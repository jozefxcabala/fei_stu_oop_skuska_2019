import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {
    @Getter @Setter
    private Color color;
    @Getter @Setter
    private boolean drawing;
    @Getter @Setter
    private boolean plus;
    @Getter @Setter
    private boolean usecka;

    public MyCanvas(){
        this.setPreferredSize(new Dimension(400,400));
        this.setBackground(Color.WHITE);
        this.color = new Color(Color.RED.getRGB());
        this.drawing = true;
        this.plus = false;
        this.usecka = false;

        this.setVisible(true);
    }

    public void changeStateOfMode(){
        this.setDrawing(!this.isDrawing());
    }

    public void changeStateOfPlus(){
        this.setPlus(!this.isPlus());
        this.setUsecka(false);
    }

    public void changeStateOfUsecka(){
        this.setUsecka(!this.isUsecka());
        this.setPlus(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
