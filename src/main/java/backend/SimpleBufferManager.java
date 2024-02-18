package backend;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Slf4j
public class SimpleBufferManager implements BufferManager {
    private char[] buffer;
    private String filename;
    private long[] lineBuffer;
    private int size;

    @Override
    public char[] getLine(long index) {
        return Arrays.copyOfRange(buffer, (int) lineBuffer[(int) index], (int) lineBuffer[(int) index + 1]);
    }

    @Override
    public long size() {
        return this.size;
    }

    @Override
    public void loadFile(String filename) {
        this.filename = filename;
        File file = new File(filename);
        try (FileReader fis = new FileReader(file, StandardCharsets.UTF_8)) {
            buffer = new char[(int) file.length()];
            if (fis.read(buffer) < (int) file.length()) {
                log.info("File haven't been loaded fully");
            }
        } catch (IOException ioe) {
            log.error("Error while loading file", ioe);
        }
        initLineBuffer();
    }

    @Override
    public void writeFile() {
        File file = new File(filename);
        try (FileWriter fos = new FileWriter(file)) {
            fos.write(buffer);
        } catch (Exception e) {
            log.error("Error while writing file", e);
        }
    }

    private void initLineBuffer() {
        lineBuffer = new long[buffer.length];
        int lineCounter = 0;
        int lineStart = 0;
        for (int i = 0; i < lineBuffer.length; ) {
            if (buffer[i++] == '\r') {
                if (buffer[i] == '\n') {
                    i++;
                    lineBuffer[lineCounter++] = lineStart;
                    lineStart = i;
                }
            }
        }
        lineBuffer[lineCounter] = buffer.length;
        this.size = lineCounter;
    }

    public char[] getBuffer() {
        return buffer;
    }

}
