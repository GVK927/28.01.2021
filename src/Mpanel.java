import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.Random;

public class Mpanel extends JPanel{
    private final Timer timer;
    private final DrawImg img;
    private final Random random = new Random();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img.draw(g);
    }

    public Mpanel(){
        setLayout(null);
        setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
        int x = random.nextInt(Window.WIDTH- DrawImg.WIDTH);
        int y = random.nextInt(Window.HEIGHT- DrawImg.HEIGHT);
        img = new DrawImg(x, y, "DVD_Logo1.png");
        this.timer = new Timer(5, e -> {
            if(img.x>=Window.WIDTH-DrawImg.WIDTH||img.x<=0) {
                img.dx = -img.dx;
                img.changeColor();
            }
            if(img.y>=Window.HEIGHT-DrawImg.HEIGHT||img.y<=0) {
                img.dy = -img.dy;
                img.changeColor();
            }
            img.x+=img.dx;
            img.y+=img.dy;
            repaint();
        });
        timer.start();
    }
    private class DrawImg {
        private static final int WIDTH = 240;
        private static final int HEIGHT = 109;
        private int c_num;
        private int dx, dy;
        private int x, y;
        private BufferedImage image;

        {
            c_num = -1;
            dx = 1;
            dy = 1;
        }

        public DrawImg(int x, int y, String path){
            this.x = x;
            this.y = y;
            try{
                this.image = ImageIO.read(new File(path));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public void draw(Graphics g){
            g.drawImage(image, this.x, this.y, null);
        }
        private void changeColor(){
            int n = 100+random.nextInt(155);
            int c_num_ = random.nextInt(3);
            while (c_num==c_num_)
            c_num_ = random.nextInt(3);
            c_num=c_num_;
            WritableRaster alpha = image.getAlphaRaster();
            for(int i = 0; i<WIDTH; i++){
                for(int j = 0; j<HEIGHT; j++){
                    int[] b = alpha.getPixel(i, j, new int[1]);
                    int a = image.getRGB(i, j);
                    if((b[0])==0) continue;
                    Color pixel = new Color(image.getRGB(i, j));
                    int new_red = 0, new_green = 0, new_blue = 0;
                    switch (c_num){
                        case 0:
                            new_red = n;
                            break;
                        case 1:
                            new_green = n;
                            break;
                        case 2:
                            new_blue = n;
                            break;
                    }
                    image.setRGB(i, j, new Color(new_red, new_green, new_blue).getRGB());
                }
            }
        }
    }
}
