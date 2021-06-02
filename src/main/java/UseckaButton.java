import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseckaButton extends Button implements ActionListener {
    private MyCanvas canvas;

    public UseckaButton(String nameOfButton, MyCanvas canvas){
        super(nameOfButton);
        this.addActionListener(this);
        this.canvas = canvas;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        this.canvas.changeStateOfUsecka();
    }
}
