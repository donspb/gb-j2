package geekbrains.jt.homework0;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    MainCircles controller;
    Background background;
    long lastFrameTime = System.nanoTime();

    GameCanvas(MainCircles controller) {
        this.controller = controller;
        background = new Background(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.0000000001f;
        lastFrameTime = currentTime;
        controller.onDrawFrame(this, g, deltaTime);
        background.update(this, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}
