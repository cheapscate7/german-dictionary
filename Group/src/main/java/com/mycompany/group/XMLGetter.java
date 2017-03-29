/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
Title: XML Getter
Authors: Miroslaw Pasko eeu258, Chris Owen eeu282, Matthew Badcock eeu247
Version: 1.0
 */
public class XMLGetter 
{
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document doc;
    XPathFactory xFactory;
    XPath path;
    
    /**
     *
     * @throws Exception
     */
    public XMLGetter() throws Exception
    {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        xFactory = XPathFactory.newInstance();
        path = xFactory.newXPath();
    }
    
    /**
     * Returns entire history of scores of given user
     * @param username
     * @return
     * @throws Exception
     */
    public ArrayList getHistory(String username) throws Exception
    {
        doc = builder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\test.xml");
        
        NodeList nPanList = doc.getElementsByTagName("test");

        ArrayList<String> results = new ArrayList<String>();
        String derp = "";
        String derp2 = "";
        int index = 0;
        
        for(int temp = 0 ; temp <nPanList.getLength(); temp++)
        {
            Node nNode = nPanList.item(temp);
            Element eElement = (Element) nNode;
            
            NodeList childList = eElement.getChildNodes();
            
            Node childNode = childList.item(0);
            derp = childNode.getTextContent();
            System.out.println(derp);
            if (derp.equals(username))
            {
                Node childNode2 = childList.item(1);
                derp2 = childNode2.getTextContent();
                results.add(derp2);
                childNode2 = childList.item(2);
                derp2 = childNode2.getTextContent();
                results.add(derp2);
            }
        }
        
        return results;
    }
    
    /**
     * Returns a single word
     * @param username
     * @return
     * @throws Exception
     */
    public ArrayList getWord(String username) throws Exception
    {
        doc = builder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\word.xml");
        
        NodeList nPanList = doc.getElementsByTagName("word");

        ArrayList<String> results = new ArrayList<String>();
        String derp = "";
        String derp2 = "";
        int index = 0;
        
        for(int temp = 0 ; temp <nPanList.getLength(); temp++)
        {
            Node nNode = nPanList.item(temp);
            Element eElement = (Element) nNode;
            
            NodeList childList = eElement.getChildNodes();
            
            Node childNode = childList.item(0);
            derp = childNode.getTextContent();
            System.out.println(derp);
            if (derp.equals(username))
            {
                Node childNode2 = childList.item(0);
                derp2 = childNode2.getTextContent();
                results.add(derp2);
                childNode2 = childList.item(1);
                derp2 = childNode2.getTextContent();
                results.add(derp2);
                childNode2 = childList.item(2);
                derp2 = childNode2.getTextContent();
                results.add(derp2);
            }
        }
        
        return results;
    }
    
    /**
     * Returns a single user
     * @param username
     * @return
     * @throws Exception
     */
    public ArrayList getUser(String username) throws Exception
    {
        doc = builder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\user.xml");
        
        NodeList nPanList = doc.getElementsByTagName("user");

        ArrayList<String> results = new ArrayList<String>();
        String derp = "";
        String derp2 = "";
        int index = 0;
        
        for(int temp = 0 ; temp <nPanList.getLength(); temp++)
        {
            Node nNode = nPanList.item(temp);
            Element eElement = (Element) nNode;
            
            NodeList childList = eElement.getChildNodes();
            
            Node childNode = childList.item(0);
            derp = childNode.getTextContent();
            System.out.println(derp);
            if (derp.equals(username))
            {
                Node childNode2 = childList.item(0);
                derp2 = childNode2.getTextContent();
                results.add(derp2);
                childNode2 = childList.item(1);
                derp2 = childNode2.getTextContent();
                results.add(derp2);
                childNode2 = childList.item(2);
                derp2 = childNode2.getTextContent();
                results.add(derp2);
            }
        }
        
        return results;
    }
    
    /**
     * Returns all words in the database
     * @return
     * @throws Exception
     */
    public ArrayList getAllWord() throws Exception
    {
        doc = builder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\word.xml");
        
        NodeList nPanList = doc.getElementsByTagName("word");

        ArrayList<ArrayList<String>> results = new ArrayList<>();
        String derp = "";
        String derp2 = "";
        int index = 0;
        
        for(int temp = 0 ; temp <nPanList.getLength(); temp++)
        {
            Node nNode = nPanList.item(temp);
            Element eElement = (Element) nNode;
            ArrayList<String> set = new ArrayList<String>();
            
            NodeList childList = eElement.getChildNodes();
            
            Node childNode = childList.item(0);
            derp = childNode.getTextContent();
            System.out.println(derp);
            
            Node childNode2 = childList.item(0);
            derp2 = childNode2.getTextContent();
            set.add(derp2);
            childNode2 = childList.item(1);
            derp2 = childNode2.getTextContent();
            set.add(derp2);
            childNode2 = childList.item(2);
            derp2 = childNode2.getTextContent();
            set.add(derp2);
            results.add(set);
        }
        
        Collections.sort(results, new Comparator<ArrayList<String>>() {
        @Override
            public int compare(ArrayList<String> one, ArrayList<String> two) {
                return one.get(0).compareTo(two.get(0));
            }
        });
        
        return results;
    }
    
}
