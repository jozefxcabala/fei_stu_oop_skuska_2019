import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControlPanel extends JPanel implements ItemListener {
    private PlusButton plusButton;
    private UseckaButton useckaButton;
    private Choice chooseColor;
    private Label pickColor;

    private String[] colors;

    public ControlPanel(){
        initialization();
    }

    private void initialization(){
        this.plusButton = new PlusButton("PLUS");
        this.useckaButton = new UseckaButton("USECKA");
        this.chooseColor = new Choice();
        this.pickColor = new Label();

        this.setLayout(new GridLayout(1, 4));

        initializationOfChooseColor();
        addingToLayout();

    }

    private void initializationOfChooseColor(){
        this.chooseColor.addItemListener(this);
        this.colors = new String[]{"RED", "GREEN", "BLUE"};

        for (String color : this.colors) {
            this.chooseColor.add(color);
        }

        this.pickColor.setBackground(Color.RED);
    }

    private void addingToLayout(){
        this.add(this.plusButton);
        this.add(this.useckaButton);
        this.add(this.chooseColor);
        this.add(this.pickColor);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Color is: " + e.getItem().toString());
        if(e.getItem().toString().equals("RED"))
            this.pickColor.setBackground(Color.RED);
        else if(e.getItem().toString().equals("GREEN"))
            this.pickColor.setBackground(Color.GREEN);
        else if(e.getItem().toString().equals("BLUE"))
            this.pickColor.setBackground(Color.BLUE);
    }
}
