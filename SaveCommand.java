public class SaveCommand implements Command {
    private Editor editor;
    private String filename;

    public SaveCommand(Editor editor) {
        this.editor = editor;
        this.filename = filename;
    }

    @Override
    public void execute() {
        editor.save(filename);
    }
}
