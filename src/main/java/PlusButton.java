import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusButton extends Button implements ActionListener {
    public PlusButton(String nameOfButton){
        super(nameOfButton);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
