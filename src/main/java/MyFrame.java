import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private ControlPanel controlPanel;
    private MyCanvas canvas;

    public MyFrame(String nameOfWindow){
        super(nameOfWindow);
        this.setLayout(new BorderLayout());

        this.controlPanel = new ControlPanel();
        this.add(this.controlPanel, BorderLayout.PAGE_START);

        this.canvas = new MyCanvas();
        this.add(this.canvas, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
