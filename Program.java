package birthday;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Program {

    static void menu_output() {

        System.out.println("                   МЕНЮ \n"
                + "   1 - Отображение всего списка ДР\n"
                + "   2 - Отображение списка сегодняшних и ближайших ДР\n"
                + "   3 - Добавление записей в список ДР\n"
                + "   4 - Удаление записей из списка ДР\n"
                + "   5 - Редактирование записей в списке ДР\n"
                + "   6 - ВЫХОД\n"
                + "Выберите необходимое действие, введя цифру: ");
    }

    public static String getDate(Date date) {
        SimpleDateFormat readableFormat = new SimpleDateFormat("dd-MM-yyyy");
        return readableFormat.format(date);
    }

    public static void main(String[] args) {
                                                            //  ВВОД ДАТЫ =========================================

        Date date = new Date();
        System.out.println(getDate(date));


/*
        BufferedReader buff_data = new BufferedReader(new InputStreamReader(System.in));

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(" Введите день рождения: ");
            String stringData = buff_data.readLine();
            Date parsedDate = format.parse(stringData);
            System.out.println(parsedDate);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

*/
                //================================================
        ArrayList<friend> friends = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        BufferedReader br = null;            //записывает текст в поток, предварительно буферизируя записываемые символы
        try {
            File file = new File("file_of_birthday.txt");
            if (!file.exists()) file.createNewFile(); // проверяет, существует ли по указанному в конструкторе пути файл



                                                            //===СОЗДАНИЕ ПОТОКА для чтения из файла и вывода на экран

            br = new BufferedReader(new FileReader("file_of_birthday.txt"));
            String line;
            int sch = 0;

            while (true) {                              // загрузка списка из файла в ArrayList построчно до конца файла

                line = br.readLine();
                if ((line == null) & (sch == 0))
                { System.out.println("        Файл пуст... выберите пункт меню"); scanner.nextLine(); break; }
                if (line == null) break;

                String name;
                String day;

                name = line;
                line = br.readLine();
                day = line;

                friends.add(new friend(name, day));
                //friends.get(sch).Name = line;
                //friends.get(sch).day_of_birthday = line;
                sch++;
            }

                                                                //вывод ArrayList на ЭКРАН
            sch = 0;
            System.out.println("\n  СПИСОК ДНЕЙ РОЖДЕНИЯ ");
            System.out.println("------------------");
            for (int i = 0; i < friends.size(); i++) {
                System.out.println("      Юбиляр  № " + (sch + 1) +
                        "\n              ИМЯ:  " + friends.get(i).Name +
                        "\n    дата рождения:  " + friends.get(i).day_of_birthday);
                System.out.println("------------------");
                sch++;
                if (i == (friends.size() - 1)) {
                    break;
                }
            }




            menu_output();


            int vvod;

            do {

                vvod = scanner.nextInt();
                int nomer;

                // =============================================  МЕНЮ 1 - Отображение всего списка ДР  =============================


                if (vvod == 1) {
                                                                  //вывод ArrayList на ЭКРАН
                    sch = 0;
                    System.out.println("\n  СПИСОК ДНЕЙ РОЖДЕНИЯ ");
                    System.out.println("------------------");
                    for (int i = 0; i < friends.size(); i++) {
                       System.out.println("      Юбиляр  № " + (sch+1) +
                                        "\n              ИМЯ:  " + friends.get(i).Name +
                                        "\n    дата рождения:  " + friends.get(i).day_of_birthday);
                       System.out.println("------------------");
                       sch++;
                       if (i == (friends.size()-1)) {

                           menu_output();
                            break;
                       }
                    }

                }

                // =============================================МЕНЮ 2 - Отображение списка сегодняшних и ближайших ДР  ===============
                else if (vvod == 2){

                    sch = 0;
                    System.out.println("\n  СПИСОК ДНЕЙ РОЖДЕНИЯ ");
                    System.out.println("------------------");
                    for (int i = 0; i < friends.size(); i++) {
                        System.out.println("      Юбиляр  № " + (sch + 1) +
                                "\n              ИМЯ:  " + friends.get(i).Name +
                                "\n    дата рождения:  " + friends.get(i).day_of_birthday);
                        System.out.println("------------------");
                        sch++;
                        if (i == (friends.size() - 1)) {
                            break;
                        }
                    }

                }
                // =============================================МЕНЮ 3 - Добавление записей в список ДР  ================================
                else if (vvod == 3) {

                    char vibor;
                    do {

                        System.out.println("   Введите имя: ");
                        String name = scanner.next();
                        System.out.println("   Введите дату рождения: ");
                        String day = scanner.next();

                        friends.add(new friend(name, day));

                        System.out.println("   Для добавления ещё одного профиля нажмите: y ");
                        InputStreamReader scan_for_char = new InputStreamReader(System.in);
                        vibor = (char) scan_for_char.read();
                        if (vibor == 'н') {
                            System.out.println(" н? ок, тоже пойдёт)");
                        }
                    } while ((vibor == 'y')||(vibor == 'у')||(vibor == 'н'));


                    menu_output();

                }


                // =============================================    МЕНЮ 4 - Удаление записей из списка ДР
                else if (vvod == 4){
                    System.out.println("   Для удаления профиля укажите его номер: ");
                    nomer = scanner.nextInt();
                    friends.remove(nomer-1);
                    System.out.println("   Профиль " +nomer+ " удалён ");
                    System.out.println("Выберите необходимое действие, введя цифру: ");
                }


                // =============================================    МЕНЮ 5 - Редактирование записей в списке ДР
                else if (vvod == 5){

                    System.out.println("  Какой номер списка будете редактировать? ");
                    nomer = scanner.nextInt();
                    System.out.println("  Введите новоё имя: ");
                    String new_name = scanner.next();
                    System.out.println("  Введите новую дату рождения: ");
                    String new_data = scanner.next();

                    friends.get(nomer-1).Name= new_name;
                    friends.get(nomer-1).day_of_birthday= new_data;
                    System.out.println("   Профиль " +nomer+ " отредактирован \n");

                    menu_output();
                }
                else if (vvod == 6) {
                                            //  ЗАПИСЬ ArrayList В ФАЙЛ
                    PrintWriter pw = new PrintWriter(file);
                    for (int i = 0; i < friends.size(); i++) {

                        pw.println(friends.get(i).Name);
                        pw.println(friends.get(i).day_of_birthday);
                    }
                    pw.close();
                    break;
                }
                else {System.out.println("Вводите только цифры 1,2,3,4,5,6");}


            } while (vvod != 6);

            // ===================== блок catch      КОНЕЦ ПРОГРАММЫ ====================================
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }

}







