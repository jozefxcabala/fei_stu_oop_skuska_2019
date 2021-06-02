import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseckaButton extends Button implements ActionListener {
    public UseckaButton(String nameOfButton){
        super(nameOfButton);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
