
package com.ayigroup.zieglerfrancisco.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Utils {
    
    private BufferedReader reader;

    public Utils(BufferedReader reader) {
        this.reader = reader;
    }
    
    public String stringWhile(String mensaje){
        String ret = "";
        do{
            System.out.println(mensaje);
            try {
                ret = reader.readLine();
            } catch (IOException ex) {
                ret = "";
                System.out.println("Error: "+ex);
            }
        } while(ret.isBlank());
        return ret;
    }
    
    public int intWhile(String mensaje){
        String ret = "";
        int retInt = 0;
        do{
            System.out.println(mensaje);
            try {
                ret = reader.readLine();
                retInt = Integer.parseInt(ret);
            } catch (IOException ex) {
                ret = "";
                retInt = 0;
                System.out.println("Error: "+ex);
            }
        } while(ret.isBlank()||retInt==0);
        return retInt;
    }
    
    public void separador(){
        System.out.println("\n#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#\n");
    }
    
}
