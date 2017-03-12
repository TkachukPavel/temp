import javax.swing.*;
import java.awt.*;

/**
 * Created by tkachukp on 07.03.17.
 */
public class MainFrame extends JFrame{
    public MainFrame(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocationByPlatform(true);
        setLayout(new BorderLayout());
        add(new ClockPanel());
    }
    public static void main (String args[]){
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Demo");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
