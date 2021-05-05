import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinScreen extends JFrame implements ActionListener {


    public WinScreen()
    {

        super();
        JButton button = new JButton("PLAY");
        button.setSize(new Dimension(500, 800));
        button.setFont(new Font("Braggadocio",Font.BOLD, 25));
        button.addActionListener(this);

        button.setBackground(new Color(255,153,204));
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setFocusable(false);

        setLayout(new BorderLayout());
        setSize(850,418);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(button,BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        add(new JLabel(new ImageIcon("Images/win.png")));
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        dispose();
    }
}