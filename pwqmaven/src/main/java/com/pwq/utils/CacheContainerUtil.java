package com.pwq.utils;

import com.gargoylesoftware.htmlunit.Page;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

/**
 * @author Yuyangjun on 2017/11/24 下午5:41
 */
public class CacheContainerUtil {


    /**
     * 文件写入,文件若存在则覆盖
     * @param html      记录的信息
     * @param filename  文件名
     * @param directory 文件夹路径
     * @return
     */
    private static void WriteHTMLFile(String html, String filename, String directory) {
        try {
            String path = directory + "\\" + filename + ".html";
            path = opeFileSeparatorStr(path);

            File file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            file.createNewFile();

            // 向文件写入对象写入信息
            FileWriter fileWriter = new FileWriter(file);
            // 写文件
            fileWriter.write(html);
            // 关闭
            fileWriter.close();

        } catch (Exception e) {

        }
    }

    /**
     * 处理由于系统不同导致文件分隔符差异
     * @param patternStr
     * @return
     */
    private static String opeFileSeparatorStr(String patternStr){
        if(StringUtils.isNotBlank(patternStr)){
            String fileSeparator = System.getProperties().getProperty("file.separator");
            String osName = System.getProperties().getProperty("os.name");
            if(!StringUtils.contains(osName, "Window")){
                patternStr = patternStr.replace("\\", fileSeparator);
            }
        }
        return  patternStr;
    }
}
