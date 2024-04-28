import java.util.Scanner;


public class Snack {
    private static final String[] menu = {"Chips", "Popcorn", "Hotdog", "CocaCola", "Pepsi", "Ice-cream"};
    private static final double[] prices = {20.0, 21.5, 15.25, 18.0, 17.5, 13.25};
    private String cart[] = new String[10];
    private int itemIndex = 0;
    protected double totalPrice = 0;
    public boolean choice = true;


    public void showMenu() {
        System.out.println("\t===MENU===\n");
        for (int i = 0; i < menu.length; i++) {
            System.out.print((i + 1) + ". " + menu[i] + "\t" + prices[i] + "\n");
        }
    }


    public void buySnack() {
        Scanner input = new Scanner(System.in);


        while (choice == true) {
            this.showMenu();
            System.out.print("\nChoose your snack : ");  ////write in number
            int purchasedSnack = input.nextInt();

            // try / catch
            try{
                if (purchasedSnack < 1 || purchasedSnack > 6) {
                    throw new InvalidChoiceException("Choose only 1 to 6!");
                }
                this.cart[this.itemIndex] = menu[purchasedSnack-1];
                this.itemIndex++;
                this.totalPrice = this.totalPrice + prices[purchasedSnack-1];
        
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
            

            System.out.print("\nDo you want to buy more? (Yes or No) : ");
            String buyAgain = input.next();
            if (!buyAgain.equals("yes") && !buyAgain.equals("Yes")) {
                choice = false;
                input.close();
            }
        }
    }




    public String showCart() {
        String string = "";
        string += "\n===Cart Items===" + "\n";
        for (int i = 0; i < this.itemIndex;i++) {
            string += (i+1) + ". " + this.cart[i] + "\n";
        }
        string += "\nSnack Price : " + this.totalPrice + " baht";
        return string;
    }
    //To do : to write the purchased snacks and totalPrice into the Ticketinfo file(which will later be printed out on the ticket)
    //^^ Thiis is better to do later in Ticket class!!










    //Below is just a test
    /*public static void main(String[] args) {
        Snack snack = new Snack();
        snack.buySnack();
        snack.showCart();
    }*/
}

