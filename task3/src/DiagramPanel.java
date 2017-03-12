import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Scanner;

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
        for (String key :
                angles.keySet()) {
            double angle = angles.get(key);
            graphics.drawLine(centerX, centerY, centerX + (int)(bounds.width * (Math.cos(angle)) / 2),
                    centerY + (int)(bounds.height * (Math.sin(angle))) / 2);
            graphics.drawString(key, centerX + (int)(bounds.width * (Math.cos(angle)) / 4),
                    centerY + (int)(bounds.height * (Math.sin(angle))) / 4);
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
            angles.put(key, Double.valueOf(angle));
            angle += (data.get(key) * 2 * Math.PI)/ sum;
        }

    }
}
