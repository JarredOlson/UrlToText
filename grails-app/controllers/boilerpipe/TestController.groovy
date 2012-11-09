package boilerpipe

import de.l3s.boilerpipe.extractors.ArticleExtractor

class TestController {

    def index() {
        render(view:"index")
    }

    def urlToText() {
        render(ArticleExtractor.INSTANCE.getText(new URL(params.url)))
    }
}
