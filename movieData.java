import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class movieData {

    // collection
    private String[] names ;
    private int[] startimes;
    private int[] runtimes;
    private ArrayList<Movie> MovieList = new ArrayList<>();

    public movieData(String[] names, int[] startimes, int[] runtimes) {
        this.names = names;
        this.startimes = startimes;
        this.runtimes = runtimes;
    }
    
    //Create Array List With Data
    public void makeList(){
    for(int i =0; i < names.length; i++){
        Movie currentMovie = new Movie(startimes[i],runtimes[i] , names[i]);
        MovieList.add(currentMovie);
        }
    }
   
    //Display Movies to Console
    public void Display(){
        System.out.println("\t====MOVIES====\n");
        Iterator<Movie> movieIterator = MovieList.iterator();
        while (movieIterator.hasNext()){
            Movie current = (Movie) movieIterator.next();
            System.out.println(MovieList.indexOf(current)+1 +". " + current.toString());
        }
        System.out.print("\n============\nChoose one movie you would like to see!!: ");
    }

    //Return Chosen Movie
    public Movie chosenMovie(){
        Scanner key = new Scanner(System.in);
        int choice = 0;
   
        while (true) {
            try {
                choice = key.nextInt();
                if (choice < 1 || choice > names.length) {
                    throw new InvalidChoiceException("Please choose one of the numbers above.");
                } else {
                    break;
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
   
        Movie movieChoice = MovieList.get(choice - 1);
        System.out.println("You chose " + movieChoice.getName()+"!");
        return movieChoice;
       
    }

    
    //for testing
    public static void main (String args[]){
        String[] nameList = {"When you wish upon a star", "Encanto",  "Moanaaa", "Tangled", "Frozen"};
        int[] startimeList = {2300, 1150, 1500, 1430,1700};
        int[] runtimeList = {120, 115, 120, 137, 154};


        movieData Thursday =  new movieData(nameList, startimeList, runtimeList);
        Thursday.makeList();
        Thursday.Display();
        Movie choice = Thursday.chosenMovie();
        System.out.println(choice.toString());


    }


}

