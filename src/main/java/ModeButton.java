import lombok.Getter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeButton extends Button implements ActionListener {
    private MyCanvas canvas;

    public ModeButton(String nameOfButton, MyCanvas canvas){
        super(nameOfButton);
        this.addActionListener(this);

        this.canvas = canvas;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.canvas.changeStateOfMode();
        System.out.println("MODE DRAWING: " + this.canvas.isDrawing() );
    }
}
