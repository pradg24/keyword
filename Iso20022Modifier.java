import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.io.parser.MxParser;
import com.prowidesoftware.swift.io.writer.MxWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.util.Map;

public class Iso20022Modifier {

    public String modifyIso20022Message(String xmlInput, Map<String, String> xpathValuePairs) throws Exception {
        // Parse the XML input into a generic AbstractMX object
        AbstractMX message = MxParser.parse(xmlInput);

        // Create an XPath instance
        XPath xPath = XPathFactory.newInstance().newXPath();

        // Iterate over the XPath-value pairs
        for (Map.Entry<String, String> entry : xpathValuePairs.entrySet()) {
            String expression = entry.getKey();
            String newValue = entry.getValue();

            // Evaluate the XPath expression to find the corresponding node
            Document document = message.getXml();
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);

            if (node != null) {
                // Update the node's value
                node.setTextContent(newValue);
            } else {
                // Handle the case where the node is not found
                System.out.println("Node not found for expression: " + expression);
            }
        }

        // Convert the modified Java object back to XML
        String modifiedXml = MxWriter.write(message);

        return modifiedXml;
    }
}
