package Classes.Logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LogStash{
    File stash;
    Scanner scanner;
    FileWriter fileWriter;

    public LogStash(){
        try{
            stash = new File("file.log");
            if (stash.createNewFile()){
                set("Created log file");
            }
        } catch (IOException ex){
            System.out.println("Error: " + ex);
        }
    }

    // Ожидаю переменную любого типа данных
    public <T> void set(T data){
        try{
            fileWriter = new FileWriter(stash, true);
            // Беру время и дату
            LocalDateTime now = LocalDateTime.now();
            // Ставлю форматирование на вывод даты и времени как день-месяц-год час:минута:секунда
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            // Применяю форматирование
            String formattedTime = now.format(formatter);
            // Отслеживаю весь путь от мейна до вызова этого метода
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            // Форматирую полученный путь до необходимого вида
            // было: Classes.Local.put(Local.java:16)
            // стало: Classes.Local.put
            // Двойка в stackTrace потому что 0 это getStackTrace а 1 это currentThread с 37 строки
            String from_by = String.format("%s.%s", stackTrace[2].getClassName(), stackTrace[2].getMethodName());
            fileWriter.append(String.format("[%s | %s | %s] %s\n", formattedTime, from_by, data.getClass().getSimpleName(), data));
            fileWriter.close();
        } catch (IOException ex){
            System.out.println("Error: " + ex);
        }
    }

    public void info(){
        try{
            scanner = new Scanner(stash);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException ex){
            System.out.println("Error: " + ex);
        }
    }
}
