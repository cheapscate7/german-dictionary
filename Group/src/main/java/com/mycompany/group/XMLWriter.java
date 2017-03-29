package com.mycompany.group;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

/**
Title: XML Writer
Authors: Miroslaw Pasko eeu258, Chris Owen eeu282, Matthew Badcock eeu247
Version: 1.0
 */
public class XMLWriter 
{

    /**
     * Creates or overwrites an XML file with the German word and its translation
     * @param noun - german term
     * @param gender - gender of the word, der, die or das
     * @param translation -  meaning of the word
     * @throws Exception
     */
    public void beginWordXML(String noun, String gender, String translation) throws Exception
    {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date date = new Date();
        OutputStream stream = new FileOutputStream("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\word.xml");
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(stream);
        writer.writeStartDocument();
        writer.writeStartElement("root");
        writer.writeStartElement("word");
        
        
        writer.writeStartElement("noun");
        writer.writeCharacters(noun);
        writer.writeEndElement();
        
        writer.writeStartElement("gender");
        writer.writeCharacters(gender);
        writer.writeEndElement();
        
        writer.writeStartElement("translation");
        writer.writeCharacters(translation);
        writer.writeEndElement();
        
        writer.writeEndElement();
        writer.writeEndElement();
        
        writer.flush();
    }
    
