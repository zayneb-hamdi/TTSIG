package RMIChat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatClientImplement extends UnicastRemoteObject implements ChatClient {
    private String nom;
    protected ChatClientImplement(String nom) throws RemoteException {
        
        this.nom=nom;
    }

    
    

    @Override
    public void receiveMessage(Message message) throws RemoteException {
        System.out.println("message reçu :"+message.getSender()+":"+message.getContent());
    }
    

}
