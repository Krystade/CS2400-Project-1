//
// Name: 
// Homework: #1
// Due: 02/18/2021
// Course: cs-2400-03-sp21
//
// Description:
// Create an interface and implement it for the bag ADT. Then use the created bag ADT to hold Java keywords, pulled from a file,
// and then check if arguments passed through the command line are included in the bag
//

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class JavaKeywords {
    //Beginning of the main method
    public static void main(String[] args) throws FileNotFoundException{
        //Credit to me
        System.out.println("Java Keywords by J Schmid\n");
        //Create a new empty bag to hold all the keywords
        ArrayBag<String> bag = new ArrayBag<String>(150);
        //Create a Scanner in order to read the text file
        Scanner file = new Scanner(new File("/user/tvnguyen7/data/javakeywords.txt"));
        //Loop through the file and add each keyword to the bag while the bag isn't full
        while(file.hasNextLine()){
            //Add the current word to the bag
            bag.add(file.nextLine());
        }
        //Alert the user that the file has been loaded successfully
        System.out.println("# Java keywords loaded.\n");
        //Check each argument passed to see if it matches something in the bag
        //Rell the user whether or not the item is in the bag
        for(String arg : args){
            if(bag.contains(arg)){
                System.out.println(arg + " is a keyword");
            }else{
                System.out.println(arg + " is not a keyword");
            }
        }
    }
}