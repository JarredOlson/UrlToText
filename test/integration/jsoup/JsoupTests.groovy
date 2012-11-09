package jsoup

import org.junit.Test
import org.jsoup.nodes.Document
import org.jsoup.Jsoup
import de.l3s.boilerpipe.extractors.ArticleExtractor
import de.l3s.boilerpipe.extractors.ArticleSentencesExtractor

class JsoupTests {

    def url = "http://www.10tv.com/content/stories/2012/11/09/columbus-high-speed-chase-overnight.html"

    @Test
    public void stuff() {
        String boilerpipe = ArticleSentencesExtractor.INSTANCE.getText(new URL(url))
        Document document = Jsoup.connect(url).get()
        String startingText = boilerpipe.split("\n")[0]
        println document.body().getElementsContainingOwnText(startingText).parents()[0]
    }
}
