package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0)
            return new int[0];
        int rightValue = inputArray[inputArray.length - 1];
        for(int i = inputArray.length - 1; i > 0; --i)
            inputArray[i] = inputArray[i - 1];
        inputArray[0] = rightValue;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0)
            return 0;
        if(inputArray.length == 1)
            return inputArray[0];
        int firstBiggestValue = Integer.MIN_VALUE;
        int secondBiggestValue = Integer.MIN_VALUE;
        for(int current : inputArray)
        {
            if(current >= firstBiggestValue)
            {
                secondBiggestValue = firstBiggestValue;
                firstBiggestValue = current;
                continue;
            }
            if(current > secondBiggestValue)
                secondBiggestValue = current;
        }
        return firstBiggestValue * secondBiggestValue;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if(input == null || input.length() == 0)
            return 0;
        int counter = 0;
        for(char piece : input.toUpperCase().toCharArray())
        {
            if(piece == 'A' || piece == 'B')
                ++counter;
        }
        return counter * 100 / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if(input == null)
            return false;
        int length = input.length();
        for(int i = 0; i < length / 2; ++i)
        {
            if(input.charAt(i) != input.charAt(length - i - 1))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if(input == null || input.length() == 0)
            return "";
        String building = new String();
        char previous = input.charAt(0);
        int counter = 1;
        for(int i = 1; i < input.length(); ++i)
        {
            if(input.charAt(i) == previous)
                ++counter;
            else
            {
                building += previous + Integer.toString(counter);
                counter = 1;
                previous = input.charAt(i);
            }
        }
        building += previous + Integer.toString(counter);
        return building;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if(one == null || two == null || one.length() == 0 || two.length() == 0)
            return false;
        for(char symbol : one.toCharArray())
        {
            if(two.indexOf(symbol) >= 0)
                two = two.replaceFirst(Character.toString(symbol), "");
            else
                return false;
        }
        return two.length() == 0;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if(s == null || s.length() == 0)
            return false;
        String usingSymbols = new String();
        for(char symbol : s.toCharArray())
        {
            if(usingSymbols.indexOf(symbol) >= 0)
                return false;
            usingSymbols += symbol;
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if(m == null || m[0].length == 0)
            return new int[][]{{}, {}};
        for(int i = 0; i < m.length; ++i)
            for(int j = i; j < m.length; ++j)
            {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if(inputStrings == null || inputStrings.length == 0)
            return "";
        if(separator == null)
            separator = ' ';
        String building = inputStrings[0];
        for(int i = 1; i < inputStrings.length; ++i)
            building += separator + inputStrings[i];
        return building;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if(inputStrings == null || prefix == null)
            return 0;
        int counter = 0;
        for(String input : inputStrings)
        {
            if(input.indexOf(prefix) == 0)
                ++counter;
        }
        return counter;
    }
}
