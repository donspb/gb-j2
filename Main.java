package geekbrains.jt.homework1;


public class Main {

    private static final int MATRIX_SIZE = 4;

    public static void main(String[] args) {
        try {
            System.out.println(converterArrayInt(converterStringArray("10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0")));
        } catch (ArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMoreDetails());
        } catch (ArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMoreDetails());
        }
    }

    private static String[][] converterStringArray(String stringToConvert) throws ArraySizeException {
        String[][] result = new String[MATRIX_SIZE][MATRIX_SIZE];
        String[] checkLinesString = stringToConvert.split("\n");
        String[] checkColumnsString;
        if (checkLinesString.length == MATRIX_SIZE) {
            for (int i = 0; i < checkLinesString.length; i++) {
                checkColumnsString = checkLinesString[i].split(" ");
                if (checkColumnsString.length == MATRIX_SIZE) result[i] = checkColumnsString;
                else throw new ArraySizeException("Неверное количество чисел в строке. Должно быть " + MATRIX_SIZE,i,checkColumnsString.length);
            }
        }
        else throw new ArraySizeException("Неверное количество строк. Должно быть: " + MATRIX_SIZE, checkLinesString.length);
        return result;
    }

    private static int converterArrayInt(String[][] stringMatrix) throws ArrayDataException {
        int sum = 0;
            for (int i = 0; i < stringMatrix.length; i++) {
                for (int j = 0; j < stringMatrix[i].length; j++) {
                    try {
                        sum += Integer.parseInt(stringMatrix[i][j]);
                    } catch (NumberFormatException e) {
                    throw new ArrayDataException("Среди данных оказалось не число!", i, j);
                }
                }
            }

        return sum/2;
    }

}
