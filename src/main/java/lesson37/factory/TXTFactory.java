package lesson37.factory;

import lesson37.factory.domain.Document;
import lesson37.factory.domain.TXTDocument;

public class TXTFactory implements Factory {
    @Override
    public Document getDocument() {
        return new TXTDocument();
    }
}
