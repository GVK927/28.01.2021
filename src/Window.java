import javax.swing.*;

public class Window extends JFrame {
    public Window(){
        setBounds(200, 200, 800, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Первое задание");
        getContentPane().add(new Mpanel());
    }
}
