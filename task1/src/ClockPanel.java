import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tkachukp on 07.03.17.
 */
public class ClockPanel extends JPanel {
    private double angle = 0;
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        int r = 150;
        Rectangle bounds = graphics.getClipBounds();
        int centerX = bounds.width / 2;
        int centerY = bounds.height / 2;
        graphics.drawLine(centerX, centerY, centerX + (int) (r * Math.sin(angle)),
                                            centerY - (int) (r * Math.cos(angle)));
        graphics.drawOval(centerX - r, centerY - r, 2*r, 2*r);
    }

    public ClockPanel(){
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                angle += 2 * Math.PI / 60;
                repaint();
            }
        });
        timer.start();
    }
}
