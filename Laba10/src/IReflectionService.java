import java.lang.reflect.Field;

public interface IReflectionService<T> {


    public void execute(T inputClassValue, T replaceByClassValue) throws Exception;

    public class StringReflectionService implements IReflectionService<String> {

        final private IPrintTargetService printer;

        StringReflectionService(IPrintTargetService printer) {
            this.printer = printer;
        }

        @Override
        public void execute(String inputClassValue, String replaceByClassValue) throws Exception{
            printer.print("Value before reflection execution: " + inputClassValue);

            final Class inputClass = inputClassValue.getClass();
            final Field field = inputClass.getDeclaredField("value");

            field.setAccessible(true);
            field.set(inputClassValue, replaceByClassValue.toCharArray());

            printer.print("Value after reflection execution: " + inputClassValue);


        }
    }
}
