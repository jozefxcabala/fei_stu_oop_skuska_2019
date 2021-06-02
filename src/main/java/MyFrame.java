import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private ControlPanel controlPanel;
    private MyCanvas canvas;
    private ModeButton modeButton;

    public MyFrame(String nameOfWindow){
        super(nameOfWindow);
        this.setLayout(new BorderLayout());

        this.canvas = new MyCanvas();
        this.add(this.canvas, BorderLayout.CENTER);

        this.controlPanel = new ControlPanel(this.canvas);
        this.add(this.controlPanel, BorderLayout.PAGE_START);

        this.modeButton = new ModeButton("MODE", this.canvas);
        this.add(this.modeButton, BorderLayout.PAGE_END);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
