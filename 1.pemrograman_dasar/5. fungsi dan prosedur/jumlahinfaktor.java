
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class jumlahinfaktor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        
        int X = Integer.parseInt(data.readLine());
        int total=0;
        for (int i = 1; i <=X; i++) {
            if(i == 1){
                total+=1;
            }else if(i == 2){
                total+=2;
            }else{
                for (int j = 1; j < i; j++) {
                    total++;
                }
            }
        }
        bw.append(String.valueOf(total)).append("\n");
        bw.close();
    }
    
}
