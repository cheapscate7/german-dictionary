package com.mycompany.group;

import java.util.logging.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;

/**
Title: Tester
Authors: Miroslaw Pasko eeu258, Chris Owen eeu282, Matthew Badcock eeu247
Version: 1.0
 */
public class Tester 
{
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document doc;
    XPathFactory xFactory;
    XPath path;
    
    public Tester() throws Exception
    {
        XMLWriter writer = new XMLWriter();
        XMLGetter getter = new XMLGetter();
        /*
        File f = new File("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\user.xml");
            if(f.exists())
                writer.appendHistoryXML("Pikachu", 18);
            else
                writer.beginHistoryXML("Pikachu", 18);
        //*/
        
        /*
        File f = new File("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\word.xml");
            if(f.exists())
                writer.appendWordXML("Boot", "Das", "boat");
            else
                writer.beginWordXML("Boot", "Das", "boat");
        //*/
        
        //System.out.println(getter.getHistory("Pikachu").toString());
        
        System.out.println(getter.getAllWord().toString());
        
        //writer.modifyUserXML("Korra", "Korra", "abcd", "students");
        
        
        
    }
    
    public static void main(String[] args)
    {
        try {
            Tester derp = new Tester();
        } catch (Exception ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
