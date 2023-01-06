import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
      final IFileManager.FileManager fileManager =  new IFileManager.FileManager();

      final String inPath = "/Users/thunder/Desktop/Java/Laba5/src/in.txt";
      final String outPath = "/Users/thunder/Desktop/Java/Laba5/src/out.txt";
      final String inOutPath = "/Users/thunder/Desktop/Java/Laba5/src/inOut.txt";

      fileManager.coding(inPath, outPath);
      fileManager.decoding(inOutPath, outPath);
    }


}