
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.company.chat.DAO.ChatDAO;
import com.company.chat.DAO.IChatDAO;
 
@ServerEndpoint("/broadcasting")
public class BroadSocket {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
    
    @OnMessage
    public void onMessage(String text, Session session) throws IOException {
    	
    	int index = text.indexOf("|");
    	String id = text.substring(0,index);
    	String message = text.substring(index+1);
    	
    	Date date = new Date(System.currentTimeMillis());
    	SimpleDateFormat inputDateFormat = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss] ");
    	IChatDAO chat = new IChatDAO();
    	chat.insert_ChatLog(id, message);
    	
        System.out.println(inputDateFormat.format(date)+" <"+id+"> "+message);
        synchronized(clients) {
            for(Session client : clients) {
                if(!client.equals(session)) {
                    client.getBasicRemote().sendText(text);
                }
            }
        }
    }
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session);
        clients.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
    }
}