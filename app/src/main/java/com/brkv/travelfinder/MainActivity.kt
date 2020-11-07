package com.brkv.travelfinder

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.brkv.travelfinder.fragments.Card
import com.google.android.material.tabs.TabLayout
import org.jetbrains.anko.doAsync


class MainActivity : AppCompatActivity() {
    companion object { const val PREF_NB = "PREF_NB" }
    val articleDb by lazy { ArticleDb(ArticleDbHelper(applicationContext)) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        changeFrag(Card(query("Europe")))

        if(sharedPref.contains(PREF_NB)){
            editor.putInt(PREF_NB, sharedPref.getInt(PREF_NB,0)+1)
            editor.commit()
        }
        else {
            editor.putInt(PREF_NB, 0)
            initDb()
            editor.commit()
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                var fragment: Fragment = Card(query("Europe"))
                when (tab!!.position) {
                    0 -> fragment = Card(query("Europe"))
                    1 -> fragment = Card(query("Asie"))
                    2 -> fragment = Card(query("Amérique"))
                    3 -> fragment = Card(query("Afrique"))
                    4 -> fragment = Card(query("Océanie"))
                }
                changeFrag(fragment)
            }


            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun changeFrag(fragment : Fragment){
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.frameLayout, fragment)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commit()
    }

    private fun initDb() {
        doAsync {
            val article1 = Article("Ville 1","Description 1", "a", "Ville 1", "Europe")
            val article2 = Article("Ville 2","Description 2", "a", "Ville 2", "Asie")
            val article3 = Article("Ville 3","Description 3", "a", "Ville 3", "Amérique")
            val article4 = Article("Ville 4","Description 4", "a", "Ville 4", "Afrique")
            val article5 = Article("Ville 5","Description 5", "a", "Ville 5", "Océanie")
            val list = listOf<Article>(article1,article2,article3,article4,article5)
           articleDb.saveArticles(list)
        }
    }

    private fun query(continent : String): Array<Article> {
            return articleDb.requestArticleByContinent(continent).toTypedArray()
    }
}