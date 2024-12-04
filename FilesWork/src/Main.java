import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Напишите путь к директории для работы(Пример: c:\\directory): ");
        Path olpPathDirectory = Path.of(sc.nextLine());
        System.out.println();
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать файл");
            System.out.println("2. Создать каталог");
            System.out.println("3. Перейти в подкаталог");
            System.out.println("4. редактировать файл");
            System.out.println("5. Удалить файл / подкаталог");
            System.out.println("6. Перейти в другую директорию");
            System.out.println("7. Копировать файл в другое место");
            System.out.println("8. Узнать в каком ты сейчас директории(путь)");
            System.out.println("9. Закрыть программу");

            String choice = sc.nextLine();
            System.out.println();

            if (choice.equals("1")) {
                System.out.println("Напишите имя файла вместе с расширением: ");
                String fileName = sc.nextLine();
                Path oldFileName = Path.of(olpPathDirectory + "\\" + fileName);
                try {
                    Files.createFile(oldFileName);
                    System.out.println("Файл успешно создан");
                    System.out.println();
                    while (true) {
                        System.out.println("Выберите действие: ");
                        System.out.println("1. Редактировать созданный файл");
                        System.out.println("2. Вернуться в главное меню");

                        String choice1 = sc.nextLine();
                        System.out.println();

                        if (choice1.equals("1")) {
                            ArrayList<String> listForOut = new ArrayList<>();
                            Path newFileName = oldFileName;
                            while (true) {
                                System.out.println("Выберите действие с файлом: ");
                                System.out.println("1. Переименовать файл");
                                System.out.println("2. Записать текст в файл");
                                System.out.println("3. Вернуться назад");
                                String fileChoice = sc.nextLine();
                                System.out.println();
                                if (fileChoice.equals("1")) {
                                    System.out.println("Введите новое имя файла вместе с расширением: ");
                                    String newName = sc.nextLine();
                                    newFileName = Path.of(olpPathDirectory + "\\" + newName);
                                    Files.move(oldFileName, newFileName);
                                    System.out.println("Файл успешно переименован");
                                    System.out.println();
                                }
                                if (fileChoice.equals("2")) {
                                    System.out.println("Вводите символы с клавиатуры пока не будет введено слово \"СТОП\"");
                                    String str = "";
                                    while (true) {
                                        if (str.equals("СТОП")) {
                                            break;
                                        } else {
                                            str = sc.nextLine();
                                            if (str.equals("СТОП")) break;
                                            else listForOut.add(str);
                                        }
                                    }
                                    Files.write(newFileName, listForOut);
                                    System.out.println("Данные были записаны в файл\n");
                                }
                                if (fileChoice.equals("3")) {
                                    break;
                                }
                            }
                        }
                        if (choice1.equals("2")) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Что-то пошло не так");
                }
            }
            if (choice.equals("2")){
                System.out.println("Введите название каталога: ");
                String directoryName = sc.nextLine();
                Path pathDirectory = Path.of(olpPathDirectory + "\\" + directoryName);
                try{
                    Files.createDirectory(pathDirectory);
                    System.out.println("Каталог был успешно создан\n");

                }catch (Exception e){
                    System.out.println("Что-то пошло не так");
                }
            }

            if (choice.equals("3")){
                System.out.println("Введите название подкаталога: ");
                String podDirectoryName = sc.nextLine();
                olpPathDirectory = Path.of(olpPathDirectory + "\\" + podDirectoryName);
                System.out.println("Вы перешли в каталог " + podDirectoryName);
                System.out.println();
            }

            if (choice.equals("4")){
                System.out.println("Напишите название файла с его расширением");
                String oldName = sc.nextLine();
                Path oldFileName = Path.of(olpPathDirectory + "\\" + oldName);
                Path newFileName = oldFileName;
                ArrayList<String> listForOut = new ArrayList<>();
                System.out.println();
                while (true) {
                    System.out.println("Выберите действие с файлом: ");
                    System.out.println("1. Переименовать файл");
                    System.out.println("2. Записать текст в файл");
                    System.out.println("3. Вернуться назад");
                    System.out.println();
                    try {
                        String fileChoice = sc.nextLine();
                        if (fileChoice.equals("1")) {
                            System.out.println("Введите новое имя файла вместе с расширением: ");
                            String newName = sc.nextLine();
                            newFileName = Path.of(olpPathDirectory + "\\" + newName);
                            Files.move(oldFileName, newFileName);
                            System.out.println("Файл успешно переименован");
                            System.out.println();
                        }
                        if (fileChoice.equals("2")) {
                            System.out.println("Вводите символы с клавиатуры пока не будет введено слово \"СТОП\"");
                            String str = "";
                            while (true) {
                                if (str.equals("СТОП")) {
                                    break;
                                } else {
                                    str = sc.nextLine();
                                    if (str.equals("СТОП")) break;
                                    else listForOut.add(str);
                                }
                            }
                            Files.write(newFileName, listForOut);
                            System.out.println("Данные были записаны в файл\n");
                        }
                        if (fileChoice.equals("3")) {
                            break;
                        }
                    }catch (Exception e){
                        System.out.println("Что-то пошло не так");
                    }
                }
            }

            if (choice.equals("5")) {
                while (true) {
                    System.out.println("Выберите действие: ");
                    System.out.println("1. Удалить файл");
                    System.out.println("2. Удалить подкаталог");
                    System.out.println("3. Вернуться назад");
                    String choiceDelete = sc.nextLine();
                    System.out.println();
                    try {
                        if (choiceDelete.equals("1")) {
                            System.out.println("Введите название файла с его расширением: ");
                            String del = sc.nextLine();
                            Path deletePath = Path.of(olpPathDirectory + "\\" + del);
                            Files.delete(deletePath);
                            System.out.println("Файл успешно удалён\n");
                        }
                        if (choiceDelete.equals("2")) {
                            System.out.println("Введите название подкаталога: ");
                            String del = sc.nextLine();
                            Path deletePath = Path.of(olpPathDirectory + "\\" + del);
                            Files.delete(deletePath);
                            System.out.println("Подкаталог успешно удалён\n");
                        }
                        if (choiceDelete.equals("3")) {
                            System.out.println();
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Что-то пошло не так");
                    }
                }
            }

            if (choice.equals("6")){
                System.out.println("Напишите путь к новому директорию: ");
                olpPathDirectory = Path.of(sc.nextLine());
                System.out.println();
            }

            if (choice.equals("7")){
                System.out.println("Напишите название файла с его расширением из нынешнего директория: ");
                String now = sc.nextLine();
                Path oldPathFile = Path.of(olpPathDirectory + "\\" + now);
                System.out.println("Напишите путь к директорию для копирования: ");
                String after = sc.nextLine();
                Path newPathFile = Path.of(after + "\\" + now);
                try{
                    Files.copy(oldPathFile, newPathFile);
                    System.out.println("Копирование завершено\n");
                }catch (Exception e){
                    System.out.println("Что-то пошло не так");
                }
            }

            if (choice.equals("8")){
                System.out.println(olpPathDirectory);
                System.out.println();
            }

            if (choice.equals("9")){
                System.out.println("Программа закрывается");
                break;
            }


        }
    }
}