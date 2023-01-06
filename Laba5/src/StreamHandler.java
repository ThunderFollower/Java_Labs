import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamHandler extends FilterOutputStream{

    public StreamHandler(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b);
    }
    public void coding(int b) throws IOException {
        write(b+1);
    }
    public void deCoding(int b) throws IOException{
        write(b-1);
    }
}
