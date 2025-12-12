import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Arquivador {
    public static void main(String[] args) {
        String[] cmd = {"Java", "Emisor"};
        String filePath = "arquivador.txt";
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }
        ProcessBuilder pb = new ProcessBuilder(cmd);
        
        try {
            Process processEmisor =  pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (br.readLine()) {
                
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
