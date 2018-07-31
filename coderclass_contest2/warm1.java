
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class warm1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        Reader data = new Reader();
        int T = data.nextInt();
        for (int i = 0; i < T; i++) {
            int a, b, c;
            int A = data.nextInt();
            int B = data.nextInt();
            int C = data.nextInt();
            if (A >= B && A >= C) {
                a = A;
                b = B;
                c = C;
            } else if (B >= A && B >= C) {
                a = B;
                b = A;
                c = C;
            } else {
                a = C;
                b = A;
                c = B;
            }

            if (A + B > C && A + C > B && B + C > A) {
                if (a * a == (b * b + c * c)) {
                    bw.append("segitiga siku-siku\n");
                } else if (A == B && A == C && B == C) {
                    bw.append("segitiga sama sisi\n");
                } else if ((A == B && A != C) || (A == C && A != B) || (B == C && B != A)) {
                    bw.append("segitiga sama kaki\n");
                } else {
                    bw.append("segitiga sembarang\n");
                }
            } else if ((A == B && C == 0) || (A == C && B == 0) || (B == C && A == 0)) {
                bw.append("garis lurus\n");
            } else if (A+B==C || A+C == B || B+C == A) {
                bw.append("garis lurus\n");
            } else {

                bw.append("bukan segitiga\n");
            }

        }
        bw.close();
    }

    static class Reader {

        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) {
                return;
            }
            din.close();
        }
    }
}
