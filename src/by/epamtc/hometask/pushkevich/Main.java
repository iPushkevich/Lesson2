package by.epamtc.hometask.pushkevich;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String line = "Learn Java, Be Happy!";

    }

    // Разделяет четные и нечетные символы по разным строкам
    private static String[] getOddAndEvenChars(String line) {
        String odd = "";
        String even = "";
        String[] result = new String[2];

        for (int i = 0; i < line.length(); i++) {
            if (i % 2 == 0) odd += line.charAt(i);
            else even += line.charAt(i);
        }

        result[0] = odd;
        result[1] = even;

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
        StringBuilder sb = new StringBuilder();

//        line.chars().distinct().forEach(c -> sb.append((char) c));

        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < line.length(); i++) {
            set.add(line.charAt(i));
        }
        for (Character c : set) {
            sb.append(c);
        }

        return String.valueOf(sb);
    }

    // Возвращает частоту встречаемости символа в строке
    private static int getCountOfCharInLine(String line, char c) {
        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == c) count++;
        }

        return count;
    }

    // Возвращает перевернутую строку
    private static String getReversedLine(String line) {
        StringBuilder sb = new StringBuilder(line);
        sb.reverse();

        return String.valueOf(sb);
    }

    // Всталяет подстроку в строку
    private static String insertSubLine(String line, int position, String subLine) {

        StringBuilder sb = new StringBuilder(line);
        sb.insert(position, subLine);

        return String.valueOf(sb);
    }

    // Удаляет подстроку из строки
    private static String removeSubLine(String line, int start, int end) {
        StringBuilder sb = new StringBuilder(line);
        sb.delete(start, end);

        return String.valueOf(sb);

    }

    // Возвращает чать строки
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
            for (int j = 0; j < chars.length; j++) {
                if (line.charAt(i) == chars[j]) {
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
        String[] strings = line.split("[\\p{Punct}\\s]+");
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
        List<Integer> longestWord = new ArrayList<>(); // Индксы самых длинных слов
        int length = 0; // Длина самого длинного слова
        StringBuilder finalLine = new StringBuilder();

        for (int i = 1; i < onlyWords.length; i++) {
            if (onlyWords[i].length() >= onlyWords[i - 1].length()) length = onlyWords[i].length();
        }
        // Если имеется несколько слов одинаковой максимальной длины
        for (int i = 0; i < onlyWords.length; i++) {
            if (onlyWords[i].length() == length) longestWord.add(i);
        }

        String[] words = line.split(" ");
        //В словах с максимальной длиной меняем символы
        for (int i = 0; i < longestWord.size(); i++) {
            words[longestWord.get(i)] = words[longestWord.get(i)].replace('a', 'b');
        }
        for (String s : words) {
            finalLine.append(s).append(" ");
        }
        return String.valueOf(finalLine);
    }

    // Возвращает длинну самого короткого слова
    private static int getShortestWordLength(String line) {
        List<String> s = new ArrayList<>(Arrays.asList(line.split("[\\p{Punct}\\s]+")));
        s.sort(String::compareToIgnoreCase);

        return s.get(0).length();
    }

    // Возвращает количество слов в строке
    private static int getCountOfWordsInLine(String line) {
        List<String> s = new ArrayList<>(Arrays.asList(line.split("[\\p{Punct}\\s]+")));
        return s.size();
    }

    // Возвращает строку с замененными местами словами
    private static String getLineWithReplacedWords(String line, int firstWord, int secondWord) {
        String[] s = line.split(" ");
        StringBuilder sb = new StringBuilder();

        String tmp = s[firstWord - 1];
        s[firstWord - 1] = s[secondWord - 1];
        s[secondWord - 1] = tmp;


        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]).append(" ");
        }
        return String.valueOf(sb);
    }

    // Удаляет последнее слово в строке
    private static String removeLastWordInLine(String line) {
        return line.substring(0, line.lastIndexOf(" "));
    }

    // Добавляет пробел в строку по индексу
    private static String addSpaceInLine(String line, int position) {
        StringBuilder sb = new StringBuilder(line);
        sb.insert(position, ' ');

        return String.valueOf(sb);
    }

    // Проверяет, является ли строка полиндромом
    private static boolean printIsLinePalindrome(String line) {
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

    // Замена подстроки в строке
    private static String replaceSubLineInLine(String line, String target, String newSubLine) {
        String result = "";
        if (line.contains(target)) {

        }
        return result;
    }

    // Сложение очень больших целых числе
    private static String getSumOfBigNumbers(long a, long b) {
        String result = "";
        return result;
    }

    // Удаляет слова заданной длины
    private static String removeWordByLength(String line, int length) {
        List<String> onlyWords = new ArrayList<>(Arrays.asList(line.split("[\\p{Punct}\\s]+")));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < onlyWords.size(); i++) {
            if (onlyWords.get(i).length() != length)
                sb.append(onlyWords.get(i)).append(" ");
        }

        return String.valueOf(sb);
    }

    // Удаляет лишние пробелы
    private static String removeExtraSpaces(String line){
        return line.replaceAll("\\s+", " ");
    }

    // Возвращает слова из строки
    private static String[] getWordsFromLine(String line){
        return line.split("[\\p{Punct}\\s]+");
    }


}




