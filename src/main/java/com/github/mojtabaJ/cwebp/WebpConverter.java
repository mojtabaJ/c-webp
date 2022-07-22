package com.github.mojtabaJ.cwebp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import org.apache.commons.io.FileUtils;
/**
 * created by: Mojtaba Jalambadani
 * project name: c-webp
 * 21/07/2022
 * All Rights Reserved.
 **/
public class WebpConverter {

    public static byte[] imageByteToWebpByte(byte[] imageByte){
        return imageByteToWebpByte(imageByte, 75);
    }


    public static byte[] imageByteToWebpByte(byte[] imageByte, int quality){
        try {

            Path tempDir = Files.createTempDirectory("tmpDirPrefix");
            String time = "" + new Date().getTime();
            String input =  tempDir.toString() + "/img_"+ time + ".png";
            String output = tempDir.toString() + "/img_"+ time + ".webp";

            FileOutputStream fos = new FileOutputStream(input);
            try {
                fos.write(imageByte);
            }
            finally {
                fos.close();
            }

            return getWebpBytes(input, quality, tempDir, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] imageFileToWebpByte(String imageFilePath, int quality) {
        try {

            Path tempDir = Files.createTempDirectory("tmpDirPrefix");
            String time = "" + new Date().getTime();
            String output = tempDir.toString() + "/img_"+ time + ".webp";

            return getWebpBytes(imageFilePath, quality, tempDir, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] imageFileToWebpByte(File imageFile, int quality) {
        return imageFileToWebpByte(imageFile.getAbsolutePath(), quality);
    }


    public static File imageByteToWebpFile(byte[] imageByte, String webpPathFile){
        return imageByteToWebpFile(imageByte, webpPathFile,75);
    }


    public static File imageByteToWebpFile(byte[] imageByte, String webpPathFile, int quality){
        try {

            Path tempDir = Files.createTempDirectory("tmpDirPrefix");
            String time = "" + new Date().getTime();
            String input =  tempDir.toString() + "/img_"+ time + ".png";

            FileOutputStream fos = new FileOutputStream(input);
            try {
                fos.write(imageByte);
            }
            finally {
                fos.close();
            }

            return getWebpFile(input, quality, tempDir, webpPathFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static File imageFileToWebpFile(String imageFilePath, String webpPathFile, int quality){
        try {
            return getWebpFile(imageFilePath, quality, null, webpPathFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static File imageFileToWebpFile(File imageFile, String webpPathFile, int quality){
        return imageFileToWebpFile(imageFile.getAbsolutePath(), webpPathFile, quality);
    }


    private static byte[] getWebpBytes(String imageFilePath, int quality, Path tempDir, String output) throws IOException {
        CWebp cwebp = new CWebp().quality(quality).input(imageFilePath).output(output);
        cwebp.execute();

        File webp = new File(output);
        byte[] webpByte = Files.readAllBytes(webp.toPath());
        FileUtils.deleteDirectory(tempDir.toFile());

        return webpByte;
    }

    private static File getWebpFile(String imageFilePath, int quality, Path tempDir, String output) throws IOException {
        CWebp cwebp = new CWebp().quality(quality).input(imageFilePath).output(output);
        cwebp.execute();

        File webp = new File(output);
        if(tempDir != null){
            FileUtils.deleteDirectory(tempDir.toFile());
        }

        return webp;
    }
}
