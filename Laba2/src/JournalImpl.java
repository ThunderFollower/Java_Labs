

import java.util.ArrayList;

public class JournalImpl implements IAdditionService {
    @Override
    public void execute(ArrayList<JournalDataClass> jrnl, WriteDB wrt) {
        jrnl.add(new JournalDataClass(
                wrt.getWriteInt().scanSurname(),
                wrt.getWriteInt().scanName(),
                wrt.getWriteInt().scanBirthDate(),
                wrt.getWriteInt().scanPhone(),
                wrt.getWriteInt().scanAddress()));
    }
}

