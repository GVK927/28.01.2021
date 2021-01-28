import javax.swing.*;

public class Window extends JFrame {
    public Window(){
        setBounds(200, 200, 1280, 720);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Первый урок");
        getContentPane().add(new Mpanel());
    }
}
