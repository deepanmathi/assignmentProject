package com.socket;

import java.io.*;
import java.net.*;

public class sendfile{
    static ServerSocket receiver = null;
    static OutputStream out = null;
    static Socket socket = null;
    static File myFile = new File("E:\\youtube_hd_setup.exe");
    /*static int count;*/
    static byte[] buffer = new byte[(int) myFile.length()];
    public static void main(String[] args) throws IOException{
        receiver = new ServerSocket(9099);
        socket = receiver.accept();//listens for connection in 9099
        System.out.println("Accepted connection from : " + socket);
        FileInputStream fis = new FileInputStream(myFile);
        BufferedInputStream in = new BufferedInputStream(fis);
        in.read(buffer,0,buffer.length);
        out = socket.getOutputStream();
        System.out.println("Sending files");
        out.write(buffer,0, buffer.length);
        out.flush();
        /*while ((count = in.read(buffer)) > 0){
            out.write(buffer,0,count);
            out.flush();
        }*/
        out.close();
        in.close();
        socket.close();
        System.out.println("Finished sending");



    }

}