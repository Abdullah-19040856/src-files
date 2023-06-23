public class MonoCommand implements Command {
    private Editor editor;

    public MonoCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.mono();
    }
}
