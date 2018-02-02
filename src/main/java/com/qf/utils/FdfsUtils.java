package com.qf.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.IOException;

//封装基于Fastdfs实现文件的上传操作
public class FdfsUtils {
    //创建跟踪服务器的客户端
    private TrackerClient trackerClient;
    //连接跟踪服务器
    private TrackerServer trackerServer;
    //声明存储服务器
    private StorageServer storageServer;
    //创建存储客户端
    private StorageClient1 storageClient;
    private String conf;
    public FdfsUtils(String conf){
        if(conf.startsWith("classpath")){
            conf=conf.replace("classpath:",FdfsUtils.class.getResource("/").getPath());
        }
        try {
            ClientGlobal.init(conf);
            trackerClient=new TrackerClient();
            trackerServer=trackerClient.getConnection();
            storageClient=new StorageClient1(trackerServer,storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    //实现文件上传--传入文件路径
    public String uploadFile(String filepath,String extName) {
        try {
            return  storageClient.upload_file1(filepath,extName,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
    //实现文交所行车--传入文件内容
    public String uploadBytes(byte[] contents,String extName){

        if(extName.lastIndexOf(".")>-1){
            extName=extName.substring(extName.lastIndexOf(".")+1);
        }
        try {
            return storageClient.upload_file1(contents,extName,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

}
