import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by tkachukp on 07.03.17.
 */
public class DiagramPanel extends JPanel {
    private HashMap<String, Double> angles;

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Rectangle bounds = graphics.getClipBounds();
        graphics.drawOval(0, 0, bounds.width, bounds.height);
        int centerX = bounds.width / 2;
        int centerY = bounds.height / 2;
        double prevAngle = 0;
        Random rnd = new Random();
        for (String key :
                angles.keySet()) {
            double currAngle = angles.get(key);
            Color colorBrush = Color.getHSBColor(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
            graphics.setColor(colorBrush.brighter().brighter());
            graphics.fillArc(0, 0, bounds.width, bounds.height, (int) Math.toDegrees(prevAngle), (int) (Math.toDegrees(currAngle - prevAngle)));
            graphics.setColor(colorBrush.darker());
            graphics.drawString(key, centerX + (int)(bounds.width * (Math.cos((prevAngle + currAngle) / 2) / 4)),
                    centerY - (int)(bounds.height * (Math.sin((prevAngle + currAngle) / 2)) / 4));
            prevAngle = currAngle;
        }
//        graphics.drawLine(centerX, centerY, 0, 0);
    }

    public DiagramPanel(HashMap<String, Integer> data) throws FileNotFoundException {
        int sum = 0;
        angles = new HashMap<>();
        for (int val :
                data.values()) {
            sum += val;
        }
        double angle = 0.0;
        for (String key :
                data.keySet()) {
            angle += (data.get(key) * 2 * Math.PI)/ sum;
            angles.put(key, Double.valueOf(angle));

        }

    }
}
