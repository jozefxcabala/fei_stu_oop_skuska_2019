import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {
    @Getter @Setter
    private Color color;
    @Getter @Setter
    private boolean drawing;
    @Getter @Setter
    private boolean plus;
    @Getter @Setter
    private boolean usecka;

    private Usecka newUsecka;
    private ArrayList<Usecka> listOfUsecka;

    public MyCanvas(){
        this.setPreferredSize(new Dimension(400,400));
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.color = new Color(Color.RED.getRGB());
        this.drawing = true;
        this.plus = false;
        this.usecka = false;
        this.newUsecka = new Usecka(); //tu bola chyba ked to nebolo inicializovane pred kreslenim
        this.listOfUsecka = new ArrayList<>();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintingOfUsecka(g);
    }

    private void paintingOfUsecka(Graphics g){
        for(int i = 0; i < this.listOfUsecka.size(); i++){
            g.setColor(this.listOfUsecka.get(i).getColor());
            g.drawLine(this.listOfUsecka.get(i).getStartPoint().x, this.listOfUsecka.get(i).getStartPoint().y, this.listOfUsecka.get(i).getEndPoint().x,
                    this.listOfUsecka.get(i).getEndPoint().y);
        }
        g.setColor(this.newUsecka.getColor());
        g.drawLine(this.newUsecka.getStartPoint().x, this.newUsecka.getStartPoint().y, this.newUsecka.getEndPoint().x, this.newUsecka.getEndPoint().y);
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
        if(this.usecka && this.drawing){
            this.newUsecka = new Usecka(this.color, new Point(e.getX(), e.getY()), new Point(e.getX(), e.getY()));
            this.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(this.usecka && this.drawing) {
            this.newUsecka.changeActualEndPoint(e.getX(), e.getY());
            this.listOfUsecka.add(this.newUsecka);
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(this.usecka && this.drawing) {
            this.newUsecka.changeActualEndPoint(e.getX(), e.getY());
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
