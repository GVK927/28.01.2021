import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    public Window(){
        setBounds(200, 200, WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Первый урок");
        getContentPane().add(new Mpanel()).setBackground(Color.BLACK);
        getContentPane();
        pack();
    }
}
