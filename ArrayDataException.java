package geekbrains.jt.homework1;

public class ArrayDataException extends Exception {

    private int badRow = -1, badCol = -1;

    public ArrayDataException(String message) {
        super(message);
    }

    public ArrayDataException(String message, int row, int col) {
        super(message);
        badRow = row;
        badCol = col;
    }

    public String getMoreDetails() {
        if (badRow >= 0 && badCol >= 0) return "Проблема в строке " + badRow + " и столбце " + badCol;
        else return "";
    }

}
