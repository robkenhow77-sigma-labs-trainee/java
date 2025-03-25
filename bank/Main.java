import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Create bank 
        Bank UBS = Initialise.initializeBank();
               
        int a = 1;
        Scanner scannerObj = new Scanner(System.in);

        while (a == 1) {
            // Search for branch
            System.out.println("Select branch: [London, Edinburgh]");
            String branchLocation = scannerObj.nextLine();
            if (!UBS.branches.keySet().contains(branchLocation)){
                System.out.println("Unknown branch, please try again.");
                continue;
            }
            Branch branch = UBS.branches.get(branchLocation);
            System.out.println("Welcome to " + branch.location + " branch.");


            // Search for member in branch
            System.out.println("What is your name?");
            String userName = scannerObj.nextLine();
            if (!branch.members.keySet().contains(userName)){
                System.out.println("Unknown member, please try again.");
                continue;
            }
            System.out.println("Welcome " + userName + ".");
            Member member = UBS.branches.get(branchLocation).members.get(userName);
            System.out.println("You have a balance of £" + member.balance + ".00");


            // Withdraw or deposit
            System.out.println("Would you like to withdraw, deposit or print statement?");
            String action = scannerObj.nextLine();
            if (!List.of("withdraw", "deposit", "print").contains(action)) {
                System.out.println("Unknown action, please try again.");
                continue;
            }
            System.out.println("You have chosen to " + action);

            // Print statement
            if (action.equals("print")) {
                try {
                    File file = new File("statement.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    if (file.createNewFile()) {
                        System.out.println("File created: " + file.getName());
                        FileWriter myWriter = new FileWriter("statement.txt");
                        myWriter.write("Name: " + member.name + "\nBranch: " + branchLocation + "\nAccount balance: £" + member.balance + ".00");
                        myWriter.close();
                        System.out.println("Successfully wrote to the file."); 
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                // Withdraw or Deposit
                // Select amount
                System.out.println("How much would you like to " + action + "?");
                int amount = scannerObj.nextInt();
                System.out.println("You have selected £" + amount + ".00");
                
                // Change amount
                byte x;
                if (action.equals("withdraw")){
                    x = -1;
                } else {
                    x = 1;
                }
                member.balance += amount * x;
                System.out.println("Your new balance is £" + member.balance + ".00");
                scannerObj.nextLine();
            }
            
            // Exit or continue
            System.out.println("Exit or continue?");
            String exitOrContinue = scannerObj.nextLine();
            if (exitOrContinue.equals("exit")){
                System.out.println("Thank you for banking!");
                break;
            }
        }
        scannerObj.close();
     }
}