package net.slipp.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.StringWriter;

import org.eclipse.mylyn.wikitext.confluence.core.ConfluenceLanguage;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilder;
import org.junit.Test;

public class WikiParserTest {
	@Test
	public void parse() throws Exception {
		String source = "h1. �׽�Ʈ";
		StringWriter writer = new StringWriter();
		HtmlDocumentBuilder builder = new HtmlDocumentBuilder(writer);
		builder.setEmitAsDocument(false);
		MarkupParser parser = new MarkupParser(new ConfluenceLanguage());
		parser.setBuilder(builder);
		parser.parse(source);
		assertThat(writer.toString(), is("<h1 id=\"h1-1\">�׽�Ʈ</h1>"));
	}
}
