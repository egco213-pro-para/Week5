package exercise.pkg5;

import java.util.*;
import java.io.*;

class CookingOil implements Comparable <CookingOil> {
   private String name;
   private int    mono, poly, sat;
   
   public CookingOil (String n, int f, int a, int d)
   {
       name = n;
       mono = f;
       poly = a;
       sat = d;
   }
   
   public void report()                 
   {
       System.out.printf("%-30s mono = (%d)  poly = %5d sat = %5d\r\n",name,mono,poly,sat);
   }
   @Override
   public int compareTo(CookingOil other)  
   {
       if (this.mono > other.mono) return -1;
       else if (this.mono < other.mono) return 1;
       
       if (this.poly > other.poly) return -1;
       else if (this.poly < other.poly) return 1;
         
       if (this.sat > other.sat) return -1;
       else if (this.sat < other.sat) return 1;
        
       if (this.name.compareToIgnoreCase(other.name) < 0) return -1;
       else return 1;
   }
}
public class Exercise5 {

    public static void main(String[] args) {
            String infile = "fat.txt";
            ArrayList <CookingOil> C = new ArrayList <CookingOil> ();
            try{
                Scanner scan  = new Scanner(new File(infile));
                while(scan.hasNext()){
            {
               String line = scan.nextLine();
                    String [] buf = line.split(",");
                    int mono = Integer.parseInt( buf[1].trim());
                    int poly = Integer.parseInt( buf[2].trim());
                    int sat = Integer.parseInt( buf[3].trim());
                    CookingOil a = new CookingOil(buf[0], mono, poly,sat);
                    C.add(a);
                }
            }}
            catch(Exception e){
                System.err.println(e);
            }
            Collections.sort(C);
            for(int i=0;i<C.size();i++) C.get(i).report();
}
}
