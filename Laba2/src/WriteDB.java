
public class WriteDB {
    private IWriteService writeInt;

    public WriteDB(IWriteService writeInt) {
        this.writeInt = writeInt;
    }

    public IWriteService getWriteInt() {
        return writeInt;
    }


}
