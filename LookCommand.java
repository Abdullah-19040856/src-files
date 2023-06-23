public class LookCommand implements Command {
    private Editor editor;

    public LookCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.look();
    }

}
