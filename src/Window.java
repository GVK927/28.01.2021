import javax.swing.*;

public class Window extends JFrame {
    public Window(){
        setBounds(200, 200, 500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Первое задание");
        getContentPane().add(new Mpanel());
    }
}
