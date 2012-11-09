package boilerpipe

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import de.l3s.boilerpipe.extractors.ArticleSentencesExtractor

class JsoupController {

    def index() {
        render(view: "index")
    }

//    def urlToText() {
//        Document document = Jsoup.connect(params.url).get()
//        def listOfStuff = []
//        listOfStuff << document.getElementsByTag("H1")
//        listOfStuff << document.getElementById("story-body")
//        println listOfStuff
//        render(listOfStuff)
//    }

    def urlToText() {
        String boilerpipe = ArticleSentencesExtractor.INSTANCE.getText(new URL(params.url))
        Document document = Jsoup.connect(params.url).get()
        String startingText = boilerpipe.split("\n")[0]
        render(document.body().getElementsContainingOwnText(startingText).parents()[0])
    }


    //        render(document.getAllElements())
    //        listOfStuff << document.getElementsByTag("img")
//        Element body = document.getElementById("story-body")
//        body.getElementsByTag("img")
}
