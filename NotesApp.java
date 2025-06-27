
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class NotesApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("----Welcome to Notes App----");
            System.out.println("\n1.Write a Note");
            System.out.println("2.View Note");
            System.out.println("3.Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 ->
                    writeNote(sc);

                case 2 ->
                    viewNote();

                case 3 -> {
                    System.out.println("Thank You!");
                    break;
                }
                default -> System.out.println("Invalid option");
            }
        }while(choice != 3);
    }

    private static void writeNote(Scanner sc){
        try(FileWriter fw = new FileWriter("Notes.txt", true)){

            System.out.print("Enter your note : ");
            String note = sc.nextLine();
            fw.write(note + "\n");
            System.out.println("Note saved");
        }catch (IOException e){
            System.out.println("Error writing message!" +e.getMessage());
        }
    }

    private static void viewNote(){
        try(BufferedReader br = new BufferedReader(new FileReader("Notes.txt"))){
            String line;
            System.out.println("\n Your notes");
            while((line = br.readLine()) != null){
                System.out.println("- " +line);
            }

        }catch(IOException e){
            System.out.println("Error reading the message " +e.getMessage());
        }

    }
}