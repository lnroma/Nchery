package registries;

import java.nio.file.Path;

public class FilePathRegistry {

    protected static Path path;

    public static void setPath(Path path) {
        FilePathRegistry.path = path;
    }

    public static Path getPath() {
        return path;
    }
}
