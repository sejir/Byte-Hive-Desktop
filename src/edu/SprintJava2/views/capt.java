/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava2.views;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
/**
 *
 * @author Sejir
 */
public class capt {
      public static void main(String[] args) {
        try {
            // @param {String} $token - String containing your API Key 
            // @param {String} $url - Encoded URI string container the URI you're targeting 
            // @param {Integer} $width - Integer indicating the width of your target render
            // @param {Integer} $height - Integer indicating the height of your target render
            // @param {String} $output - String specifying the output format, "image" or "json"
            String token = "Your API Key";
            String url = URLEncoder.encode("https://google.com");
            int width = 1920;
            int height = 1080;
            String output = "image";

            // Construct the query params and URL
            String query = "https://shot.screenshotapi.net/screenshot";
            query += String.format("?token=%s&url=%s&width=%d&height=%d&output=%s",
                    token, url, width, height, output);
            URL apiUrl = new URL(query);

            OutputStream outputStream;
            try ( // Call the API and save the screenshot
                    InputStream inputStream = apiUrl.openStream();) {
                
                outputStream = new FileOutputStream("./screenshot.png");
                // inputStream.transferTo(outputStream);
               
            }
            outputStream.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}

