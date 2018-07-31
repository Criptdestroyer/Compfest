
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class detektorpalindrom {

    public static void main(String[] args) throws IOException {
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(data.readLine());
        String temp [] = new String[N];
        for (int i = 0; i < N; i++) {
            temp[i]=data.readLine();
        }
        Reverse(temp);
    }
    public static void Reverse(String temp[]) throws IOException{
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        for (int i = 0; i < temp.length; i++) {
            StringBuilder word = new StringBuilder(temp[i]);
            if(temp[i].equals(word.reverse().toString())){
                bw.append("palindrom\n");
            }else{
                bw.append("bukan palindrom\n");
            }
        }
        bw.close();
    }
    
}
