package Command.Sample.command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {
    // �R�O�����X
    private Stack commands = new Stack();
    // ����
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
    }
    // �s�W
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    // �R���̫�@�өR�O
    public void undo() {
        if (!commands.empty()) {
            commands.pop();
        }
    }
    // �����R��
    public void clear() {
        commands.clear();
    }
}
