import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoseScreen extends JFrame implements ActionListener{
    public LoseScreen(){

        super();
        JButton button = new JButton("PLAY AGAIN");
        setLayout(new BorderLayout());
        button.setSize(new Dimension(50, 100));
        button.setFont(new Font("Braggadocio",Font.BOLD, 25));
        button.addActionListener(this);
        button.setBackground(new Color(255, 51, 153));
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setForeground(Color.WHITE);
        setFont(new Font("Times New Roman", Font.BOLD, 25));
        setResizable(false);
        setLocationRelativeTo(null);

        add(new JLabel(new ImageIcon("Images/lose.png")));
        add(button,BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        dispose();

    }
}