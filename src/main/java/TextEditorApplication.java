import backend.SimpleBufferManager;
import frontend.Renderer;
import frontend.SimpleRenderer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextEditorApplication {
    public static void main(String[] args) {
        SimpleBufferManager bufferManager = new SimpleBufferManager();
        bufferManager.loadFile("text.txt");
        log.info("Buffer: " + String.valueOf(bufferManager.getLine(2)));
        log.info("Size: " + bufferManager.size());
        char[] buffer = bufferManager.getBuffer();
        log.info("Buffer: {}", buffer);
        Renderer renderer = new SimpleRenderer();
        renderer.renderMainFrame();
    }
}
