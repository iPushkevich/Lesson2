package by.epamtc.topic09.pushkevich;


import java.util.*;

public class Main {
    public static void main(String[] args) {

    }


    /* Разделяет четные и нечетные символы по разным строкам
    1й элемент массива - четные символы
    2й - нечетные
    */
    private static String[] linesWithOddAndEvenChars(String line) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        String[] result = new String[2];

        for (int i = 0; i < line.length(); i++) {
            if (i % 2 == 0) odd.append(line.charAt(i));
            else even.append(line.charAt(i));
        }

        result[0] = odd.toString();
        result[1] = even.toString();

        return result;
    }

    // Выводит процентное соотношение строчных и прописных букв
    private static void printPercentOfUpperAndLowerCase(String line) {
        int upperCase = 0;
        int lowerCase = 0;
        double countOfPercentByOneChar = (double) 100 / line.length();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') upperCase++;
            if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') lowerCase++;
        }

        System.out.println("The line contains " + countOfPercentByOneChar * upperCase + "% of upperCase chars");
        System.out.println("And " + countOfPercentByOneChar * lowerCase + "% of lowerCase chars");
    }

    // Удаляет повторяющиеся символы
    private static String removeSameChars(String line) {
        StringBuilder lineWithoutSameChars = new StringBuilder();

//        line.chars().distinct().forEach(c -> sb.append((char) c));

        Set<Character> uniqueChars = new LinkedHashSet<>();

        for (int i = 0; i < line.length(); i++) {
            uniqueChars.add(line.charAt(i));
        }
        for (Character c : uniqueChars) {
            lineWithoutSameChars.append(c);
        }

        return String.valueOf(lineWithoutSameChars);
    }

    // Возвращает частоту встречаемости символа в строке
    private static int getCountOfCharInLine(String line, char c) {
        int countOfCharInLine = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == c) countOfCharInLine++;
        }

        return countOfCharInLine;
    }

    // Возвращает перевернутую строку
    private static String reversedLine(String line) {
        StringBuilder resultLine = new StringBuilder(line);

        resultLine.reverse();

        return String.valueOf(resultLine);
    }

    // Всталяет подстроку в строку
    private static String insertSubLine(String line, int position, String subLine) {

        StringBuilder resultLine = new StringBuilder(line);

        resultLine.insert(position, subLine);

        return String.valueOf(resultLine);
    }

    // Удаляет подстроку из строки по индексу
    private static String removeSubLine(String line, int start, int end) {
        StringBuilder resultLine = new StringBuilder(line);

        resultLine.delete(start, end);

        return String.valueOf(resultLine);

    }

    // Возвращает чать строки по индексу
    private static String getSubLine(String line, int start, int end) {
        return line.substring(start, end);
    }

    // Возвращает длину строки
    private static int getLineLength(String line) {
        return line.length();
    }

    // Определяет количетво вхождений подстроки в строку
    private static int getCountOfSubLineInLine(String line, String subLine) {
        int count = 0;
        int length = 0; // Длина совпадения символов
        char[] chars = subLine.toCharArray();

        for (int i = 0; i <= line.length() - subLine.length(); i++) {
            for (char aChar : chars) {
                if (line.charAt(i) == aChar) {
                    length++;
                    i++;
                } else {
                    length = 0;
                    break;
                }
            }
            if (length == subLine.length()) {
                count++;
                length = 0;
                i--;
            }
        }
        return count;
    }

    // Возвращает строку с обрятным порядком слов
    private static String getReverseWordsOfLine(String line) {
        String[] strings = line.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            result.append(strings[i]).append(" ");
        }
        return String.valueOf(result);
    }

    // Заменяет пробелы на *
    private static String changeSpacesToStar(String line) {
        return line.replace(" ", "*");
    }

    // Заменяет 'a' на 'b' в самых длинных словах
    private static String replaceSymbolsInLongestWord(String line) {
        String[] onlyWords = line.split("[\\p{Punct}\\s]+"); // Слова без знаков препинания
        List<Integer> longestWordsIndex = new ArrayList<>(); // Индксы самых длинных слов
        int length = 0; // Длина самого длинного слова
        StringBuilder finalLine = new StringBuilder();

        for (int i = 1; i < onlyWords.length; i++) {
            if (onlyWords[i].length() >= onlyWords[i - 1].length()) length = onlyWords[i].length();
        }
        // Если имеется несколько слов одинаковой максимальной длины
        for (int i = 0; i < onlyWords.length; i++) {
            if (onlyWords[i].length() == length) longestWordsIndex.add(i);
        }

        String[] words = line.split(" ");

        //В словах с максимальной длиной меняем символы
        for (Integer aLongestWordsIndex : longestWordsIndex) {
            words[aLongestWordsIndex] = words[aLongestWordsIndex].replace('a', 'b');
        }

        for (String s : words) {
            finalLine.append(s).append(" ");
        }

        return String.valueOf(finalLine);
    }

    // Возвращает длинну самого короткого слова
    private static int shortestWordLength(String line) {
        String punctuationSplitter = "[\\p{Punct}\\s]+";

        List<String> words = new ArrayList<>(Arrays.asList(line.split(punctuationSplitter)));

        words.sort(String::compareToIgnoreCase);

        return words.get(0).length();
    }

    // Возвращает количество слов в строке
    private static int countOfWordsInLine(String line) {
        String punctuationSplitter = "[\\p{Punct}\\s]+";

        List<String> words = new ArrayList<>(Arrays.asList(line.split(punctuationSplitter)));

        return words.size();
    }

    // Возвращает строку с замененными местами словами по их индексам
    private static String lineWithReplacedWords(String line, int firstWord, int secondWord) {
        String[] s = line.split(" ");
        StringBuilder finalLine = new StringBuilder();

        String tmp = s[firstWord - 1];
        s[firstWord - 1] = s[secondWord - 1];
        s[secondWord - 1] = tmp;

        for (String value : s) {
            finalLine.append(value).append(" ");
        }

        return String.valueOf(finalLine);
    }

    // Удаляет последнее слово в строке
    private static String removeLastWordInLine(String line) {
        return line.substring(0, line.lastIndexOf(" "));
    }

    // Добавляет пробел в строку по индексу
    private static String addSpaceInLine(String line, int position) {
        StringBuilder resultLine = new StringBuilder(line);

        resultLine.insert(position, ' ');

        return String.valueOf(resultLine);
    }

    // Проверяет, является ли строка полиндромом
    private static boolean isLinePalindrome(String line) {
        boolean isPalindrome = true;
        line = line.toLowerCase();

        for (int i = 0; i < line.length() / 2; i++) {
            if (line.charAt(i) != line.charAt(line.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    /*
        Замена подстроки в строке
        При отсутсвии целевой подстроки вовращает -1
     */
    private static String replaceSubLineInLine(String line, String target, String newSubLine) {
        String result;

        if (line.contains(target)) {
            result = line.replace(target, newSubLine);
            return result;
        }

        else return String.valueOf(-1);

    }

    // Сложение очень больших целых числел
    private static String getSumOfBigNumbers(String firstNumb, String secondNumb) {
        StringBuilder result = new StringBuilder();
        int index = 0; // Индекс для цикла
        int dozens = 0; // Десятки после сложения
        int countOfZero; // Количество 0 для выравнивания длины строк
        StringBuilder shortestLine = new StringBuilder(); // Кратчайшая строка

        // Находим короткую строку и количество 0 для выравнивания
        if (firstNumb.length() != secondNumb.length()) {
            if (firstNumb.length() > secondNumb.length()) {
                shortestLine.append(secondNumb);
                countOfZero = firstNumb.length() - secondNumb.length();
            } else {
                shortestLine.append(firstNumb);
                countOfZero = secondNumb.length() - firstNumb.length();
            }

            // Заполняем строку 0 на разницу длин
            for (int i = 0; i < countOfZero; i++) {
                shortestLine.insert(0, '0');
            }

            // Присваиваем это значение кратчайшей входной строке
            if (firstNumb.length() > secondNumb.length()) secondNumb = shortestLine.toString();
            else firstNumb = shortestLine.toString();
        }
        // Если длина строк равна - берем любую
        else shortestLine.append(firstNumb);

        // Переворачиваем строки для сложения "в столбик"
        firstNumb = String.valueOf(new StringBuilder(firstNumb).reverse());
        secondNumb = String.valueOf(new StringBuilder(secondNumb).reverse());

        // Складываем символы
        while (index < shortestLine.length()) {
            int a = Integer.parseInt((String.valueOf(firstNumb.charAt(index))));
            int b = Integer.parseInt((String.valueOf(secondNumb.charAt(index))));
            int sum;

            if (dozens == 0) sum = a + b;
            else {
                sum = ++a + b;
                dozens = 0;
            }
            result.append(sum % 10);

            if (sum > 9) {
                dozens++;
            }
            index++;
        }

        // Если после окончания цикла остались десятки, добавляем единицу к результату
        if (dozens == 1) result.append("1");

        return result.reverse().toString();
    }

    // Удаляет слова заданной длины
    private static String removeWordsByLength(String line, int length) {
        String punctuationSplitter = "[\\p{Punct}\\s]+";
        List<String> onlyWords = new ArrayList<>(Arrays.asList(line.split(punctuationSplitter)));
        StringBuilder finalLine = new StringBuilder();

        for (String onlyWord : onlyWords) {
            if (onlyWord.length() != length)
                finalLine.append(onlyWord).append(" ");
        }

        return String.valueOf(finalLine);
    }

    // Удаляет лишние пробелы
    private static String removeExtraSpaces(String line) {
        return line.replaceAll("\\s+", " ");
    }

    // Возвращает слова из строки
    private static String[] getWordsFromLine(String line) {
        String punctuationSplitter = "[\\p{Punct}\\s]+";

        return line.split(punctuationSplitter);
    }

}




