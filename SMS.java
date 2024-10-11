import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class SMS {
private String messageContent;
private static int counter=0;
 private String id;
    String status;
    LocalDateTime timestamp;
   private int RecID;
    Receiver receiver=new Receiver();

    public SMS( int RecID, String messageContent) {
        this.RecID=RecID;
        counter++;
        id=String.format("%02d", counter);
        //receiver.setName(name);
        this.status="Delivered";
        this.messageContent = messageContent;

        this.timestamp = LocalDateTime.now() ;
    }





    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return timestamp.format(formatter);
    }

    public String toString() {
        return "Message ID: " + getId() + "\nMessage: " + messageContent + "\nTimestamp: " + getFormattedTimestamp() + "\nStatus: " + status;
    }

}
