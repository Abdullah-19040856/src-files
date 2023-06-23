public class Rot90Command implements Command {
    private Editor editor;

    public Rot90Command(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.rot90();
    }
}
