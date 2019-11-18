package asd;
import java.util.ArrayList;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Asd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> orszagnev = new ArrayList<>();
        ArrayList<String> allamforma = new ArrayList<>();
        ArrayList<Integer> terulet = new ArrayList<>();
        ArrayList<Integer> lakosok = new ArrayList<>();
        ArrayList<String> foldterulet = new ArrayList<>();
        try {
        ArrayList<String> countrys = new ArrayList<>();
        FileReader file = new FileReader("orszagok.txt");
        BufferedReader br = new BufferedReader(file);
        String sor = null; int i = 0;
        while ((sor = br.readLine()) !=null) {
            String[] d = sor.split(";");
            orszagnev.add(d[0]);
            allamforma.add(d[1]);
            terulet.add(Integer.parseInt(d[2]));
            lakosok.add(Integer.parseInt(d[3]));
            foldterulet.add(d[4]);
            
        }
        br.close();
        }
        catch(IOException fail)
        {
            System.out.println("file not found"+fail);
        }
        for (int i = 0; i < foldterulet.size(); i++) {
            System.out.println(orszagnev.get(i)+","+allamforma.get(i)+","+terulet.get(i)+","+lakosok.get(i)+","+foldterulet.get(i));
        }
        //d
        System.out.println("    ");
        System.out.println("Deck");
        for (int i = 0; i < foldterulet.size(); i++) {
            if (allamforma.get(i).equals("köztársaság")) {
                System.out.println(orszagnev.get(i)+ " -- " + allamforma.get(i));
            }
        }
        //e
        System.out.println("    ");
        System.out.println("Fact");
        int counter = 0;
        for (int i = 0; i < foldterulet.size(); i++) {
            if (allamforma.get(i).equals("köztársaság"))  {
                counter++;
            }
        }
        System.out.println(counter + ", that's all");
        //F
        System.out.println("   ");
        System.out.println("Fair");
        int term2 = 0;
        int laksz = 0;
        for (int i = 0; i < foldterulet.size(); i++) {
            term2 += terulet.get(i);
            laksz += lakosok.get(i);
        }
        System.out.println(term2 + " Squaremeter");
        System.out.println(laksz + " popularity");
        //g
        System.out.println("   ");
        System.out.println("Gather");
        String min = null;
        int mincount = 0;
        
        for (int i = 0; i < foldterulet.size(); i++) {
            if (mincount < terulet.get(i)) 
            {
                mincount = terulet.get(i);
                min = orszagnev.get(i);
            }
        }
        System.out.println("smallest country : "+min);
        //h
        System.out.println("   ");
        System.out.println("heist:");
        System.out.println("    ");
        
        for (int i = 0; i < foldterulet.size(); i++) 
        {
            if (foldterulet.get(i).equals("Afrika"))
            {
                System.out.println(orszagnev.get(i) + ": " + ((lakosok.get(i)*1000) / terulet.get(i)) + " fo/km2");
            }
        }
    }
    
}
