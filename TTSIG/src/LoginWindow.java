
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginWindow extends JFrame{
    
    JPanel panelBack,panelButton;
    JLabel labelback,labelUser,labelPassword;
    JButton buttonLogin;
    JTextField fieldUser;
    JPasswordField fieldPassword;
    ImageIcon icon;
    Socket socket;
    BufferedReader reader;
    PrintWriter writer;

    public LoginWindow()
    {
        this.setSize(400,250);
        this.setTitle("TTSIG : Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());



        //declaration des composants
        icon=new ImageIcon("TTSIG\\lib\\treasure_map.jpg");
        labelback=new JLabel(icon);
        panelBack=new JPanel();
        labelUser=new JLabel("nom d'utilisateur :");
        labelPassword=new JLabel("mot de passe :");
        fieldUser=new JTextField(30);
        fieldPassword=new JPasswordField(30);
        panelButton=new JPanel();
        buttonLogin=new JButton("login");




        //les coordonnées des composants
        panelBack.setLayout(null);
        labelback.setBounds(0,0,400,250 );
        labelUser.setBounds(20,50,150,20);
        labelPassword.setBounds(20,100,150,20);
        fieldUser.setBounds(170,50,150,30);
        fieldPassword.setBounds(170,100,150,30);
        buttonLogin.setBounds(165,150,70,30);
        
 



        
        









        //ajout des composants à la fenetre
        this.add(panelBack);
        
        panelBack.add(labelUser);
        panelBack.add(labelPassword);
        panelBack.add(fieldUser);
        panelBack.add(fieldPassword);
        panelBack.add(buttonLogin);
        panelBack.add(labelback);
        
        


        
        








        //mise en forme des composants
        
        labelUser.setFont(new Font("serif",Font.BOLD,18));
        labelPassword.setFont(new Font("serif",Font.BOLD,18));


        //partie client server
        try {
            socket=new Socket("localhost",3000);
            reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer=new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            
            System.out.println("erreur de login partie client");
        }
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=fieldUser.getText();
                String password=fieldPassword.getText();
                writer.println(username+":"+password);
                try {
                    String response=reader.readLine();
                    if (response.equals("success")) {
                         JOptionPane.showMessageDialog(null, "Login Successful!");
                         SIGWindow sigWindow=new SIGWindow(username);
                         dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Login Failed!");
                    }
                    
                } catch (IOException e1) {
                    // TODO: handle exception
                }
            }
        });
        




        

        this.setVisible(true);



    }
    public static void main(String[] args) {
        
    }

}
