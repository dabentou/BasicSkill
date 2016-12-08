package Xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

/**
 * Created by Administrator on 2016/12/6.
 */
public class XPathExample {
    public static void main(String[] args) throws Exception{

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("books.xml");

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        //XPath 对象编译 XPath 表达式
        XPathExpression expr
                = xpath.compile("//book[author='Neal Stephenson']/title/text()");

        //计算 XPath 表达式得到结果。表达式是针对特定的上下文节点计算的，
        // 在这个例子中是整个文档。还必须指定返回类型。这里要求返回一个节点集
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        //可以将结果强制转化成 DOM NodeList，然后遍历列表得到所有的标题
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

    }
}
