package com.example.dokatsu.dokatsu;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import android.content.Context;

public class EmployeeXML {

    static List<EmployeeBean> _EmployeeList = new ArrayList<>();
    static File _File;

    public EmployeeXML() {
        InitEmpList();
    }

    static void loadFile(Context context) {
        try {
            //ファイルが存在しない場合は処理しない
            if (!_File.exists()) {
                saveFile();
                return;
            }

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(_File);
            Node elementNodes = document.getDocumentElement();//[4]
            NodeList nodeList = elementNodes.getChildNodes();
            for (AtomicInteger i = new AtomicInteger(); i.get() <nodeList.getLength(); i.getAndIncrement())
            {
                Node node = nodeList.item(i.get());
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    String id = element.getAttribute("id");
                    String furigana = element.getAttribute("furigana");
                    String name = element.getAttribute("Name");
                    EmployeeBean _EmployeeBean = new EmployeeBean(id, furigana, name);
                    _EmployeeList.add(_EmployeeBean);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void saveFile() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element employeeList = document.createElement("Employees");

            for (EmployeeBean _Emp : _EmployeeList) {
                Element employee = document.createElement("Employee");
                employee.setAttribute("id", _Emp.getId());
                employee.setAttribute("furigana", _Emp.getFurigana());
                employee.setAttribute("Name", _Emp.getName());
                employeeList.appendChild(employee);
            }
            document.appendChild(employeeList);
            write(document);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static void InitEmpList() {
        _EmployeeList = new ArrayList<>();
        _EmployeeList.add(new EmployeeBean("001", "ﾚｲﾜﾀﾛｳ", "令和太郎"));
        _EmployeeList.add(new EmployeeBean("002", "ﾚｲﾜｼﾞﾛｳ", "令和次郎"));
        _EmployeeList.add(new EmployeeBean("003", "ﾚｲﾜｻﾌﾞﾛｳ", "令和三郎"));
        _EmployeeList.add(new EmployeeBean("004", "ﾚｲﾜｼﾛｳ", "令和四郎"));
    }

    /**
     * @param document ドキュメントインスタンス
     * @return 成功したかどうか
     */
    private static boolean write(Document document) {

        // Transformerインスタンスの生成
        Transformer transformer;
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return false;
        }

        // Transformerの設定
        transformer.setOutputProperty("indent", "yes"); //改行指定
        transformer.setOutputProperty("encoding", "Shift_JIS"); // エンコーディング

        // XMLファイルの作成
        try {
            transformer.transform(new DOMSource(document), new StreamResult(_File));
        } catch (TransformerException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static String GetNewID() {
        int newIdInt = 1;
        for (EmployeeBean _Emp : _EmployeeList) {
            int empIdInt = Integer.parseInt(_Emp.getId());
            if (newIdInt < empIdInt) newIdInt = empIdInt;
        }
        newIdInt++;
        return String.format("%03d", newIdInt);
    }
}
