package com.brkv.travelfinder

import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class ArticleDb(private val dbHelper: ArticleDbHelper) {

    fun requestArticle() = dbHelper.use {
        select(ArticleTable.NAME,
            ArticleTable.NOM, ArticleTable.DESC, ArticleTable.SRC_IMG, ArticleTable.VILLE, ArticleTable.CONTINENT)
            .parseList(classParser<Article>())
    }

    fun requestArticleByContinent(cont : String) = dbHelper.use {
        select(ArticleTable.NAME,
            ArticleTable.NOM, ArticleTable.DESC, ArticleTable.SRC_IMG, ArticleTable.VILLE, ArticleTable.CONTINENT).whereSimple("continent = ?", cont)
            .parseList(classParser<Article>())
    }

    fun saveArticle(article: Article) = dbHelper.use {
        insert(ArticleTable.NAME, ArticleTable.NOM to article.nom, ArticleTable.DESC to article.desc, ArticleTable.SRC_IMG to article.src_img, ArticleTable.VILLE to article.ville, ArticleTable.CONTINENT to article.continent)
    }

    fun saveArticles(articleList: List<Article>) {
        for (a in articleList)
            saveArticle(a)
    }
}