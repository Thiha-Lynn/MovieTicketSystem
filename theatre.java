import java.util.Scanner;
public class  theatre{
    private int theatreNum;
    private String [] seats = new String[] {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", 
                                            "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", 
                                            "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", 
                                            "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", 
                                            "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", 
                                            "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9",
                                            "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", 
                                            "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9",
                                        };
    int price = 350;
    int seatTotal = 0;
    String [] seatNum = new String[10]; 
    int index = 0;
    double totalPrice = 0;

    public int getTheatreNum() {
        return theatreNum;
    }

    public void setTheatreNum(int theatreNum) {
        this.theatreNum = theatreNum;
    }

    public theatre(int theatreNum){
        this.theatreNum = theatreNum;
    }

    //premium / normal seat yway
    public void chooseSeat(){
        boolean choose = false;

        while(choose == false){

            Scanner input = new Scanner(System.in);
            
            //show seats
            System.out.println("=====Seats Number=====");     
            for(int i = 0; i < seats.length; i++){
                if(seats[i].substring(1,2).equals("9")) {
                    System.out.println(seats[i] + " ");
                } else {
                    System.out.print(seats[i] + " ");
                }
            }
            System.out.println();

            //choose seats
            System.out.print("Choose Seat Number: ");
            String seatNo = input.nextLine();

            for(int i = 0; i < seats.length; i++){
                if(seats[i].equals(seatNo)){
                    for(int j = i; j< seats.length; j++) {
                        seats[i] = "--";
                    }
                    seatNum[index] = seatNo;
                    index++;
                    seatTotal++;
                }
            }

            //want more seats?
            System.out.print("Want more seat? (Yes or No) : ");
            String choice = input.next();

            if(choice.equals("yes") || choice.equals("Yes")){
                choose = false;
            } else if(choice.equals("no") || choice.equals("No")){
                choose = true;
            }
        }

        System.out.println(price*seatTotal + " bhat");
        totalPrice = price*seatTotal;
    }

    public String toString(){
        String string = "";
        string += "Theatre " + theatreNum + "\t-\t";
        for(int i = 0; i < index; i++){
            string += seatNum[i] + " ";
        }
        string += "\nSeat Price : " + totalPrice + " baht"; 
        return string;
    }

}
