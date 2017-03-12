import sun.management.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.DoubleSummaryStatistics;

/**
 * Created by tkachukp on 07.03.17.
 */
public class AnimationPanel extends JPanel{
    private double velocity;
    private BufferedImage image;
    private double angle;
    private int radius = 100;

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        super.paint(graphics);
        Rectangle bounds = graphics.getClipBounds();
        int centerX = bounds.width / 2;
        int centerY = bounds.height / 2;
        radius = Math.min(bounds.height, bounds.width) / 2;
        g2d.drawImage(image, centerX + (int) (radius * Math.cos(angle)),
                                 centerY + (int) (radius * Math.sin(angle)), null);
    }

    public AnimationPanel(int v, BufferedImage img, int r){
        velocity = v;
        image = img;
        this.radius = r;
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                Rectangle bounds = getBounds();
//                r = Math.min(bounds.height, bounds.width) / 2;
                double w = velocity / (double) (radius);
                double period = 2*Math.PI / w;
                angle += w * 0.04;
                repaint();
            }
        });
        timer.start();
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
