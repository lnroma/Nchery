package registries;

import java.nio.file.Path;

public class FilePathRegistry {

    protected static Path path;
    protected static Path nameTablePath;

    public static void setPath(Path path) {
        FilePathRegistry.path = path;
    }

    public static Path getPath() {
        return path;
    }

    public static void setNameTablePath(Path path) {
        FilePathRegistry.nameTablePath = path;
    }

    public static Path getNameTablePath() { return nameTablePath; }
}
