import java.io.*;


public class Main {

    public static void main(String[] args) throws  FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("output.txt"));
        String line1="";
        String line2="";
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
                line1=br.readLine();
                line2=br.readLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
            char[] m1 = line1.toCharArray();
            char[] m2 = line2.toCharArray();
            int f = 0;
            for (int i = 0; i < m2.length; i++) {
                if(f>=m1.length){break;}
                if (m1[f] == m2[i]) {
                    f++;
                }

            }
            if (f == m1.length) {
                writer.write("YES");
            } else {
                writer.write("NO");
            }


        writer.close();
    }



}

