package jsoup

import org.junit.Test
import org.jsoup.nodes.Document
import org.jsoup.Jsoup
import de.l3s.boilerpipe.extractors.ArticleExtractor
import de.l3s.boilerpipe.extractors.ArticleSentencesExtractor

class JsoupTests {

    @Test
    public void newsArticle() {
        def url = "http://www.10tv.com/content/stories/2012/11/09/columbus-high-speed-chase-overnight.html"

        def result = doIt(url)

        assert result.startsWith('<div id="story-body">')
    }

    @Test
    public void wikipediaPage() {
        def url = "http://en.wikipedia.org/wiki/Edmund_Sharpe"

        def result = doIt(url)

        assert result.startsWith('<div id="mw-content-text" lang="en" dir="ltr" class="mw-content-ltr">')
    }


    private doIt(url) {
        String boilerpipe = ArticleSentencesExtractor.INSTANCE.getText(new URL(url))
        Document document = Jsoup.connect(url).get()

        def elements = null
        for (String startingText: boilerpipe.split("\n")) {
            elements = document.body().getElementsContainingOwnText(startingText.take(25)).parents()[0]
            if (elements != null) {
                break;
            }
        }
        elements.toString()
    }
}
