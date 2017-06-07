package sample;

import org.xwiki.component.embed.EmbeddableComponentManager;
import org.xwiki.component.manager.ComponentLookupException;
import org.xwiki.rendering.converter.Converter;
import org.xwiki.rendering.renderer.printer.DefaultWikiPrinter;
import org.xwiki.rendering.renderer.printer.WikiPrinter;
import org.xwiki.rendering.syntax.Syntax;

import java.io.StringReader;

// Make the xwiki versions to be taken from the user
public class XWikiToHtmlRenderer {
    public static String convert(String xWikiString) {
        EmbeddableComponentManager componentManager = new EmbeddableComponentManager();
        componentManager.initialize(XWikiToHtmlRenderer.class.getClassLoader());

        Converter converter = null;
        try {
            converter = componentManager.getInstance(Converter.class);
        } catch (ComponentLookupException e) {
            e.printStackTrace();
        }

        WikiPrinter printer = new DefaultWikiPrinter();
        try {
            converter.convert(new StringReader(xWikiString), Syntax.XWIKI_2_1, Syntax.XHTML_1_0, printer);
        } catch (Exception e) {
            return null;
        }

        return printer.toString();
    }
}
