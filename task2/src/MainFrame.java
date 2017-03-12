import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by tkachukp on 07.03.17.
 */
public class MainFrame extends JFrame{
    public MainFrame() throws IOException {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocationByPlatform(true);
        setLayout(new BorderLayout());
        BufferedImage img = ImageIO.read(new File("flag.png"));
        AnimationPanel animationPanel = new AnimationPanel(50, img, Math.min(screenSize.width, screenSize.height) / 2);
        add(animationPanel, BorderLayout.CENTER);
        JSlider sliderVelocity = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
        sliderVelocity.setValue(50);
        sliderVelocity.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                animationPanel.setVelocity(sliderVelocity.getValue());
            }
        });
        Object[] orientations = {"clockwise", "counter clockwise"};
        JList listOrientation = new JList(orientations);
        listOrientation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOrientation.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                int i = listOrientation.getSelectedIndex();
                if (i == 0){
                    animationPanel.setVelocity(Math.abs(sliderVelocity.getValue()));
                }
                else {
                    animationPanel.setVelocity(-Math.abs(sliderVelocity.getValue()));
                }
            }
        });
        add(listOrientation, BorderLayout.EAST);
        add(sliderVelocity, BorderLayout.SOUTH);
    }
    public static void main (String args[]) throws IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Demo");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
