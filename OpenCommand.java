public class OpenCommand implements Command {
    private Editor editor;
    private String filename;

    public OpenCommand(Editor editor) {
        this.editor = editor;

    }

    @Override
    public void execute() {
        editor.open(this.filename);
    }
}
