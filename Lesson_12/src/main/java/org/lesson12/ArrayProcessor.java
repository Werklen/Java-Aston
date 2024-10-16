package org.lesson12;

class ArrayProcessor {

    public static boolean isArray4x4(String[][] array) {
        if (array.length != 4) {
            return false;
        }
        for (String[] row : array) {
            if (row.length != 4) {
                return false;
            }
        }
        return true;
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (!isArray4x4(array)) {
            throw new MyArraySizeException("Размер массива должен быть 4x4.");
        }

        int sum = 0;

        // Проход по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }

        return sum;
    }
}
