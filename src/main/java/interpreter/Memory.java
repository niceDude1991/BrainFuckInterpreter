package interpreter;

/**
 * Created by Semenov.A on 6/15/2017.
 */
public class Memory {
    private final byte[] memory = new byte[0x1000];
    private int memoryIndex;

    void decreaseMemoryIndex(){
        memoryIndex--;
    }

    void increaseMemoryIndex(){
        memoryIndex++;
    }

     void changeMemory(int i) {
        checkMemoryIndex();
        memory[memoryIndex] += i;
    }

     byte getMemory() {
        return memory[memoryIndex];
    }

     void checkMemoryIndex() {
        if (memoryIndex < 0) {
            memoryIndex += memory.length;
        }
        if (memoryIndex >= memory.length) {
            memoryIndex -= memory.length;
        }
    }
}