    /**
     * Appends an XML file with the German word and its translation
     * @param noun - german term
     * @param gender - gender of the word, der, die or das
     * @param translation -  meaning of the word
     * @return 
     * @throws Exception
     */
    public String appendWordXML(String noun, String gender, String translation) throws Exception
    {
        /*
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //*/
        XMLGetter getter = new XMLGetter();
        ArrayList derp = getter.getWord(noun);
        if(!derp.isEmpty())
        {
            return "word already in database";
        }
        else
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\word.xml");
            Element root = document.getDocumentElement();

            Element search = document.createElement("word");
            //search.setAttribute("date", dateFormat.format(date));

            Element termX = document.createElement("noun");
            termX.appendChild(document.createTextNode(noun));
            search.appendChild(termX);

            Element ifFoundX = document.createElement("gender");
            ifFoundX.appendChild(document.createTextNode(gender));
            search.appendChild(ifFoundX);

            Element idX = document.createElement("translation");
            idX.appendChild(document.createTextNode(translation));
            search.appendChild(idX);

            root.appendChild(search);
            DOMSource source = new DOMSource(document);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\word.xml");
            transformer.transform(source, result);
            
            return "Word " + noun + " added to the database";
        }
    }
    
    /**
     * Creates or overwrites an XML file with the user data
     * @param username
     * @param password
     * @param privilege
     * @throws Exception
     */
    public void beginUserXML(String username, String password, String privilege) throws Exception
    {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date date = new Date();
        OutputStream stream = new FileOutputStream("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\user.xml");
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(stream);
        writer.writeStartDocument();
        writer.writeStartElement("root");
        writer.writeStartElement("user");
        
        
        writer.writeStartElement("username");
        writer.writeCharacters(username);
        writer.writeEndElement();
        
        writer.writeStartElement("password");
        writer.writeCharacters(password);
        writer.writeEndElement();
        
        writer.writeStartElement("privilege");
        writer.writeCharacters(privilege);
        writer.writeEndElement();
        
        writer.writeEndElement();
        writer.writeEndElement();
        
        writer.flush();
    }
    
    /**
     * Appends an XML file with user data
     * @param username
     * @param password
     * @param privilege
     * @return 
     * @throws Exception
     */
    public String appendUserXML(String username, String password, String privilege) throws Exception
    {
        /*
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //*/
        XMLGetter getter = new XMLGetter();
        ArrayList derp = getter.getUser(username);
        if(!derp.isEmpty())
        {
            return "user already in database";
        }
        else
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\user.xml");
            Element root = document.getDocumentElement();

            Element search = document.createElement("user");
            //search.setAttribute("date", dateFormat.format(date));

            Element termX = document.createElement("username");
            termX.appendChild(document.createTextNode(username));
            search.appendChild(termX);

            Element ifFoundX = document.createElement("password");
            ifFoundX.appendChild(document.createTextNode(password));
            search.appendChild(ifFoundX);

            Element idX = document.createElement("privilege");
            idX.appendChild(document.createTextNode(privilege));
            search.appendChild(idX);

            root.appendChild(search);
            DOMSource source = new DOMSource(document);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\user.xml");
            transformer.transform(source, result);
            
            return "User " + username + " added to the database";
        }
    }
    
    /**
     * Creates or overwrites an XML file with test history element
     * @param username
     * @param score
     * @throws Exception
     */
    public void beginHistoryXML(String username, int score) throws Exception
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        OutputStream stream = new FileOutputStream("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\test.xml");
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(stream);
        writer.writeStartDocument();
        writer.writeStartElement("root");
        writer.writeStartElement("test");
        
        
        writer.writeStartElement("username");
        writer.writeCharacters(username);
        writer.writeEndElement();
        
        writer.writeStartElement("date");
        writer.writeCharacters(dateFormat.format(date));
        writer.writeEndElement();
        
        writer.writeStartElement("score");
        writer.writeCharacters(Integer.toString(score));
        writer.writeEndElement();
        
        writer.writeEndElement();
        writer.writeEndElement();
        
        writer.flush();
    }
    
    /**
     * Appends an XML file with the test history element
     * @param username
     * @param score
     * @throws Exception
     */
    public void appendHistoryXML(String username, int score) throws Exception
    {
    //*
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
    //*/
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\test.xml");
        Element root = document.getDocumentElement();

        Element search = document.createElement("test");

        Element termX = document.createElement("username");
        termX.appendChild(document.createTextNode(username));
        search.appendChild(termX);

        Element ifFoundX = document.createElement("date");
        ifFoundX.appendChild(document.createTextNode(dateFormat.format(date)));
        search.appendChild(ifFoundX);

        Element idX = document.createElement("score");
        idX.appendChild(document.createTextNode(Integer.toString(score)));
        search.appendChild(idX);

        root.appendChild(search);
        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\test.xml");
        transformer.transform(source, result);
    }
    
    /**
     * Deletes given word
     * @param noun
     * @return
     * @throws Exception
     */
    public String deleteWordXML(String noun) throws Exception
    {
        XMLGetter getter = new XMLGetter();
        ArrayList derp = getter.getWord(noun);
        if(derp.isEmpty())
        {
            return "word is not in database";
        }
        else
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\word.xml");
            
            
            DocumentTraversal traversal = (DocumentTraversal) document;
            Node root = document.getDocumentElement();
            NodeIterator iterator = traversal.createNodeIterator(root, NodeFilter.SHOW_ELEMENT, null, true);
            Element word = null;
            for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
                Element del = (Element) n;
                if ("word".equals(del.getTagName())) {
                    word = del;
                } else if ("noun".equals(del.getTagName()) && noun.equals(del.getTextContent()) && word != null) {
                    root.removeChild(word);
                }
            }
            
            DOMSource source = new DOMSource(document);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\word.xml");
            transformer.transform(source, result);
            return "Word " + noun + " deleted from the database";
        }
    }

    /**
     * Modifies German word with given parameters
     * @param oldNoun
     * @param noun
     * @param gender
     * @param translation
     * @return
     * @throws Exception
     */
    public String modifyWordXML(String oldNoun, String noun, String gender, String translation) throws Exception
    {
        XMLGetter getter = new XMLGetter();
        ArrayList derp = getter.getWord(oldNoun);
        if(derp.isEmpty())
        {
            return "word not in database";
        }
        else
        {
            deleteWordXML(oldNoun);
            appendWordXML(noun, gender, translation);
            return "Word " + oldNoun + " modified";
        }
    }
    
    /**
     * Deletes user data
     * @param username
     * @return
     * @throws Exception
     */
    public String deleteUserXML(String username) throws Exception
    {
        XMLGetter getter = new XMLGetter();
        ArrayList derp = getter.getUser(username);
        if(derp.isEmpty())
        {
            return "user is not in database";
        }
        else
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\user.xml");
            
            
            DocumentTraversal traversal = (DocumentTraversal) document;
            Node root = document.getDocumentElement();
            NodeIterator iterator = traversal.createNodeIterator(root, NodeFilter.SHOW_ELEMENT, null, true);
            Element user = null;
            for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
                Element del = (Element) n;
                if ("user".equals(del.getTagName())) {
                    user = del;
                } else if ("username".equals(del.getTagName()) && username.equals(del.getTextContent()) && user != null) {
                    root.removeChild(user);
                }
            }
            
            DOMSource source = new DOMSource(document);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\user.xml");
            transformer.transform(source, result);
            return  "User "+ username+ " deleted from the database";
        }
    }

    /**
     * Clears history of a user
     * @param username
     * @return
     * @throws Exception
     */
    public String cleanseUserHistoryXML(String username) throws Exception
    {
        XMLGetter getter = new XMLGetter();
        ArrayList derp = getter.getHistory(username);
        if(derp.isEmpty())
        {
            return "user do not have any test records";
        }
        else
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\test.xml");
            
            
            DocumentTraversal traversal = (DocumentTraversal) document;
            Node root = document.getDocumentElement();
            NodeIterator iterator = traversal.createNodeIterator(root, NodeFilter.SHOW_ELEMENT, null, true);
            Element user = null;
            for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
                Element del = (Element) n;
                if ("test".equals(del.getTagName())) {
                    user = del;
                } else if ("username".equals(del.getTagName()) && username.equals(del.getTextContent()) && user != null) {
                    root.removeChild(user);
                }
            }
            
            DOMSource source = new DOMSource(document);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("C:\\Users\\Erthain\\Documents\\NetBeansProjects\\Group\\test.xml");
            transformer.transform(source, result);
            return ""+username+"'s history cleansed";
        }
    }

    /**
     * Modifies user data
     * @param oldUsername
     * @param username
     * @param password
     * @param privilege
     * @return
     * @throws Exception
     */
    public String modifyUserXML(String oldUsername, String username, String password, String privilege) throws Exception
    {
        XMLGetter getter = new XMLGetter();
        ArrayList derp = getter.getUser(oldUsername);
        if(derp.isEmpty())
        {
            return "user not in database";
        }
        else
        {
            deleteUserXML(oldUsername);
            appendUserXML(username, password, privilege);
            return "User "+ oldUsername + " modified";
        }
    }
}


