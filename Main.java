package geekbrains.jt.homework2;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static String words = "качели степь Буг ананас вазон куб закладка аттракцион степь тумба кошка дипломат степь колдобина кошка" +
            " ушиб коктейль монтировка степь куб кошка контейнер кошка бугор щеколда степь баржа корж кошка киль куб ананас " +
            "конечность планшет степь лесопункт пленка хризантема Буг ананас дипломат коляска кошка степь амулет";

    public static void main(String[] args) {
        String[] wordsArray = words.split(" ");
        ArrayList<String> wordsList = new ArrayList<>();
        HashMap<String, Integer> wordsMap = new HashMap<>();

        for (int i = 0; i < wordsArray.length; i++) {
            if (!wordsList.contains(wordsArray[i])) wordsList.add(wordsArray[i]);
            if (wordsMap.containsKey(wordsArray[i])) wordsMap.replace(wordsArray[i],wordsMap.get(wordsArray[i]) + 1);
            else wordsMap.put(wordsArray[i], 1);
        }

        System.out.println("Список слов:");
        System.out.println(wordsList);
        System.out.println("Количество слов:");
        System.out.println(wordsMap);

        /* -------------------------------------------------------- */

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Ivanov", "+79217029485", "ivanov_only@email.com");
        phoneBook.addContact("Ivanov", "+79052019901", "ivanov_clone@email.net");
        phoneBook.addContact("Petrov", "+79114163721", "petrov_mail@email.org");
        phoneBook.addContact("Sidorov", "+79048111000", "sidorov@email.in");
        phoneBook.addContact("Kozlov", "+79019010109", "superman@email.to");
        phoneBook.addContact("Ivanov", "+79317004359", "ivanov_ivanov@email.us");

        String surnameToSearch = "Johnson";

        String[] searchResult = phoneBook.getContactPhone(surnameToSearch);
        System.out.println("Результат поиска телефонов по фамилии " + surnameToSearch + ":");
        printResult(searchResult);

        searchResult = phoneBook.getContactEmail(surnameToSearch);
        System.out.println("Результат поиска адресов эл. почты по фамилии " + surnameToSearch + ":");
        printResult(searchResult);

    }

    static void printResult(String[] arrayToShow) {
        if (arrayToShow.length == 0) System.out.println("Ничего не найдено!");
        for (int i = 0; i < arrayToShow.length; i++) {
            System.out.println(arrayToShow[i]);
        }
    }



}
