package com.brkv.travelfinder

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class ArticleDbHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx,
    DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "article.db"
        val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(ArticleTable.NAME, true, ArticleTable.ID to INTEGER + PRIMARY_KEY,
            ArticleTable.NOM to TEXT,
            ArticleTable.DESC to TEXT,
            ArticleTable.SRC_IMG to TEXT,
            ArticleTable.VILLE to TEXT,
            ArticleTable.CONTINENT to TEXT,
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(ArticleTable.NAME, true)
        onCreate(db)
    }
}