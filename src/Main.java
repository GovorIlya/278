import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws  FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("output.txt"));
        Scanner scanner = new Scanner(new File("input.txt"));

      String line1="";
      String line2="";
     try {
          line1=scanner.nextLine();
     }catch (Exception e ){
         System.out.println(e.getMessage());
     }
      try {
          line2=scanner.nextLine();
      }catch (Exception e){
         System.out.println(e.getMessage());
      }
        scanner.close();

        if (validation(line1) && validation(line2)) {

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

        }else {
            if(line2.isEmpty() && !line1.isEmpty()){writer.write("NO");}
            else if(line1.isEmpty() && line2.isEmpty()){writer.write("YES");}
            else if(!line2.isEmpty()&& line1.isEmpty()){writer.write("YES");}
            else {writer.write("NO");}
        }
        writer.close();
    }


    public static boolean validation(String testString){
        Pattern p = Pattern.compile("^(A|G|C|T)+$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

}

