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
