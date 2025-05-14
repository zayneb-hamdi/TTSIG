package RMIChat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.List;


public class ChatGUI extends JFrame{
    JPanel panelImage,panelChat;
    JLabel labelTitre,labelImage;
    JTextField fieldMessage;
    JTextArea areaChat;
    JButton buttonSend;
    ImageIcon icon;
    String username;
    ChatServer server;


    public ChatGUI(String username)
    {
        this.username=username;
        try {
            Registry registry=LocateRegistry.getRegistry("localhost",1099);
            try {
                server=(ChatServer) registry.lookup("chatserver");
            } catch (NotBoundException e) {
                
                e.printStackTrace();
            }
        } catch (RemoteException e) {
           
            e.printStackTrace();
        }
        this.setTitle("Chat");
        this.setSize(500,500);
        this.setLayout(null);

        //declaration des composants
        panelChat=new JPanel();
        panelImage=new JPanel();
        labelTitre=new JLabel("Bienvenue à votre communauté TT");
        fieldMessage=new JTextField();
        areaChat=new JTextArea();
        buttonSend=new JButton("envoyer");
        icon=new ImageIcon("TTSIG\\lib\\communauté.jpg");
        labelImage=new JLabel(icon);



        //coordonnées des composants
        panelImage.setBounds(10,10,80,80);
        labelTitre.setBounds(100,40,350,20);
        panelChat.setBounds(10,100,460,300);
        fieldMessage.setBounds(10,410,350,40);
        buttonSend.setBounds(370,410,100,40);
        areaChat.setBounds(10,10,440,280);


        
        











        //ajout des composants
        this.add( panelImage);
        panelImage.add( labelImage);
        this.add( labelTitre);
        this.add(panelChat);
        this.add( fieldMessage);
        this.add( buttonSend);
        panelChat.setLayout(null);
        panelChat.add(areaChat);









        //mise en forme des composants
        panelImage.setBorder(new LineBorder(new Color(101, 184, 255),2));
        labelImage.setPreferredSize(new Dimension(65,65));
        labelTitre.setFont(new Font("arial",Font.BOLD,20));
        labelTitre.setForeground(new Color(101, 184, 255));
        panelChat.setBorder(new LineBorder(new Color(101, 184, 255),2));
        fieldMessage.setBorder(new LineBorder(new Color(101, 184, 255),2));
        buttonSend.setBackground(new Color(101, 184, 255));
        buttonSend.setForeground(Color.white);
        buttonSend.setBorder(new LineBorder(new Color(101, 184, 255),1));







        addevents();
        //server.registerClient(this);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addevents()
    {

        buttonSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String content=fieldMessage.getText();
                try {
                    server.sendMessage(new Message(username, content));
                    fieldMessage.setText("");
                    loadchat();
                } catch (RemoteException e1) {
                    
                    e1.printStackTrace();
                }

            }
            
        });
    }
    public void loadchat()
    {
        areaChat.setText("");
        ChatManager chatManager=new ChatManager();
        List<Message> list=chatManager.getMessageList();
        for(Message message:list){
            areaChat.append(message.getSender()+" : "+message.getContent()+"\n");

        }

        
    }
public static void main(String[] args) {
    ChatGUI chatGUI=new ChatGUI("user");
}

}
