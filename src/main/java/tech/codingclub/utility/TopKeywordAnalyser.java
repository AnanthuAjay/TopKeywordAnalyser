package tech.codingclub.utility;

import java.security.Key;
import java.util.*;
import  java.lang.String;

public class TopKeywordAnalyser implements  Runnable{
    private final  String filePath;

    public TopKeywordAnalyser(String filePath){
        this.filePath =filePath;
    }

    public  void  run(){
        ArrayList<String> KeywordsFileData = FileUtility.readFileAsList(filePath);

        HashMap<String, Integer> keywordCounter= new HashMap<String, Integer>();
        //Read every row
        for (String row:KeywordsFileData){
            String[] keywords = row.split(" ");
            //within each row process each keyword
            for (String keyword: keywords){
                String str = keyword.toLowerCase();

                //if not there in hashmap
                if(! keywordCounter.containsKey(str)){
                    //First time any keyword found
                    keywordCounter.put(str,1);
                }else {
                    Integer value = keywordCounter.get(str);
                    keywordCounter.put(str,value+1);
                }
            }

        }
        ArrayList<KeywordCount> keywordCountArrayList= new ArrayList<KeywordCount>();

        for (String keyword: keywordCounter.keySet()){
            KeywordCount keywordCount= new KeywordCount(keyword,keywordCounter.get(keyword));
            keywordCountArrayList.add(keywordCount);
        }

        Collections.sort(keywordCountArrayList, new Comparator<KeywordCount>() {
            public int compare(KeywordCount o1, KeywordCount o2) {
                if (o2.count== o1.count){
                    return o2.keyword.compareTo(o1.keyword);
                }
                return o2.count-o1.count;
            }
        });

        for (KeywordCount keywordCount:keywordCountArrayList){
            System.out.println(keywordCount.keyword+" "+keywordCount.count);
        }
    }
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(1);
        taskManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyser("E:\\megham\\src\\main\\java\\tech\\codingclub\\utility\\IndianNationalAnthem.txt"));
    }
}
