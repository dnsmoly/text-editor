package backend;

public interface BufferManager {
    char[] getLine(long index);
    long size();
    void loadFile(String filename);
    void writeFile();
}
