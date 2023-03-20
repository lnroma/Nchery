package registries;

public class NameTableRegister {
    private static int[][][] nameTable = new int[32][32][2];

    public static void setNameTableSheet(int[][][] nameTable) {
        NameTableRegister.nameTable = nameTable;
    }

    public static int[][][] getNameTableSheet() {
        return NameTableRegister.nameTable;
    }
}
