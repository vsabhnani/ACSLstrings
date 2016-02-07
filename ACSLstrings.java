import java.util.ArrayList;
import java.util.Scanner;


public class ACSLstrings {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String user;
        String contin;

        do {

            System.out.println("Choose the method you wish to use by entering the corresponding number");
            System.out.println("1. char_split (a$, n, ‘char’)\n2. strrem (a$, b$)\n3. strchr (a$, b$) \n4. strtok(a$, b$)\n5. wordwrap(a$, n, b$)  ");
            user = userInput.nextLine();
            int userNum = Integer.parseInt(user);
            if (userNum == 1) {
                charSplit();
            }
            if (userNum == 2) {
                removeMethod();

            }
            if (userNum == 3) {
                firstOccurence();
            }
            if (userNum == 4) {
                
                splitWithSpaces();

            }
            if (userNum == 5) {
                
                wordWrap();
            }
            System.out.println("\nWould you like to test another method? (y/n)");
            contin = userInput.nextLine();
            System.out.println();

        } while (contin.equalsIgnoreCase("y"));
    }

    private static void charSplit() {
        Scanner userInput = new Scanner(System.in);
        String user;
        System.out.println("Please enter in the following format: a$, n, char");
        user = userInput.nextLine();
        
        int firstComma = user.indexOf(',');
        int lastComma = user.lastIndexOf(',');
        String numStr = user.substring(firstComma + 2, lastComma);
        String actualString = user.substring(0, firstComma);
        int num = Integer.parseInt(numStr);
        String character = user.substring(lastComma + 2);
        
        String thePrint = "";
        int agg = num;
        for (int i = 0; i < actualString.length(); i++) {
            if (i == num || i == (num + agg) || i == (num + (2 * agg)) || i == (num + (3 * agg)) || i == (num + (4 * agg)) || i == (num + (5 * agg)) || i == (num + (6 * agg)) || i == (num + (7 * agg)) || i == (num + (8 * agg)) || i == (num + (9 * agg)) || i == (num + (10 * agg)) || i == (num + (11 * agg)) || i == (num + (12 * agg)) || i == (num + (13 * agg)) || i == (num + (14 * agg))) {
                thePrint += character;
                thePrint += actualString.charAt(i);
            } 
            else {
                thePrint += actualString.charAt(i);
            }
        }
        System.out.println(thePrint);
    }

    private static void removeMethod() {
        Scanner userInput = new Scanner(System.in);
        String user;
        System.out.println("Please enter in the following format: a$, b$");
        user = userInput.nextLine();
        
        int firstComma = user.indexOf(',');
        String actualString = user.substring(0, firstComma);
        String stringRemoval = user.substring(firstComma +2);
        actualString = actualString.replaceAll(stringRemoval, "");
        
        System.out.println(actualString);
    }

    private static void firstOccurence() {
        Scanner userInput = new Scanner(System.in);
        String user;
        System.out.println("Please enter in the following format: a$, b$");
        user = userInput.nextLine();
        
        int firstComma = user.indexOf(',');
        String actualString = user.substring(0, firstComma);
        String character = user.substring(firstComma + 2);
        System.out.println(actualString.substring(0, actualString.indexOf(character)));
    }

    private static void splitWithSpaces() {
        Scanner userInput = new Scanner(System.in);
        String user;
        System.out.println("Please enter in the following format: a$, b$");
        user = userInput.nextLine();
        
        int firstComma = user.indexOf(',');
        String actualString = user.substring(0, firstComma);
        String character = user.substring(firstComma + 2);
        
        String finalString = "";
        for(int i = 0; i < actualString.length(); i++){
            if (character.equalsIgnoreCase(String.valueOf(actualString.charAt(i)))){
                finalString += " ";
            }
            finalString += actualString.charAt(i);
        }
        System.out.println(finalString);   
    }

    private static void wordWrap() {
        Scanner userInput = new Scanner(System.in);
        String user;
        System.out.println("Please enter in the following format: a$, n, b$");
        user = userInput.nextLine();
        
        int firstComma = user.indexOf(',');
        int lastComma = user.lastIndexOf(',');
        String numStr = user.substring(firstComma + 2, lastComma);
        String actualString = user.substring(0, firstComma);
        int num = Integer.parseInt(numStr);
        String character = user.substring(lastComma + 2);
        
        ArrayList<String> substrings = new ArrayList<String>();
        int k = 0;
        for(int i = 0; i < actualString.length(); i++){
            
            boolean firstTest = character.equalsIgnoreCase(String.valueOf(actualString.charAt(i)));
            if(firstTest){
               substrings.add(String.valueOf(actualString.charAt(i)));
               k++;
            }
            else if (substrings.isEmpty()){
                substrings.add(String.valueOf(actualString.charAt(i)));   
                k++;
            }
            else if (substrings.get(k-1).length() != num){
                String temp = substrings.get(k-1);
                temp += actualString.charAt(i);
                substrings.set(k-1, temp);
            }
            else{
                substrings.add(String.valueOf(actualString.charAt(i)));   
                k++;
            }
        }
        String finalOutput = "";
        for (int i = 0; i < substrings.size(); i++){
            finalOutput += substrings.get(i) + " ";           
        }
        System.out.println(finalOutput);
       
    }
    
    

}
