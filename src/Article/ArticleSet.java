package Article;

import java.util.HashMap;

public class ArticleSet {
    HashMap<String,Article>article_set = new HashMap<String,Article>();
    public ArticleSet(){}
    public void add(Article article)
    {
        article_set.put(article.get_id(),article);
    }
    public void Articlejudge()
    {
        for(Article dir:article_set.values())
        {
            if(dir.get_useTimes() == 0)
                article_set.remove(dir.get_id());
        }
    }
    public String getArticle(){
        StringBuffer sb = new StringBuffer();
        int n=0;
        for(Article dir:article_set.values())
        {
            sb.append(dir.getBase());
            sb.append('\n');
            n=1;
        }
        if(n==0)
        {
            System.out.println("背包为空");
        }
        return sb.toString();
    }
    public Article get_article(String id)
    {
        return article_set.get(id);
    }
}
