package com.elabda3.eldaya7een.EncodeAndDecodeString;

import android.util.Log;


/**
 * Created by ebda3-mint on 10/30/17.
 */

public class EncodeDecodeString {

    public static String encodeString(String message){

        String res="";
        for (int i = 0 ;i< message.length() ;i++){

            res+="\\u" + Integer.toHexString(message.charAt(i) | 0x10000).substring(1);

        }

        Log.v("encodedString",res);
        return res;

    }

    public static String decodeString(String message){
        String res = "";

        try {
                String escapeSlash=message.replaceAll("\\\\","");
                String [] escapeU=escapeSlash.split("u");

                for(int i=1 ;i<escapeU.length;i++){

                    int hex=Integer.parseInt(escapeU[i],16);
                    char c=(char) hex;
                    res+=c;
                }

            Log.v("decodedString", res);
        }catch (Exception e){
            e.printStackTrace();
        }



        return res;

    }

}
