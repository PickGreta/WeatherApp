import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel cityLabel = new JLabel();

        JLabel temperatureLabel = new JLabel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); //padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Align the search components at the top
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(searchLabel, gbc);

        gbc.gridy = 1; //Move to the next row
        gbc.gridwidth = 1;
        panel.add(searchBar, gbc);

        gbc.gridx = 1; //Move to the next column
        panel.add(searchButton, gbc);

        // Display the city's name below the search components
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(cityLabel, gbc);

        gbc.gridy = 3;
        panel.add(temperatureLabel, gbc);

        frame.add(panel);
        frame.setVisible(true);

        APIHandler apiHandler = new APIHandler();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = searchBar.getText();
                if (!cityName.isEmpty()) {
                    apiHandler.callAPI(cityName);

                    cityLabel.setText("City: " + cityName);

                    String temperature = getTemperatureFromAPI(cityName);
                    temperatureLabel.setText("Temperature: " + temperature);
                }
            }
        });
    }

    private static String getTemperatureFromAPI(String cityName) {
        return "19°C";
    }
}
