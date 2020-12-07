package geekbrains.jt.homework1;

public class ArraySizeException extends Exception {

    private int wrongLinesNumber = -1;
    private int wrongColsNumber = -1;

    public ArraySizeException(String message) {
        super(message);
    }

    public ArraySizeException(String message, int wrongLinesNumber) {
        super(message);
        this.wrongLinesNumber = wrongLinesNumber;
    }

    public ArraySizeException(String message, int wrongLinesNumber, int wrongColsNumber) {
        super(message);
        this.wrongLinesNumber = wrongLinesNumber;
        this.wrongColsNumber = wrongColsNumber;
    }

    public String getMoreDetails() {
        if (wrongLinesNumber != -1 && wrongColsNumber != -1 ) return "В " + wrongLinesNumber + " строке " + wrongColsNumber + " столбцов.";
        else if (wrongLinesNumber == -1) return "";
        else return "Реальное число строк: " + wrongLinesNumber;
    }
}
