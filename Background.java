package geekbrains.jt.homework0;

import java.awt.*;
import java.util.Random;

public class Background {

    private Color color;
    private int ra, ga, ba;
    private int vR = 1000;
    private int vG = 1000;
    private int vB = 1000;

    Background(GameCanvas canvas) {
        ra = (int)(Math.random()*255);
        ga = (int)(Math.random()*255);
        ba = (int)(Math.random()*255);
        color = new Color(ra, ga, ba);
        setBackgroundColor(canvas);
    }

    protected void update(GameCanvas canvas, float deltaTime) {

        ra = (int)(ra + vR*deltaTime);
        ga = (int)(ga + vG*deltaTime);
        ba = (int)(ba + vB*deltaTime);

        if (ra > 255) {
            ra = 255;
            vR *= -1;
        }
        if (ga > 255) {
            ga = 255;
            vG *= -1;
        }
        if (ba > 255) {
            ba = 255;
            vB *= -1;
        }
        if (ra < 0) {
            ra = 0;
            vR *= -1;
        }
        if (ga < 0) {
            ga = 0;
            vG *= -1;
        }
        if (ba < 0) {
            ba = 0;
            vB *= -1;
        }

        color = new Color (ra, ga, ba);

        setBackgroundColor(canvas);
    }

    protected void setBackgroundColor(GameCanvas canvas) {
        canvas.setBackground(color);
    }

}
