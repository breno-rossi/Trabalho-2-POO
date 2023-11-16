import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class MyDocumentFilter extends DocumentFilter {
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        // Remove caracteres não numéricos
        text = text.replaceAll("[^\\d.]", "");
        super.replace(fb, offset, length, text, attrs);
    }



}