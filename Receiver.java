public class Receiver {
    String name;
    // String id;
    private int id=0;
    private int messageCount=0;
    private SMS sms[];
     public static int counter=0;

Receiver()
{

    this.sms=new SMS[10];
    id++;
    this.messageCount=0;
    // counter++;
    // id=String.format("%02d", counter);
}

    Receiver(int id)
    {

        this.sms=new SMS[10];
        this.id=id;
        this.messageCount=0;

    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public void addNewContact()
    {
        Receiver r1=new Receiver();

    }
    public SMS[] smsOfReceiver()
    {
        return sms;
    }
    public void addmessage(SMS mesg)
    {
        if(messageCount< sms.length)
        {

            sms[messageCount]=mesg;
            messageCount++;
        }
        else {
            System.out.println("message limit reached");
        }
    }

    public void displayMessage()
    {
        for (int i = 0; i < messageCount; i++) {

            System.out.println(sms[i]);
            sms[i].status="Seen";

        }
    }

    public void getMessageContent()
    {
        String content;

    }
}