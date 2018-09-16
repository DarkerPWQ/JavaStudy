package com.pwq.mavenT;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:49 2017/11/16
 * @Modified By：
 */
public class DownloadPicture {
    public static void main(String[] args) {
        DownloadPicture downloadPicture = new DownloadPicture();
        ArrayList<String> urlList = new ArrayList<>();
        urlList.add("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2495993728,2346220807&fm=58");
        downloadPicture.downloadPicture(urlList);
    }

    /**
     * 传入要下载的图片的url列表，将url所对应的图片下载到本地
     * @param urlList
     */
    private void downloadPicture(ArrayList<String> urlList) {
        URL url = null;
        int imageNumber = 0;

        for (String urlString : urlList) {
            try {
                url = new URL(urlString);
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                String imageName = imageNumber + ".jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));

                byte[] buffer = new byte[1024];
                int length;

                while ((length = dataInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }

                dataInputStream.close();
                fileOutputStream.close();
                imageNumber++;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 连接mysql数据库，通过查询数据库读取要下载的图片的url列表
     * @return
     */

}
