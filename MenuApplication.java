import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuApplication extends JFrame {
    /**
	 Default Version ID provided by Eclipse IDE
	 */
	private static final long serialVersionUID = 1L;
	// Components
    private JTextArea textArea;
    private Color initialRandomGreen; // Stores the random green color
    private JMenuItem changeColorItem; // Reference to color menu item

    public MenuApplication() {
        // Initialize with random green color
        initialRandomGreen = generateRandomGreen();
        
        // Set up main window
        setTitle("Menu Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create UI components
        createMenuBar();
        createTextArea();
        setVisible(true);
    }
    
    // Creates the menu bar with options
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        
        // Create menu items with actions
        changeColorItem = new JMenuItem("3. Green (RGB: " + 
                                     initialRandomGreen.getRed() + "," +
                                     initialRandomGreen.getGreen() + "," +
                                     initialRandomGreen.getBlue() + ")");
        
        // Add menu items with their actions
        menu.add(new JMenuItem("1. Print Date/Time")).addActionListener(e -> printDateTime());
        menu.add(new JMenuItem("2. Save to log.txt")).addActionListener(e -> saveToFile());
        menu.add(changeColorItem).addActionListener(e -> changeBackgroundColor());
        menu.add(new JMenuItem("4. Exit")).addActionListener(e -> System.exit(0));
        
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    
    // Creates the text area with scroll
    private void createTextArea() {
        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setBackground(new Color(240, 240, 240)); // Light gray default
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    
    // Prints current date/time to text area
    private void printDateTime() {
        String formattedDateTime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        textArea.append("Current date and time: " + formattedDateTime + "\n");
    }
    
    // Saves text content to log.txt file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(textArea.getText());
            textArea.append("Content saved to log.txt\n");
        } catch (IOException e) {
            textArea.append("Error saving file: " + e.getMessage() + "\n");
        }
    }
    
    // Changes background to the random green color
    private void changeBackgroundColor() {
        getContentPane().setBackground(initialRandomGreen);
        textArea.setBackground(initialRandomGreen.brighter()); // Brighter for readability
        textArea.append("Changed background to random green hue: RGB(" + 
                       initialRandomGreen.getRed() + ", " + 
                       initialRandomGreen.getGreen() + ", " + 
                       initialRandomGreen.getBlue() + ")\n");
    }
    
    // Generates a random green color (green-dominant)
    private Color generateRandomGreen() {
        Random random = new Random();
        return new Color(
            random.nextInt(100),    // Low red (0-99)
            150 + random.nextInt(105), // High green (150-255)
            random.nextInt(100)     // Low blue (0-99)
        );
    }
    
    public static void main(String[] args) {
        // Launch the application
        SwingUtilities.invokeLater(MenuApplication::new);
    }
}