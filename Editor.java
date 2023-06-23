import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;


// Editor class
public class Editor {
    private Parser parser;
    private ColorImage currentImage;
    private String name;
    private String filter1;
    private String filter2;
    private String filter3;
    private String filter4;

//    private List<Command> commandList;

    public Editor(String filter1, String filter2, String filter3, String filter4) {
        this.filter1 = filter1;
        this.filter2 = filter2;
        this.filter3 = filter3;
        this.filter4 = filter4;
    }




    public void set() {
        parser = new Parser();
    }

    public void edit() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the editing session is over.
        boolean finished = false;
        while (!finished) {
            CommandWords command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for using Fotoshop.  Good bye.");
        System.exit(0);
    }

    private boolean processCommand(CommandWords command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        return wantToQuit;
    }
    private void printWelcome() {
        System.out.println("Welcome to the image editor!");
        System.out.println("Type 'help' for a list of available commands.");
    }



    public void open(String filename) {
        try {
            BufferedImage image = ImageIO.read(new File(filename));
            currentImage = new ColorImage(image);
            System.out.println("Image opened: " + filename);
        } catch (IOException e) {
            System.out.println("Error opening image: " + e.getMessage());
        }
    }

    public void save(String filename) {
        if (currentImage != null) {
            try {
                File output = new File(filename);
                ImageIO.write(currentImage.getImage(), "png", output);
                System.out.println("Image saved: " + filename);
            } catch (IOException e) {
                System.out.println("Error saving image: " + e.getMessage());
            }
        } else {
            System.out.println("No image open. Please open an image first.");
        }
    }

    public void look() {
        if (currentImage != null) {
            currentImage.applyFilter(filter1);
            currentImage.display();
        } else {
            System.out.println("No image open. Please open an image first.");
        }
    }

    public void mono() {
        if (currentImage != null) {
            currentImage.applyFilter(filter2);
        } else {
            System.out.println("No image open. Please open an image first.");
        }
    }

    public void rot90() {
        if (currentImage != null) {
            currentImage.applyFilter(filter3);
        } else {
            System.out.println("No image open. Please open an image first.");
        }
    }

    private void printHelp() {
        System.out.println("You are using Fotoshop.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   open save look mono flipH rot90 help quit");
    }

    private boolean quit(Command command) {
        if (new CommandWords().hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    private boolean script(CommandWords command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to open...
            System.out.println("which script");
            return false;
        }

        String scriptName = command.getSecondWord();
        Parser scriptParser = new Parser();
        try (FileInputStream inputStream = new FileInputStream(scriptName)) {
            scriptParser.setInputStream(inputStream);
            boolean finished = false;
            while (!finished) {
                try {
                    CommandWords cmd = scriptParser.getCommand();
                    finished = processCommand(cmd);
                } catch (Exception ex) {
                    return finished;
                }
            }
            return finished;
        }
        catch (FileNotFoundException ex) {
            System.out.println("Cannot find " + scriptName);
            return false;
        }
        catch (IOException ex) {
            throw new RuntimeException("Panic: script barfed!");
        }
    }
}




