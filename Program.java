
package edu.lfa.fileautomation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Anuz
 */
public class Program {


    public static void main(String[] args) {
        String path = "D:/College Stuff/Leapfrog Tasks/generated/";
        String fileName = "D:/College Stuff/Leapfrog Tasks/ClassName.txt";
        try{
            BufferedReader bReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while((line = bReader.readLine()) != null) {
                String[] tokens = line.split(";");
                FileWriter fWriter = new FileWriter(path + tokens[0] + ".java");
                
                //class part
                fWriter.write("public class " + tokens[0] + "{\r\n");
                String[] attributes = tokens[1].split("%");
                
                for (String attr : attributes) {
                    String[] types = attr.split(":");
                    
                    //variable declaration part
                    fWriter.write("     private " + types[1] + " " + types[0] + ";\r\n");
                }
                
                fWriter.write("\r\n");
                //constructor part
                fWriter.write("     public " + tokens[0] + "()" + " " + "{     " + "//this is constructor\r\n");
                fWriter.write("     }" + "\r\n");
                fWriter.write("\r\n");
                
                for (String attr : attributes) {
                    String[] types = attr.split(":");
                    for (String type : types) {
                        String[] vars = type.split(",");
                        
                        for (String var : vars) {
                            
                        //setter part
                        fWriter.write("     public void set" + var.substring(0,1).toUpperCase() + var.substring(1) + "(" + types[1] + " " + var + ")" + " " + "{   " + "    //this is setter\r\n");
                        fWriter.write("           this." + var + " = " + var + ";");
                        fWriter.write("\r\n     }" + "\r\n");
                        fWriter.write("\r\n");
                        
                        
                        //getter part
                        fWriter.write("     public " + types[1] + " get" + var + "() {" + "    //this is getter\r\n");
                        
                        fWriter.write("\r\n     }" + "\r\n");
                        fWriter.write("\r\n");
                        }
                    }
                    
                }
                                    
                    
                    
                fWriter.write("\r\n}");
                fWriter.close();
            }
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        
    }
    
}
