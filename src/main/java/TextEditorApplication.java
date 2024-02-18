import backend.BufferManager;
import backend.SimpleBufferManager;
import frontend.Renderer;
import frontend.SimpleRenderer;

import java.util.Arrays;
import java.util.List;

public class TextEditorApplication {
    public static void main(String[] args) {
        SimpleBufferManager bufferManager = new SimpleBufferManager();
        bufferManager.loadFile("text.txt");
        System.out.println("Buffer: " + String.valueOf(bufferManager.getLine(2)));
        System.out.println("Size: " + bufferManager.size());
        char[] buffer = bufferManager.getBuffer();
        Renderer renderer = new SimpleRenderer();
        renderer.renderMainFrame();
    }
}
