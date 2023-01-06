import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public interface IFileManager {

    public void coding(String inputFilePath, String outputFilePath) throws IOException;

    public void decoding(String inputFilePath, String outputFilePath) throws IOException;

    public class FileManager implements IFileManager {


        public void coding(String inputFilePath, String outputFilePath) throws IOException {
            StreamHandler output = null;
            try {
                final FileInputStream in = new FileInputStream(inputFilePath);
                final FileOutputStream out = new FileOutputStream(outputFilePath);
                output = new StreamHandler(out);
                code(in, output);
            } catch (IOException e) {
                System.out.println(e);
            }

        }

        public void decoding(String inputFilePath, String outputFilePath) throws IOException {
            StreamHandler output = null;
            try {
                final FileInputStream out = new FileInputStream(inputFilePath);
                final FileOutputStream in = new FileOutputStream(outputFilePath);
                output = new StreamHandler(in);
                decode(out, output);
            } catch (IOException e) {
                System.out.println(e);
            }

        }

        private void code(FileInputStream in, StreamHandler output) throws IOException {
            int code;
            while ((code = in.read()) != -1) {
                output.coding(code);
            }
        }

        private void decode(FileInputStream in, StreamHandler output) throws IOException {
            int code;
            while ((code = in.read()) != -1) {
                output.deCoding(code);
            }

        }
    }
}
