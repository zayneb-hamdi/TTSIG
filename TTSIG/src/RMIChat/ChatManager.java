package RMIChat;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;





public class ChatManager {
    private Connection connection;
    ChatManager()
    {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1/chatdb";
            String user="root";
            String password="";
            connection=DriverManager.getConnection(url ,user,password);
            System.out.println("connexion à la base chat est reussi");
                } catch (ClassNotFoundException e) {
            System.out.println("jdbc non trouvé");
        }
        catch(SQLException e)
        {
            System.out.println("erreur de connexion à la base chat");
            e.printStackTrace();

        }
    }

    public void saveMessage(Message message)
    {
     try {
        String sql="insert into message (sender,message) values(?,?)";

        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1, message.getSender());
        statement.setString(2, message.getContent());
        statement.executeUpdate();
        System.out.println("message àjouté avec succès");

     } catch (SQLException e) {
        System.out.println("request failed");
     }
    }
    public List<Message>getMessageList()
    {List<Message>list=new ArrayList<>();

        try {
            String sql="select * from message";
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {
                String sender=resultSet.getString("sender");
                String content=resultSet.getString("content");
                list.add(new Message(sender,content));
                
            }

           
        } catch (SQLException e) {
            System.out.println("erreur de recuperation de chat");
        }
        return list;

    }

    

}
