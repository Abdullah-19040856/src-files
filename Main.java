/**
 * This is the main class for the Fotoshop application
 * 
 * @author Joseph Williams
 * @version 09.01.2022
 */
public class Main {
   public static void main(String[] args) {

       Editor editor = new Editor("Filter1", "Filter2", "Filter3", "Filter4");
       editor.set();
       editor.edit();
       Command openCommand = new OpenCommand(editor);
       Command saveCommand = new SaveCommand(editor);
       Command monoCommand = new MonoCommand(editor);
       Command rot90Command = new Rot90Command(editor);

       // Execute commands
       openCommand.execute();
       saveCommand.execute();
       monoCommand.execute();
       rot90Command.execute();
    }
}
