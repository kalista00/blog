package project.teamtwo.controller;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/r/*")
public class RserveController {
    @RequestMapping("conn")
    public String conn(Model model) {
        RConnection conn = null;
        String connTo = "";
        try {
            conn = new RConnection();            
            conn.eval("library(rvest)");
            conn.eval("library(httr)");
            
            conn.eval("content <- c()");
            
            conn.eval("for(i in 1:5) {"
                    + "  사이트 <- read_html(\"https://news.naver.com/main/ranking/popularDay.naver\");"
                    + "  노드 <- html_nodes(사이트, paste(\"div.rankingnews_box_wrap._popularRanking > div > div:nth-child(\", i, \") > a > strong\", sep=\"\"));"
                    + "  언론 <- html_text(노드);"
                    + "  for(j in 1:5) {"
                    + "    href <- paste(\"._popularRanking > div > div:nth-child(\", i, \") > ul > li:nth-child(\", j, \") > div > a\", sep=\"\");"
                    + "    노드 <- html_nodes(사이트, href);"
                    + "    news_href <- html_attr(노드, \"href\");"
                    + "    nf <- read_html(news_href);"
                    + "    노드 <- html_nodes(nf, \"#newsct_article\");"
                    + "    내용 <- html_text(노드);"
                    + "    content <- c(content, 내용);"
                    + "}"
                    + "}");

            conn.eval("library(KoNLP)");
            conn.eval("library(wordcloud2)");
            conn.eval("library(tm)");
            conn.eval("library(stringr)");
            conn.eval("useSejongDic()");
            conn.eval("useNIADic()");
            
            conn.eval("content <- str_replace_all(content, pattern = \"[^가-힣a-zA-z] \", \" \")");
            conn.eval("content <- Corpus(VectorSource(content))");
            conn.eval("content <- tm_map(content, removePunctuation)");
            conn.eval("content <- tm_map(content, removeNumbers)");
            conn.eval("content <- tm_map(content, stripWhitespace)");
            
            conn.eval("txt <- c()");
            conn.eval("for(i in 1:length(content)){"
                    + "  txt <- c(txt , content[[i]]$content)"
                    + "}");
            
            conn.eval("noun <- extractNoun(txt)");
            conn.eval("noun <- unlist(noun)");
            conn.eval("noun <- Filter(function(x){nchar(x) >= 2} , noun)");
            conn.eval("wc <- table(noun)");
            conn.eval("wc <- sort(wc , decreasing = TRUE)");
            conn.eval("wc <- wordcloud2(wc , size=0.5)");
            conn.eval("mpath <- renderTags(wc)");
            model.addAttribute("wc", conn.eval("mpath$html").asString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ee) {
                }
            }
        }
        return "wordcloud";
    }
}
