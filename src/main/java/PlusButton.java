import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusButton extends Button implements ActionListener {
    private MyCanvas canvas;

    public PlusButton(String nameOfButton, MyCanvas canvas){
        super(nameOfButton);
        this.canvas = canvas;
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        this.canvas.changeStateOfPlus();
    }
}
