import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Messenger app1=new Messenger();
        int choice=-1;
        while(choice!=0)
        {
            System.out.println();
            System.out.println("Choose the operation: ");
            System.out.println("1 to send message.");
            System.out.println("2 to display message.");
            System.out.println("3 to add new receiver.");
            System.out.println("4 to delete.");
            System.out.println("5 to delete all messages.");
            System.out.println("6 to dsplay all messages.");
            System.out.println("7 to search a message by ID.");
            System.out.println("8 to sort a message.");
            System.out.println("0 Exit.");
            System.out.print("Your Choice: ");
            choice=input.nextInt();
            System.out.println();
            switch (choice)
            {
                case 1:
                    app1.sendMessage();
                    break;
                case 2:
                    app1.displayMessage();
                    break;
                case 3:
                    app1.addReceivers();
                    break;
                case 4:
                    app1.delete();
                    break;
                case 5:
                    app1.deleteAllMessages();
                    break;


                case 6:
                    app1.displayAllMessages();
                    break;

                case 7:
                    app1.searchMessage();
                    break;
                case 8:
                    app1.sortMessages();
                    break;
                case 0:
                    break;
                default:

            }

        }

    }
}