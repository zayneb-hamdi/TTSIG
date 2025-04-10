package RMIChat;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ChatServer extends Remote{
void sendMessage(Message message) throws RemoteException;
void registerClient(ChatClient client) throws RemoteException;
}
