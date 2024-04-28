import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class movieticket extends Snack{ //inheritance
    
    double totalCost;
    File ticketfile = new File("data.txt") ;

    //I0 input output
    public void printticket(){
        String string = "\t===Movie Ticket===\n";
        try (DataInputStream din = new DataInputStream(new FileInputStream(ticketfile))) {
            string += din.readUTF() + "\n";
            string += din.readUTF() + "\n";
            string += din.readUTF() + "\n";
            string += "Total Cost : " + totalCost + " baht";
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(string);
    }

    public void calculateCost(theatre theatre){
        totalCost = theatre.totalPrice + totalPrice;
    }
    public static void main(String args[]){
        theatre theatre1 = new theatre(1);
        theatre theatre2 = new theatre(2);
        theatre theatre3 = new theatre(3);

        String[] nameList = {"When you wish upon a star", "Encanto",  "Moanaaa", "Tangled", "Frozen"};
        int[] startimeList = {2300, 1150, 1500, 1430,1700};
        int[] runtimeList = {120, 115, 120, 137, 154};


        movieData Thursday =  new movieData(nameList, startimeList, runtimeList);
        Thursday.makeList();
        Thursday.Display();
        Movie choice = Thursday.chosenMovie();
        System.out.println(choice.toString());

        Scanner input = new Scanner(System.in);
        System.out.println("Choose theatre \n1.Theatre 1 \n2.Theatre 2 \n3.Theatre 3");
        int choose = input.nextInt();
        theatre theatreChosen = null;
        if(choose == 1){
            theatreChosen = theatre1;
        } else if(choose == 2){
            theatreChosen = theatre2;
        } else if(choose == 3){
            theatreChosen = theatre3;
        }

        theatreChosen.chooseSeat();
        movieticket ticket = new movieticket();
        ticket.buySnack();
        ticket.calculateCost(theatreChosen);
        try(DataOutputStream dOut = new DataOutputStream(new FileOutputStream(ticket.ticketfile))){
            dOut.writeUTF(choice.toString());
            dOut.writeUTF(theatreChosen.toString());
            dOut.writeUTF(ticket.showCart());

        } catch (IOException e) {
            e.getMessage();
        }
        
        ticket.printticket();

    }
} 
