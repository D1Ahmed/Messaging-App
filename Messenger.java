import java.util.Scanner;

public class Messenger {
    Receiver receiver=new Receiver();
Scanner input=new Scanner(System.in);
static int messageCounter=0;


    int receiverCount=0;
    int maxReceiver=10;
    Receiver RecArray[]=new Receiver[maxReceiver];



    {

        Receiver r1=new Receiver(0);
        Receiver r2=new Receiver(1);
        Receiver r3=new Receiver(2);

        RecArray[0]=r1;
        RecArray[1]=r2;
        RecArray[2]=r3;
        receiverCount=receiverCount+3;

        SMS sms1=new SMS(0,"Hello");
        SMS sms2=new SMS(0,"How are you");
        SMS sms3=new SMS(0,"lets Hangout!");
        SMS sms4=new SMS(1,"whassup");
        SMS sms5=new SMS(2,"fine?");

        r2.addmessage(sms4);
        r3.addmessage(sms5);
        r1.addmessage(sms1);
        r1.addmessage(sms2);
        r1.addmessage(sms3);

    }
    public void addReceivers()
    {
        int id;
        System.out.println("Enter the id you want to add: ");
        id = input.nextInt();

        if(receiverCount<maxReceiver)
        {
            RecArray[receiverCount]=new Receiver(id);
            receiverCount++;
            System.out.println("receiver added");
        }
        else
        {
            System.out.println("Cant add more recievers");
        }
    }



public void sendMessage()
{

    String message;
    int id;
    int ifsent=0;

    System.out.println("Enter the id of the receiver: ");
    id=input.nextInt();
    System.out.println("Type the message: ");
    message=input.next();

    for(int i=0;i<receiverCount;i++)
    {
        if(RecArray[i].getId()==id)
        {
            SMS sms=new SMS(id,message);
            RecArray[i].addmessage(sms);
            System.out.println("Message sent! ");
            ifsent=1;

        }
    }

    if(ifsent==0)
    {
        System.out.println("not sent YOU DID SMTT WRONGG!!!!!!");
    }
}

public void receiveMessage()
{

}

void displayMessage()
{
    int id;
    System.out.println("Enter the id of reciever for which you want to see message: ");
    id=input.nextInt();
    int found=0;

    for(int i=0;i<receiverCount;i++)
    {


        if(RecArray[i].getId()==id)
        {
            if(RecArray[i].getMessageCount()==0)
            {
                System.out.println("There are no message to this receiver");
            }
            else
            {
                RecArray[i].displayMessage(); //RecArray mn Receivers ka object hai!
                System.out.println();
                found=1;
            }

        }
    }
}

void delete()
{
    int RecId;
    int found=0;
    System.out.println("Enter the Receiver ID jiska mesg delete krna hai: ");
    RecId=input.nextInt();
    for(int i=0;i<receiverCount;i++)
    {
        if(RecArray[i].getId()==RecId)
        {
          RecArray[i].setMessageCount(RecArray[i].getMessageCount()-1);
            System.out.println("Message deleted! ");
        }
    }

}


    void deleteAllMessages()
    {
        int RecId;
        int found=0;
        System.out.println("Enter the Receiver ID jiska mesg delete krna hai: ");
        RecId=input.nextInt();
        for(int i=0;i<receiverCount;i++)
        {
            if(RecArray[i].getId()==RecId)
            {
                RecArray[i].setMessageCount(0);
                System.out.println("all message deleted! ");
            }
        }

    }

    public void displayAllMessages() {
        for (int i = 0; i < receiverCount; i++) {
            System.out.println("Messages for Receiver ID: " + RecArray[i].getId());
            if (RecArray[i].getMessageCount() == 0) {
                System.out.println("No messages for this receiver.");
            } else {
                RecArray[i].displayMessage();
                System.out.println();
            }
        }
    }


    public void searchMessage() {
        System.out.print("Enter the Message ID to search: ");
        String mesgID = input.nextLine();
        int ifound=0;



        for (int i=0;i<receiverCount;i++) {
            Receiver receiver = RecArray[i]; // storing the receiver object at i index
            SMS[] messages = RecArray[i].smsOfReceiver();  //give the Messagearray of the receiver at index i, to messages var


            for (int j = 0; j < RecArray[i].getMessageCount(); j++) {

                if (messages[j].getId().equals(mesgID)) {

                    System.out.println("Message found:");
                    System.out.println(messages[j].toString());
                    ifound = 1;
                }
            }
            if (ifound==1)
            {
                break;
            }
        }
        if (ifound==0) {
            System.out.println("Message with ID " + mesgID + " not found.");
        }
    }


    public void sortMessages() {
        for (int i = 0; i < receiverCount; i++) {
            Receiver receiver = RecArray[i];  // Retrieve the receiver object
            SMS[] messages = receiver.smsOfReceiver();  // Get the message array for that receiver
            int messageCount = receiver.getMessageCount();

            // Bubble Sort for sorting messages by timestamp in descending order (newest first)
            for (int j = 0; j < messageCount - 1; j++) {
                for (int k = 0; k < messageCount - j - 1; k++) {
                    if (messages[k].getTimestamp().compareTo(messages[k + 1].getTimestamp()) < 0) {
                        // Swap messages[k] and messages[k + 1] if k is earlier than k+1
                        SMS temp = messages[k];
                        messages[k] = messages[k + 1];
                        messages[k + 1] = temp;
                    }
                }
            }

            // Display sorted messages for each receiver
            System.out.println("Messages for Receiver ID: " + receiver.getId());
            for (int j = 0; j < messageCount; j++) {
                System.out.println(messages[j].toString());
            }
        }
        System.out.println("Messages sorted by timestamp (most recent first).");
    }



}
