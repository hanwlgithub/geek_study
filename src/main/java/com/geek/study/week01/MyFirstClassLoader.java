package com.geek.study.week01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class MyFirstClassLoader extends ClassLoader{

    public static String path = System.getProperty("user.dir") + "\\src\\main\\resources\\class\\";

    public static void main(String[] args) throws Exception {

        File file = new File(path);
        String[] list = file.list();
        if (list.length > 0){
            MyFirstClassLoader myFirstClassLoader = new MyFirstClassLoader();
            for (int i = 0; i < list.length; i++) {
                Class<?> aClass = myFirstClassLoader.findClass(list[i]);
                Object o = aClass.newInstance();
                Method[] declaredMethods = aClass.getDeclaredMethods();
                if (declaredMethods.length > 0){
                    for (int j = 0; j < declaredMethods.length; j++) {
                        declaredMethods[j].invoke(o);
                    }
                }
                System.out.println(o.getClass());
                System.out.println(o.getClass().getClassLoader());
                System.out.println("------------------");
            }
        }
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        WritableByteChannel wbc = null;
        ByteArrayOutputStream baos = null;
        FileChannel fileChannel = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path + name);
            fileChannel = fileInputStream.getChannel();
            baos = new ByteArrayOutputStream();
            wbc = Channels.newChannel(baos);
            ByteBuffer by = ByteBuffer.allocate(1024);
            while (true)
            {
                int i = fileChannel.read(by);
                if (i == 0 || i == -1)
                    break;
                by.flip();
                wbc.write(by);
                by.clear();
            }
            fileChannel.close();
            byte[] bytes = baos.toByteArray();
            if ("xlass".equals(name.substring(name.lastIndexOf(".")+1))){
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte) (255 - bytes[i]);
                }
            }
            return defineClass(name.substring(0, name.lastIndexOf(".")), bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wbc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
