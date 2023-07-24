import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       try{
            // getSolutino(bufferedReader.readLine());
            String str = null;
            while((str = bufferedReader.readLine()) != null){
               getSolution(str);
            }
       }catch(IOException ex){
           System.out.println(ex.getMessage());
       }
    }
    
    public static void getSolution(String inputString){
        String output = null;
        String [] splitString =  inputString.split(";");
        
        if(splitString[0].equals("S")){
            output = splitSolution(splitString[2]);
        }
        
        if(splitString[0].equals("C")){
            output = combineSolution(splitString[2], splitString[1]);
        }
        System.out.println(output);
    }
    
    public static String splitSolution(String inputString){
           //S;M;plasticCup()  --> plastic cup
            //S;C;LargeSoftwareBook --> large software book
        String replaced = inputString.replace("()", "");
        StringBuilder strBuilder = new StringBuilder();
        for(int i= 0; i < replaced.length(); i++){
            Character ch = replaced.charAt(i);
            if(Character.toUpperCase(ch) == ch && i != 0){
                strBuilder.append(" ");
            }
            strBuilder.append(Character.toLowerCase(ch));
        }        
        return strBuilder.toString();
    }
    
    public static String combineSolution(String inputString, String operation){
                // C;M;mouse pad;
                // C;code swarm
        String loweredStr = inputString.toLowerCase();
        StringBuilder strBuilder = new StringBuilder();
        boolean perviousWasUpper = false;
        
        for(int i = 0; i < loweredStr.length(); i++){
            Character ch = loweredStr.charAt(i);
            if(operation.equals("C")){
                if(i == 0){
                    ch = Character.toUpperCase(ch);
                }
            }
            if (ch == ' '){
                perviousWasUpper = true;
                continue;
            }
            if(perviousWasUpper){
                ch = Character.toUpperCase(ch);
                perviousWasUpper = false;
            }
            strBuilder.append(ch);
            if(operation.equals("M") && i == loweredStr.length()-1){
                strBuilder.append("()");
            }
        }
        return strBuilder.toString();
    }
}
