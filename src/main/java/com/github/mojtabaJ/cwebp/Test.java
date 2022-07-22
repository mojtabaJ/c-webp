package com.github.mojtabaJ.cwebp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * created by: Mojtaba Jalambadani
 * project name: c-webp
 * 22/07/2022
 * All Rights Reserved.
 **/
public class Test {
    public static void main(String[] args) {
        File webp = new File("/home/mojtaba/Documents/00test/j8.webp");
        try {
            byte[] fileByte = Files.readAllBytes(webp.toPath());
            System.out.println("IMG FILE: " + fileByte.length);
            byte[] webpByte = WebpConverter.imageByteToWebpByte(fileByte);
            System.out.println("WEBP FILE: " + webpByte.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
