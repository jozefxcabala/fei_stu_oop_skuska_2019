import lombok.Getter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeButton extends Button implements ActionListener {
    @Getter
    private boolean drawing;

    public ModeButton(String nameOfButton){
        super(nameOfButton);
        this.addActionListener(this);

        this.drawing = true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.drawing){
            this.drawing = false;
            System.out.println("MODE MARKING");
        }
        else{
            this.drawing = true;
            System.out.println("MODE DRAWING");
        }
    }
}
