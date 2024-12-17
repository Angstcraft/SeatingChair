package seating_graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChairSimulator extends JFrame {

    private Human human;
    private Chair currentChair;
    private WoodenChair woodenChair;
    private OfficeChair officeChair;
    private JLabel chairHeightLabel;
    private JPanel chairPanel;

    public ChairSimulator() {
        human = new Human();
        woodenChair = new WoodenChair(60, "Oak");
        officeChair = new OfficeChair(65, "AWS");

        // Set up the frame
        setTitle("Chair Simulator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Add a panel to represent the chair
        chairPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawScene(g);
            }
        };
        chairPanel.setPreferredSize(new Dimension(800, 500));
        add(chairPanel, BorderLayout.CENTER);

        // Add the chair height label
        chairHeightLabel = new JLabel("Chair Height: " + woodenChair.getHeight());
        chairHeightLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(chairHeightLabel, BorderLayout.NORTH);

        // Add buttons for interaction
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 5));

        JButton officeChairButton = new JButton("Select Office Chair");
        officeChairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentChair = officeChair;
                updateChairHeightLabel();
                repaint();
            }
        });

        JButton woodenChairButton = new JButton("Select Wooden Chair");
        woodenChairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentChair = woodenChair;
                updateChairHeightLabel();
                repaint();
            }
        });

        JButton raiseButton = new JButton("Raise Chair");
        raiseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                human.raiseChair(currentChair, 5);
                updateChairHeightLabel();
                repaint();
            }
        });

        JButton lowerButton = new JButton("Lower Chair");
        lowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                human.lowerChair(currentChair, 5);
                updateChairHeightLabel();
                repaint();
            }
        });

        JButton sitButton = new JButton("Sit on Chair");
        sitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (human.isSitting()) {
                    human.stand();
                    sitButton.setText("Sit on Chair");
                } else {
                    human.sit(currentChair);
                    sitButton.setText("Stand up");
                }
                repaint();
            }
        });

        controlPanel.add(officeChairButton);
        controlPanel.add(woodenChairButton);
        controlPanel.add(raiseButton);
        controlPanel.add(lowerButton);
        controlPanel.add(sitButton);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private void updateChairHeightLabel() {
        chairHeightLabel.setText("Chair Height: " + currentChair.getHeight());
    }

    private void drawScene(Graphics g) {
        // Draw background
        g.setColor(new Color(220, 220, 220)); 
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw floor
        g.setColor(new Color(180, 180, 180)); 
        g.fillRect(0, getHeight() - 100, getWidth(), 100); 

        // Draw the chair
        drawChair(g);

        // Draw the human if sitting or standing
        drawHuman(g);
    }

    private void drawChair(Graphics g) {
        // Drawing the chair based on the type
        if (currentChair instanceof WoodenChair) {
            drawWoodenChair(g);
        } else if (currentChair instanceof OfficeChair) {
            drawOfficeChair(g);
        }
    }

    private void drawWoodenChair(Graphics g) {
        g.setColor(new Color(139, 69, 19)); 
        g.fillRect(350, 250 - currentChair.getHeight(), 120, 20); 

        g.setColor(Color.BLACK);
        g.fillRect(365, 270 - currentChair.getHeight(), 10, 50); 
        g.fillRect(445, 270 - currentChair.getHeight(), 10, 50); 

        g.setColor(new Color(139, 69, 19));
        g.fillRect(350, 250 - currentChair.getHeight() - 40, 120, 10);  
    }

    private void drawOfficeChair(Graphics g) {
        g.setColor(new Color(0, 102, 204)); 
        g.fillRect(350, 250 - currentChair.getHeight(), 120, 20); 

        g.setColor(new Color(0, 51, 102)); 
        g.fillRect(350, 250 - currentChair.getHeight() - 50, 120, 50);  

        g.setColor(Color.BLACK);
        g.fillRect(365, 270 - currentChair.getHeight(), 10, 50); 
        g.fillRect(445, 270 - currentChair.getHeight(), 10, 50); 

        g.setColor(Color.GRAY);
        g.fillOval(360, 320 - currentChair.getHeight(), 15, 15); 
        g.fillOval(455, 320 - currentChair.getHeight(), 15, 15); 
    }

    private void drawHuman(Graphics g) {
        g.setColor(Color.PINK);
        g.fillOval(human.getXPosition(), human.getYPosition(), 40, 40); 

        g.setColor(Color.BLUE);
        g.fillRect(human.getXPosition() + 10, human.getYPosition() + 40, 20, 50); 

        g.setColor(Color.BLUE);
        g.drawLine(human.getXPosition() + 10, human.getYPosition() + 40, human.getXPosition() - 20, human.getYPosition() + 60); 
        g.drawLine(human.getXPosition() + 10, human.getYPosition() + 40, human.getXPosition() + 40, human.getYPosition() + 60); 

        g.setColor(Color.BLUE);
        if (human.isSitting()) {
            g.drawLine(human.getXPosition() + 10, human.getYPosition() + 90, human.getXPosition() - 20, human.getYPosition() + 120); 
            g.drawLine(human.getXPosition() + 10, human.getYPosition() + 90, human.getXPosition() + 40, human.getYPosition() + 120); 
        } else {
            g.drawLine(human.getXPosition() + 10, human.getYPosition() + 90, human.getXPosition() - 20, human.getYPosition() + 120); 
            g.drawLine(human.getXPosition() + 10, human.getYPosition() + 90, human.getXPosition() + 40, human.getYPosition() + 120); 
        }

        g.setColor(Color.BLACK);
        g.fillOval(human.getXPosition() + 10, human.getYPosition() + 10, 5, 5); 
        g.fillOval(human.getXPosition() + 25, human.getYPosition() + 10, 5, 5); 
        g.drawArc(human.getXPosition() + 10, human.getYPosition() + 15, 20, 10, 0, human.isSitting() ? -180 : 180); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChairSimulator simulator = new ChairSimulator();
                simulator.setVisible(true);
            }
        });
    }
}
