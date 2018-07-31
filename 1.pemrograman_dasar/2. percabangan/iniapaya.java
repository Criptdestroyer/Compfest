

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iniapaya {
    public static void main(String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
        String s = data.readLine();
        if(s.contains("a")||s.contains("b")||s.contains("c")||s.contains("d")||s.contains("e")||s.contains("f")||s.contains("g")||s.contains("h")||s.contains("i")||s.contains("j")||s.contains("k")||s.contains("l")||s.contains("m")||s.contains("n")||s.contains("o")||s.contains("p")||s.contains("q")||s.contains("r")||s.contains("s")||s.contains("t")||s.contains("u")||s.contains("v")||s.contains("w")||s.contains("x")||s.contains("y")||s.contains("z")){
            System.out.println("kata");
        }else{
            if(s.equals("0")){
                System.out.println("nol");
            }else if(s.charAt(0)=='-'){
                System.out.println("bilangan bulat negatif");
            }else{
                System.out.println("bilangan bulat positif");
            }
        }
    }

    }
