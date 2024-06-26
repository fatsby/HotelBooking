package fatsby.main;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import fatsby.login.Login;
import fatsby.manager.FormsManager;
import fatsby.manager.Serializer;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    public Application() {
        init();
    }
    private void init() {
        Serializer.createDirectory();
        setTitle("Fatsby Car Retail");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1200, 700));
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(new Login());
        FormsManager.getInstance().initApplication(this);
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatMacDarkLaf.registerCustomDefaultsSource("fatsby.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatMacDarkLaf.setup();
        EventQueue.invokeLater(() -> {
            new Application().setVisible(true);
        });
    }
}
