package com.thirdeyews.droidframework.support;

// created to testingClass http post


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kapil on 17/01/17.
 */
public class ServiceHandler {


        int timeout;
        String dataToSend;

        /*
         * Before starting background thread Show Progress Dialog
         */

        public String getData(String... args)
        {
            BufferedReader reader=null;

            HttpURLConnection urlConnection=null;
            timeout=6000;


            InputStream in = null;
            try {

                URL url=new URL(args[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);
                urlConnection.setInstanceFollowRedirects(false);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                urlConnection.setRequestProperty("charset", "utf-8");
                urlConnection.setUseCaches(false);
                urlConnection.setAllowUserInteraction(false);
                urlConnection.setConnectTimeout(timeout);
                urlConnection.setReadTimeout(timeout);
                String data=args[1];

                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                wr.write(data);
                wr.flush();
                urlConnection.connect();
                int status = urlConnection.getResponseCode();

                switch (status) {
                    case 200:
                    case 201:
                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line+"\n");
                        }
                        br.close();
                        dataToSend=sb.toString();
                        return dataToSend;
                }

            } catch (MalformedURLException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (urlConnection != null) {
                    try {
                        urlConnection.disconnect();
                    } catch (Exception ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            return  null;

        }


    }




