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
        this.newPlus = new Plus();
        this.listOfPlus = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintingOfUsecka(g);
        paintingOfPlus(g);
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

    private void paintingOfPlus(Graphics g){
        for(int i = 0; i < this.listOfPlus.size(); i++){
            g.setColor(this.listOfPlus.get(i).getColor());
            g.fillRect(this.listOfPlus.get(i).getRectangle().x, this.listOfPlus.get(i).getRectangle().y,
                    this.listOfPlus.get(i).getRectangle().width, this.listOfPlus.get(i).getRectangle().height);
        }
        g.setColor(this.newPlus.getColor());
        g.fillRect(this.newPlus.getRectangle().x, this.newPlus.getRectangle().y,
                this.newPlus.getRectangle().width, this.newPlus.getRectangle().height);}

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
                if(this.listOfPlus.get(i).getRectangle().contains(e.getX(), e.getY())){
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
            this.newPlus = new Plus(this.color, new Rectangle(e.getX(), e.getY(), 3, 3));
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
            this.newPlus.changeActualEndPoint(e.getX() - this.newPlus.getRectangle().x, e.getY() - this.newPlus.getRectangle().y);
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
            this.newPlus.changeActualEndPoint(e.getX() - this.newPlus.getRectangle().x, e.getY() - this.newPlus.getRectangle().y);


            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
