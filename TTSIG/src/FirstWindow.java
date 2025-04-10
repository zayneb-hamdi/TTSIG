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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FirstWindow extends JFrame {
    JPanel panelTitle,panelImage,panelButton,panelCenter;
    JButton buttonsuivant;
    ImageIcon icon;
    JLabel labelImage,labelTitle;

public FirstWindow()
{
    this.setSize(500,350);
    this.setTitle("TTSIG");
    
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    //declaration des composants
    panelTitle=new JPanel();
    panelCenter=new JPanel();
    panelImage=new JPanel();
    panelButton=new JPanel();
    labelTitle=new JLabel("BIENVENU");
    icon=new ImageIcon("TTSIG\\lib\\LOGO_TT_.jpg");
    labelImage=new JLabel(icon);
    buttonsuivant=new JButton("suivant");




    //ajout des composants à la fenetre
    this.add(BorderLayout.NORTH,panelTitle);
    panelTitle.add(labelTitle);
    this.add(panelCenter);
    panelImage.add(labelImage);
    panelButton.add(buttonsuivant);
    panelCenter.add(panelImage);
    this.add(BorderLayout.SOUTH,panelButton);
    



    //mise en forme des composants
    labelTitle.setFont(new Font("serif",Font.ITALIC,30));
    labelTitle.setForeground(new Color(40, 124, 175));
    labelImage.setPreferredSize(new Dimension(290,190));
    panelImage.setPreferredSize(new Dimension(300,200));
    panelButton.setPreferredSize(new Dimension(0,50));
    panelImage.setBorder(new LineBorder(Color.orange,2));
    buttonsuivant.setPreferredSize(new Dimension(100,30));
    







    this.setVisible(true);

    buttonsuivant.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginWindow loginWindow=new LoginWindow();
            dispose();
            
        }
    });
}
    
}
