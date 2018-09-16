package com.pwq.mavenT;

import java.util.HashMap;
import java.util.List;

/**
 * Created by BF100500 on 2017/6/28.
 */
public class CacheContainer {
    private HashMap<String,String> contentStringMap = new HashMap<>();
    private HashMap<String,List<String>> contentStringsMap  = new HashMap();
    private HashMap<String,Student> contentStudentMap = new HashMap<>();
    private HashMap<String,List<Student>> contentStudentsMap = new HashMap<>();
    public void putString(String key,String value){contentStringMap.put(key,value);}
    public String getString(String key){return contentStringMap.get(key);}
    public void putStrings(String key,List<String> Strings){contentStringsMap.put(key,Strings);}
    public List<String> getStrings(String key){return contentStringsMap.get(key);}
    public void putStudent(String key,Student student){contentStudentMap.put(key,student);}



}
