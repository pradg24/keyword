TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StringWriter writer = new StringWriter();
                StreamResult result = new StreamResult(writer);
                transformer.transform(domSource, result);
                String xmlString = writer.toString();

if (document != null) {
                System.out.println("Document parsed successfully");

                // Set up XPath with custom namespace context
                XPathFactory xPathFactory = XPathFactory.newInstance();
                XPath xpath = xPathFactory.newXPath();

                // Define the namespace mappings
                Map<String, String> prefixToUriMap = new HashMap<>();
                prefixToUriMap.put("ns", "http://example.com/ns");

                // Set the custom namespace context
                xpath.setNamespaceContext(new CustomNamespaceContext(prefixToUriMap));


  javax.xml.namespace.NamespaceContext namespaceContext = new javax.xml.namespace.NamespaceContext() {
                public String getNamespaceURI(String prefix) {
                    if ("Saa".equals(prefix)) {
                        return "urn:swift:saa:xsd:saa.2.0";
                    }
                    return null;
                }

                public String getPrefix(String namespaceURI) {
                    return null; // Not needed for this example
                }

                public java.util.Iterator getPrefixes(String namespaceURI) {
                    return null; // Not needed for this example
                }
            };
            xpath.setNamespaceContext(namespaceContext);
