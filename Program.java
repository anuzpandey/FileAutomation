
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
                    fWriter.write("\tprivate " + types[1] + " " + types[0] + ";\r\n");
                }
                
                fWriter.write("\r\n");
                //constructor part
                fWriter.write("\tpublic " + tokens[0] + "()" + " " + "{" + "\t\t//this is constructor\r\n");
                fWriter.write("\t}" + "\r\n");
                fWriter.write("\r\n");
                
                for (String attr : attributes) {
                    String[] types = attr.split(":");
                    for (String type : types) {
                        String[] vars = type.split(",");
                        
                        for (String var : vars) {
                            
                        //setter part
                        fWriter.write("\tpublic void set" + var.substring(0,1).toUpperCase() + var.substring(1) + "(" + types[1] + " " + var + ")" + " " + "{" + "\t\t//this is setter\r\n");
                        fWriter.write("\t\tthis." + var + " = " + var + ";");
                        fWriter.write("\r\n\t}" + "\r\n");
                        fWriter.write("\r\n");
                        
                        
                        //getter part
                        fWriter.write("\tpublic " + types[1] + " get" + var.substring(0,1).toUpperCase() + var.substring(1) + "() {" + "\t\t//this is getter\r\n");
                        fWriter.write("\t\treturn " + var + ";");
                        fWriter.write("\r\n\t}" + "\r\n");
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
