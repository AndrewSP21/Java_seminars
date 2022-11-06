import java.util.*;

public class equipment_ {
    public static String equation = "?4 + ?5 = 69";
    static int [] array1d;
    static ArrayList<Integer> idxlist = new ArrayList<Integer>();
    static ArrayList<char []> equation2 = new ArrayList<char []>();

    public static void main(String[] args) {
        equation = equation.replace(" ", ""); // Убираем пробелы
        char [] eqChar = equation.toCharArray(); //Массив символов уравнения
        idxlist = idxQuestionMark(eqChar);// Массив индексов знаков вопроса
        combine(9, idxlist.size()); // наполняем ans вариантами возможных значений на всех местах "?"
        equation2 = allEquations(eqChar); // Уравнения со всеми возможными валидными значениями переменных на местах "?"

        printResult(equation2);

    }

    public static void printResult(ArrayList<char []> equation2){
        if (equation2.size() > 0) {
            for (int i = 0; i < equation2.size(); i++) {
                System.out.println(equation2.get(i));
            }
        } else System.out.println("Нет решения");
    }
    public static ArrayList<Integer> idxQuestionMark(char [] eqChar){
        // Создаем массив индексов знаков вопроса
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < eqChar.length; i++) {
            if (eqChar[i] == '?'){
                list.add(i);
            }
        }
        return list;
    }

    public static ArrayList<char []> allEquations(char [] eqChar){
        ArrayList<char []> equations = new ArrayList<char []>();
        for (int i = 0; i < ans.size(); i++) {
            char[] eqChar2 = eqChar.clone(); //Копируем образец
            for (int j = 0; j < ans.get(i).size(); j++) {
                eqChar2[idxlist.get(j)] = String.valueOf(ans.get(i).get(j)).charAt(0); //Заменем "?" возможными значениями
            }
            String miniEquation = new String(eqChar2); //Переводим массив в строку
            miniEquation = miniEquation.replace("+", "=");
            String [] arrMinEq = miniEquation.split("="); //Строку в массив членов уравнения
            if (Integer.parseInt(arrMinEq[0]) + Integer.parseInt(arrMinEq[1]) == Integer.parseInt(arrMinEq[2])) {
                equations.add(eqChar2);
            }
        }
        return equations;
    }

    static List<List<Integer>> ans; // переменная класса - массив возможных вариантов чисел

    public static void combine(int n, int k) {
        ans = new ArrayList<>();
        helper(new ArrayList<>(), n, k);
        return;
    }

    private static void helper(List<Integer> comb, int n, int k) {
        // Готовим все возможные комбинации из выборки чисел от 0 до n учитывая что можно взять только k чисел.
        if (comb.size() == k) { // Если длина комбинации чисел = k, то добавляем в массив ans
            ans.add(new ArrayList<>(comb));
            return;
        }

        for (int i = 0; i <= n; i++) {
            comb.add(i); // Добавляем числа в комбинацию
            helper(comb, n, k); // Либо продолжаем формировать комбинацию чисел, либо добавляем готовую комбинацию в массив
            comb.remove(comb.size() - 1); // Удаляем последнюю цифру из комбинации, чтобы попробовать следующую
        }
    }
}

