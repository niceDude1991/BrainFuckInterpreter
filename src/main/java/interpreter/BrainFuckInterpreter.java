package interpreter;


import java.util.LinkedList;
import java.util.List;
/**
 * Created by Semenov.A on 6/15/2017.
 */
public class BrainFuckInterpreter implements Interpreter {
    private Memory memory = new Memory();
    private boolean inLoop = false;
    private boolean storeLoopChars = false;
    private final StringBuilder output = new StringBuilder();
    private List<Character> loopStorage = new LinkedList();

    @Override
    public String execute(String originalText) {
        originalText.chars().mapToObj(i -> ((char) i)).filter(obj -> obj != null).forEachOrdered(this::interpret);
        return output.toString();
    }

    private void interpret(char command) {
        switch (command) {
            case Commands.BrainFuckCommands.ADD:
                memory.changeMemory(1);
                break;
            case Commands.BrainFuckCommands.END_WHILE:
                if (!inLoop) loopStorage.add(command);
                storeLoopChars = false;
                if (memory. getMemory() != 0) {
                    startLoop();
                }
                break;
            case Commands.BrainFuckCommands.NEXT:
                memory.increaseMemoryIndex();
                memory. checkMemoryIndex();
                break;
            case Commands.BrainFuckCommands.PREVIOUS:
                memory.decreaseMemoryIndex();
                memory. checkMemoryIndex();
                break;
            case Commands.BrainFuckCommands.SUBTRACT:
                memory.changeMemory(-1);
                break;
            case Commands.BrainFuckCommands.WHILE:
                if (inLoop && memory.getMemory() == 0) {
                    return;
                }
                if (!inLoop)
                    storeLoopChars = true;
                break;
            case Commands.BrainFuckCommands.WRITE:
                char write = (char)memory.getMemory();
                output.append(write);
                break;
            case Commands.BrainFuckCommands.READ:
            default:
                break;
        }
        if (storeLoopChars) loopStorage.add(command);
    }

    private void startLoop(){
        inLoop = true;
        loopStorage.forEach(this::interpret);
        loopStorage.clear();
        inLoop = false;
    }


}

