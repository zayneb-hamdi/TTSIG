package RMIChat;
import java.util.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;


public class ChatServerImplement extends UnicastRemoteObject implements ChatServer {
    private List <ChatClient> clients;
    private ChatManager chatManager;

    public ChatServerImplement() throws RemoteException
    {
        clients=new ArrayList<>();
        chatManager=new ChatManager();
    }


    
    @Override
    public void sendMessage(Message message) throws RemoteException {
        chatManager.saveMessage(message);
        for(ChatClient client:clients)
        {
           client.receiveMessage(message);
        }
        
    }

    @Override
    public void registerClient(ChatClient client) throws RemoteException {
        clients.add(client);
        System.out.println("un nouveau client est connecté");

    }
public static void main(String[] args) {
   try {
    ChatServerImplement chatServerImplement=new ChatServerImplement();
} catch (RemoteException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
}


}
