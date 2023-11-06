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

        JLabel descriptionLabel = new JLabel();

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

        gbc.gridy = 4;
        panel.add(descriptionLabel, gbc);

        frame.add(panel);
        frame.setVisible(true);

        APIHandler apiHandler = new APIHandler();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = searchBar.getText();
                if (!cityName.isEmpty()) {
                    WeatherInfo weatherInfo = apiHandler.callAPI(cityName);

                    if (weatherInfo != null) {
                        cityLabel.setText("City: " + weatherInfo.getCityName());
                        temperatureLabel.setText("Temperature: " + weatherInfo.getTemperature() + " °C");
                        descriptionLabel.setText("Description: " + weatherInfo.getWeatherDescription());
                    } else {
                        cityLabel.setText("City: N/A");
                        temperatureLabel.setText("Temperature: N/A");
                        descriptionLabel.setText("Description: N/A");
                    }
                }
            }
        });
    }
}
