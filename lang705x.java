import java.util.*;
import java.io.*;

public class lang705x
{
    public static void main(String[] args)throws IOException
    {
        // Initialize
        Scanner input1 = new Scanner(new File("prog705x.txt"));
        Scanner input2 = new Scanner(new File("prog512h.dat"));
        String secretword = "";
        // Add every word to a arraylist of string arrays
        ArrayList<String[]> subwords = new ArrayList<>();
        while(input2.hasNext())
        {
            subwords.add(input2.nextLine().split(" "));
        }
        // Run through everything
        while(input1.hasNext())
        {
            // Get spots
            String getter = input1.next();
            String row = getter.substring(0,2);
            int realrow = Integer.parseInt(row);
            String id = getter.substring(2,3);
            int realid = Integer.parseInt(id);
            String word = getter.substring(3,4);
            int realword = Integer.parseInt(word);
            // Decode
            String[] idk = subwords.get(realrow-1);
            String idk2 = idk[realid-1];
            String idk3 = idk2.substring(realword-1,realword);
            
            secretword=secretword+idk3;
        }
        // Printing
        for(int x=0;x<subwords.size();x++)
        {
            for(int y=0;y<subwords.get(x).length;y++)
            {
                System.out.print(subwords.get(x)[y]+" ");
            } 
            System.out.println();
        }
        System.out.println("The secret word is "+secretword);
        input1.close();
        input2.close();
    }
}