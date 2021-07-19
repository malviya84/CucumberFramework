package fileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class QAEnvironmentReader extends XMLReader {

	private static List<QAEnvironment> listEnvironment = null;

	private List<QAEnvironment> getListEnvironment() {
		return listEnvironment;
	}

	public void setListEnvironment(List<QAEnvironment> listEnvironment) {
		this.listEnvironment = listEnvironment;
	}

	private QAEnvironmentReader() {
		readFileData();
	}

	public static List<QAEnvironment> getInstanceOfEnviornmentList() {
		if (listEnvironment == null) {
			return new QAEnvironmentReader().getListEnvironment();

		} else
			return listEnvironment;
	}

	private void readFileData() {
		try {
			XMLEventReader eventReader = getXMLEventReader(
					System.getProperty("user.dir") + "//configs//ExecutionConfig.xml");
			this.listEnvironment = getEnvironmentList(eventReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<QAEnvironment> getEnvironmentList(XMLEventReader eventReader) {

		QAEnvironment qaEnvironment = null;
		Boolean executionStatus = false;
		List<QAEnvironment> listEnvironment = new ArrayList<QAEnvironment>();
		try {

			while (eventReader.hasNext()) {
				XMLEvent event;
				// try {
				event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart().equals("QAEnvironment")) {
						qaEnvironment = new QAEnvironment();
						Iterator<Attribute> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();

							if (attribute.getName().toString().equals("testingExecutionStatus")) {
								executionStatus = Boolean.parseBoolean(attribute.getValue());
								if (executionStatus.equals(Boolean.TRUE))
									qaEnvironment.setEnvironment(attribute.getValue());
								else
									break;

							} // Inner wile loop End
							if (attribute.getName().toString().equals("value")) {
								qaEnvironment.setEnvironment(attribute.getValue());
							}

						}
						if (executionStatus.equals(false))
							break;// Don't store the data of qa environment variables if execution is not targeted

					}
					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart().equals("BrowserName")) {
							event = eventReader.nextEvent();
							qaEnvironment.setBrowwserName(event.asCharacters().getData().trim());
							continue;
						}
					}
					if (event.asStartElement().getName().getLocalPart().equals("BrowserPath")) {
						event = eventReader.nextEvent();
						qaEnvironment.setBrowserPath(event.asCharacters().getData().trim());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals("WindowMaximize")) {
						event = eventReader.nextEvent();
						qaEnvironment.setWindowmaximize(
								event.asCharacters().getData().trim().equals("True") ? Boolean.TRUE : Boolean.FALSE);
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals("URL")) {
						event = eventReader.nextEvent();
						qaEnvironment.setURL(event.asCharacters().getData().toString().trim());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals("ImplicitWait")) {
						event = eventReader.nextEvent();
						qaEnvironment.setImplecitWait(Long.parseLong(event.asCharacters().getData().toString().trim()));
						continue;
					}
				}

				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals("QAEnvironment")) {
						listEnvironment.add(qaEnvironment);
					}
				}

			} // End of While Loop
			return listEnvironment;
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
