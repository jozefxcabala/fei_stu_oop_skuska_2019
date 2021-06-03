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

    private Plus newPlus;
    private ArrayList<Plus> listOfPlus;

    private int xpos, ypos;

    public MyCanvas(){
        super();
        this.setPreferredSize(new Dimension(400,400));
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.color = new Color(Color.RED.getRGB());
        this.newPlus = new Plus();
        this.drawing = true;
        this.plus = false;
        this.usecka = false;
        this.newUsecka = new Usecka(); //tu bola chyba ked to nebolo inicializovane pred kreslenim
        this.listOfUsecka = new ArrayList<>();
        this.listOfPlus = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintingOfUsecka(g);
        paintingOfPlus(g);
    }

    private void paintingOfUsecka(Graphics g){
        for (Usecka value : this.listOfUsecka) {
            g.setColor(value.getColor());
            g.drawLine(value.getStartPoint().x, value.getStartPoint().y, value.getEndPoint().x,
                    value.getEndPoint().y);
        }
        g.setColor(this.newUsecka.getColor());
        g.drawLine(this.newUsecka.getStartPoint().x, this.newUsecka.getStartPoint().y, this.newUsecka.getEndPoint().x, this.newUsecka.getEndPoint().y);
    }

    private void paintingOfPlus(Graphics g) {
        for (Plus ofPlus : this.listOfPlus) {
            ofPlus.drawShape(g);
        }
        g.setColor(this.newPlus.getColor());
        this.newPlus.drawShape(g);
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
        if(!this.drawing){
            for(int i = this.listOfPlus.size()-1; i >= 0; i--){
                if(this.listOfPlus.get(i).contains(e.getX(), e.getY())){
                    this.listOfPlus.get(i).setColor(this.color);
                    this.repaint();
                    break;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.usecka && this.drawing){
            this.newUsecka = new Usecka(this.color, new Point(e.getX(), e.getY()), new Point(e.getX(), e.getY()));
            this.repaint();
        }
        if(this.plus && this.drawing){
            this.xpos = e.getX();
            this.ypos = e.getY();
            this.newPlus = new Plus(this.color, xpos, ypos, 3, 3);
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
        if(this.plus && this.drawing) {
            this.listOfPlus.add(this.newPlus);
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
        if(this.plus && this.drawing) {
            int dx = e.getX();
            int dy = e.getY();

            if (dx > xpos && dy > ypos) {
                this.newPlus.width = dx - xpos;
                this.newPlus.height = dy - ypos;
            }
            if (dx < xpos && dy > ypos) {
                this.newPlus.x = dx;
                this.newPlus.width = xpos - dx;
                this.newPlus.height = dy - ypos;
            }
            if (dx > xpos && dy < ypos) {
                this.newPlus.y = dy;
                this.newPlus.width = dx - xpos;
                this.newPlus.height = ypos - dy;
            }
            if (dx < xpos && dy < ypos) {
                this.newPlus.x = dx;
                this.newPlus.y = dy;
                this.newPlus.width = xpos - dx;
                this.newPlus.height = ypos - dy;
            }
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
