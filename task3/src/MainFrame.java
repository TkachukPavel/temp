import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by tkachukp on 07.03.17.
 */

public class MainFrame extends JFrame {
    private HashMap<String, Integer> parseInput(Scanner input) {
        HashMap<String, Integer> res = new HashMap<>();
        try {
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                String key = input.next();
                if (res.containsKey(key)){
                    throw new InputMismatchException("Mulitple values for one category");
                }
                int val = input.nextInt();
                if (val < 0){
                    throw new InputMismatchException("The value should not be negaive");
                }
                res.put(key, val);
            }
        } catch (Exception e) {
            throw e;
        }
        return res;
    }

    public MainFrame() throws FileNotFoundException {
        try {
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            setSize(screenSize.width / 2, screenSize.height / 2);
            setLocationByPlatform(true);
            setLayout(new BorderLayout());
            Scanner input = new Scanner(new File("1data.txt"));
            add(new DiagramPanel(parseInput(input)));
        }
        catch (NoSuchElementException e){
            JOptionPane.showMessageDialog(this, e + ": Not enough elements", "Input Error", JOptionPane.ERROR_MESSAGE);
            throw e;

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, e.toString(), "Input  Error", JOptionPane.ERROR_MESSAGE);
            throw e;
        }

    }

    public static void main(String args[]) {
        try {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setTitle("Demo");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
        }catch (Exception e){
           // e.printStackTrace();
        }
    }
}
