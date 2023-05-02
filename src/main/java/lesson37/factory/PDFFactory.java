package lesson37.factory;

import lesson37.factory.domain.Document;
import lesson37.factory.domain.PDFDocument;

public class PDFFactory implements Factory{
    @Override
    public Document getDocument() {
        return new PDFDocument();
    }
}
