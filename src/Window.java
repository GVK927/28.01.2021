import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WIDTH = 1680;
    public static final int HEIGHT = 1050;

    public Window(){
        setBounds(0, 0, WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Первый урок");
        getContentPane().add(new Mpanel()).setBackground(Color.BLACK);
        pack();
    }
}
