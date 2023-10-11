import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Weather Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel searchLabel = new JLabel("Search a City");
        searchLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField searchBar = new JTextField(15);

        JButton searchButton = new JButton("Search");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); //padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(searchLabel, gbc);

        gbc.gridy = 1; //Move to the next row
        gbc.gridwidth = 1;
        panel.add(searchBar, gbc);

        gbc.gridx = 1; //Move to the next column
        panel.add(searchButton, gbc);

        frame.add(panel);
        frame.setVisible(true);

        APIHandler apihandler = new APIHandler();
        apihandler.callAPI();
    }
}
