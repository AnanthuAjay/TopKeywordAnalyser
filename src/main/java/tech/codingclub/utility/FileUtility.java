package tech.codingclub.utility;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FileUtility {
    public static boolean createFile(String fileNameWithPath){
        File file = new File(fileNameWithPath);
        boolean fileCreated=false;
        try {
             file.createNewFile();

        }catch (IOException e){
            e.printStackTrace();
        }
        return  fileCreated;
    }

    private static ArrayList<String> readAndPrintFile(String fileName) {
        Scanner scanner= null;

        ArrayList<String> strings = new ArrayList<String>();
        try{
            File file = new File(fileName);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (scanner!=null){
                scanner.close();
            }
        }
        return strings;
    }

    public static boolean writeToFile(String fileNAmeWithPath, String content){


       try {
            FileWriter fileWriter = new FileWriter(fileNAmeWithPath);

            fileWriter.append(content);
            fileWriter.close();
        }catch (Exception e){

        }
       return true;

    }

    public  static boolean  appendToFile(String fileName,String content){

        try {
            FileWriter fileWriter = new FileWriter(fileName,true);

            fileWriter.append(content);
            fileWriter.append("\n");
            fileWriter.close();
        }catch (Exception e){

        }
        return true;
    }

    public static ArrayList <String> readFileAsList(String s) {
        ArrayList<String> result = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(s));

            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("This is Ananthu Ajay");
        System.out.println("Running FileUtility at"+ new Date().toString());

        String nameOfNewFile= "E:\\megham\\data\\practice\\file"+"create-file.txt";

        Boolean created = createFile(nameOfNewFile);
        System.out.println("File Created:"+created);

        ArrayList<String> stringArrayList = readAndPrintFile(nameOfNewFile);
        for (String row: stringArrayList){
            System.out.println("Line:"+row);
        }
        System.out.println("No. of Lines:"+stringArrayList.size());

        String nameOfWriteFile= "E:\\megham\\data\\practice\\file"+"write-file.txt";

        boolean wroteToFile = writeToFile(nameOfWriteFile,"This file is generated on Ananthu's System by Java.");
        System.out.println(wroteToFile);

        for (int i=1;i<=100;i++){
            String data =i+"";
            appendToFile(nameOfWriteFile,data);
        }
        System.out.println("Appended file length"+ readAndPrintFile(nameOfWriteFile));
    }



}
