/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hwalgorithm3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yo
 */
public class HwAlgorithm3 {

    /**
     * @param args the command line arguments
     */
    public static String lcs(String a, String b) {
        int[][] lengths = new int[a.length()+1][b.length()+1];
    // row 0 and column 0 are initialized to 0 already
        for (int i = 0; i < a.length(); i++)
        {
            for (int j = 0; j < b.length(); j++)
            {
                if (a.charAt(i) == b.charAt(j))
                    lengths[i+1][j+1] = lengths[i][j] + 1;
                else
                   lengths[i+1][j+1] =
                       Math.max(lengths[i+1][j], lengths[i][j+1]);
                
            }
            //System.out.println(i);
        }
    // read the substring out from the matrix
         StringBuffer sb = new StringBuffer();
         int tett;
         
         for (int x = a.length(), y = b.length(); x != 0 || y != 0; ) {
             if(x >= 0)
             {
                if ( x > 0 && lengths[x][y] == lengths[x-1][y]   ){
                    x--;
                   sb.append("*");
                }
                else if (lengths[x][y] == lengths[x][y-1] && y != 0 ){
                    y--;
                    //sb.append("*");
                }
                else {
                    if( x!=0 && y!=0)
                    {
                        assert a.charAt(x-1) == b.charAt(y-1);
                        sb.append(a.charAt(x-1));
                        x--;
                        y--;
                    }
                }
             }
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        String test1 = "D:/Activity1.txt";
        String test2 = "D:/Activity2.txt";
        String resultstr = "D:/result1.txt";
        String resultstst = "D:/result2.txt";
        
        try{
            FileReader test1F = new FileReader(test1);
            FileReader test2F = new FileReader(test2);
            FileWriter resultf = new FileWriter (resultstr);
            FileWriter resultf2 = new FileWriter (resultstst);
            BufferedReader test1B = new BufferedReader(test1F);
            BufferedReader test2B = new BufferedReader(test2F);
            BufferedWriter resultB = new BufferedWriter(resultf);
            BufferedWriter resultB2 = new BufferedWriter(resultf2); 
            
            
            String test1C=test1B.readLine();
            String test2C=test2B.readLine() ;
            String ans1,ans2 ;
            String tmp1=test1C,tmp2=test2C;
            
            test1C+="\r\n";
            test2C+="\r\n";
            
            while(tmp1!=null){
            
                tmp1 = test1B.readLine();
                if(tmp1!=null)test1C=test1C+tmp1+"\r\n";
            }
            while(tmp2!=null){
                tmp2 = test2B.readLine();
                if(tmp2!=null)test2C=test2C+tmp2+"\r\n";
            }
            ans1 = lcs(test1C,test2C);
            ans2 = lcs(test2C,test1C);
            
            resultB.write(ans1);     
            resultB2.write(ans2);
            
            
            System.out.println("output: D:/result1.txt");
             System.out.println("output: D:/result2.txt");
           // System.out.println(test1C);
          //  System.out.println(test2C);
            test1B.close();
            test2B.close();
            resultB.close();
            resultB2.close();
            test1F.close();
            test2F.close();
            resultf.close();
            resultf2.close();
           
        }
        catch(FileNotFoundException e ){
             e.printStackTrace();
        } 

    }
    
}
