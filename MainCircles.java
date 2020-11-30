package geekbrains.jt.homework0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class MainCircles extends JFrame {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        new MainCircles();
    }

    private MainCircles() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds((int) screenSize.getWidth()/2 - WINDOW_WIDTH/2, (int) screenSize.getHeight()/2 - WINDOW_HEIGHT/2, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        initApplication();
        add(canvas);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mouseAction(e);
            }
        });
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private  void render (GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    private void mouseAction(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) removeBall();
        else if (e.getButton() == MouseEvent.BUTTON1) addBall();
    }

    private void removeBall() {
        sprites = Arrays.copyOf(sprites, sprites.length - 1);
    }

    private void addBall() {
        sprites = Arrays.copyOf(sprites, sprites.length + 1);
        sprites[sprites.length - 1] = new Ball();
    }
}
