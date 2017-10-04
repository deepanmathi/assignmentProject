package com.socket;

import java.io.*;
import java.net.*;

public class ReceiveFile{
    static Socket socket = null;
    static int maxsize = 999999999;
    static int byteread;
    static int current = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException{
        byte[] buffer = new byte[maxsize];
        Socket socket = new Socket("localhost", 9099);
        InputStream is = socket.getInputStream();
        DataInputStream din = new DataInputStream(socket.getInputStream());

        BufferedReader dis = new BufferedReader(new InputStreamReader(din));

//        os = new PrintStream(clientSocket.getOutputStream());

        //How can I save the two seperate cases of data in variables on server side?
        System.out.println("dee" +dis.readLine());
        File test = new File("F:\\AtomSetup.exe");
        test.createNewFile();
        FileOutputStream fos = new FileOutputStream(test);
        BufferedOutputStream out = new BufferedOutputStream(fos);
        
        byteread = is.read(buffer, 0, buffer.length);
        current = byteread;

        do{
            byteread = is.read(buffer, 0, buffer.length - current);
            if (byteread >= 0) current += byteread;
        } while (byteread > -1);
        out.write(buffer, 0, current);
        out.flush();

        socket.close();
        fos.close();
        is.close();

    }
}