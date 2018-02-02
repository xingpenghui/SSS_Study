package com.qf.fdfs;

import com.qf.utils.FdfsUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.*;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

//基于fdfs实现文件上传
public class Fdfs_Main {
    public static void main(String[] args) throws IOException, MyException {
//        String conf="classpath:fdfs_client.conf";
//        System.out.println(Fdfs_Main.class.getResource("/").getPath());
//        conf=conf.replace("classpath:",Fdfs_Main.class.getResource("/").getPath());
//        File file=new File(conf);
//        System.out.println(file.getAbsolutePath());
        String url="http://10.0.127.98/";
        System.out.println(url+new FdfsUtils("classpath:fdfs_client.conf").
                uploadFile("SSS_Quartz/pom.xml","xml"));
    }

    private static void test1() throws IOException, MyException {
        //初始化配置文件，加载
        ClientGlobal.init("SSS_Quartz/src/main/resources/fdfs_client.conf");
        //创建跟踪服务器的客户端
        TrackerClient trackerClient=new TrackerClient();
        //连接跟踪服务器
        TrackerServer trackerServer=trackerClient.getConnection();
        //声明存储服务器
        StorageServer storageServer=null;
        //创建存储客户端
        StorageClient storageClient=new StorageClient(trackerServer,storageServer);
        //上传文件
        String[] strs=storageClient.upload_file("SSS_Quartz/课堂笔记.txt","txt",null);
        System.out.println("上传结果："+ Arrays.toString(strs));
    }
}
