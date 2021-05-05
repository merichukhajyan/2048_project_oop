import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame implements ActionListener {

    public StartScreen() {
        super();
        JButton button = new JButton("PLAY");

        setLayout(new BorderLayout());
        button.setSize(new Dimension(100, 500));
        button.setFont(new Font("Braggadocio",Font.BOLD, 25));
        button.addActionListener(this);
        button.setBackground(new Color(255,153,204));
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        add(button,BorderLayout.SOUTH);

        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new JLabel(new ImageIcon("Images/logo.png")));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        new Thread(){
            @Override
            public void run() {
                new GameFrame(); // have your frame code here
            }
        }.start();

    }
}