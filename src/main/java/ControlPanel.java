import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private PlusButton plusButton;
    private UseckaButton useckaButton;
    private Choice chooseColor;
    private Label pickColor;

    public ControlPanel(){
        this.plusButton = new PlusButton("PLUS");
        this.useckaButton = new UseckaButton("USECKA");
        this.chooseColor = new Choice();
        this.pickColor = new Label();

        this.setLayout(new GridLayout(1, 4));
        this.add(this.plusButton);
        this.add(this.useckaButton);
        this.add(this.chooseColor);
        this.add(this.pickColor);
    }
}
