import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String nameOfWindow){
        super(nameOfWindow);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
