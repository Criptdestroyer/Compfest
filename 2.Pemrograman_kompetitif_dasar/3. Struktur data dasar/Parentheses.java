
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class Parentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(data.readLine());
        ArrayList<Character> buka = new ArrayList<>();
        ArrayList<Character> tutup = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String S = data.readLine();
            for (int j = 0; j < S.length(); j++) {
                
                if (S.charAt(j) == '[' || S.charAt(j) == '(') {
                    buka.add(S.charAt(j));
                } else {
                    tutup.add(S.charAt(j));
                }
            }
            
            for (int j = 0; j < buka.size(); j++) {
                if (buka.get(j) == '[') {
                    if (tutup.contains(']')) {
                        buka.set(j, '0');
                        tutup.set(tutup.indexOf(']'),'0');
                    }
                } else if (buka.get(j) == '(') {
                    if (tutup.contains(')')) {
                        buka.set(j, '0');
                        tutup.set(tutup.indexOf(')'),'0');
                    }
                }
            }
            
            while(buka.contains('0')){
                buka.remove(buka.indexOf('0'));
            }
            while(tutup.contains('0')){
                tutup.remove(tutup.indexOf('0'));
            }
            
            if(buka.isEmpty() && tutup.isEmpty()){
                bw.append("ya\n");
            }else{
                bw.append("tidak\n");
            }
            buka.removeAll(buka);
            tutup.removeAll(tutup);
            
        }
        bw.close();
    }

    
}
