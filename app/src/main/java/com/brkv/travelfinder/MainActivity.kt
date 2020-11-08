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
            var article1 = Article("Londres","Description 1", "https://images.pexels.com/photos/460672/pexels-photo-460672.jpeg", "London", "Europe")
            var article2 = Article("Paris","Description 1", "https://images.pexels.com/photos/149637/pexels-photo-149637.jpeg", "Paris", "Europe")
            var article3 = Article("Berlin","Description 1", "https://images.pexels.com/photos/1057840/pexels-photo-1057840.jpeg", "Berlin", "Europe")
            var article4 = Article("Amsterdam","Description 1", "https://images.pexels.com/photos/2031706/pexels-photo-2031706.jpeg", "Amsterdam", "Europe")
            var article5 = Article("Venise","Description 1", "https://images.pexels.com/photos/1796736/pexels-photo-1796736.jpeg", "Venice", "Europe")
            var article6 = Article("Barcelone","Description 1", "https://images.pexels.com/photos/1388030/pexels-photo-1388030.jpeg", "Barcelona", "Europe")
            var article7 = Article("Prague","Description 1", "https://images.pexels.com/photos/61381/pexels-photo-61381.jpeg", "Prague", "Europe")
            var article8 = Article("Budapest","Description 1", "https://images.pexels.com/photos/732057/pexels-photo-732057.jpeg", "Budapest", "Europe")
            var article9 = Article("Lisbonne","Description 1", "https://images.pexels.com/photos/9253/sea-city-landscape-sky.jpg", "Lisbon", "Europe")
            var article10 = Article("Reykjavik","Description 1", "https://images.pexels.com/photos/831058/pexels-photo-831058.jpeg", "Reykjavik", "Europe")
            val list_europe = listOf<Article>(article1,article2,article3,article4,article5,article6,article7,article8,article9,article10)
           articleDb.saveArticles(list_europe)
            article1 = Article("New York","Description 1", "https://images.pexels.com/photos/290386/pexels-photo-290386.jpeg", "New York", "Amérique")
            article2 = Article("San Fransisco","Description 1", "https://images.pexels.com/photos/1141853/pexels-photo-1141853.jpeg", "San Fransisco", "Amérique")
            article3 = Article("Las Vegas","Description 1", "https://images.pexels.com/photos/2837909/pexels-photo-2837909.jpeg", "Las Vegas", "Amérique")
            article4 = Article("Toronto","Description 1", "https://images.pexels.com/photos/1519088/pexels-photo-1519088.jpeg", "Toronto", "Amérique")
            article5 = Article("Mexico","Description 1", "https://images.pexels.com/photos/1720086/pexels-photo-1720086.jpeg", "Mexico", "Amérique")
            article6 = Article("Lima","Description 1", "https://images.pexels.com/photos/1570610/pexels-photo-1570610.jpeg", "Lima", "Amérique")
            article7 = Article("San José","Description 1", "https://images.pexels.com/photos/3066240/pexels-photo-3066240.jpeg", "San José", "Amérique")
            article8 = Article("La Havane","Description 1", "https://images.pexels.com/photos/3687922/pexels-photo-3687922.jpeg", "La Havana", "Amérique")
            article9 = Article("Rio de Janeiro","Description 1", "https://images.pexels.com/photos/2868242/pexels-photo-2868242.jpeg", "Rio de Janeiro", "Amérique")
            article10 = Article("Montréal","Description 1", "https://images.pexels.com/photos/2244823/pexels-photo-2244823.jpeg", "Montreal", "Amérique")
            val list_amerique = listOf<Article>(article1,article2,article3,article4,article5,article6,article7,article8,article9,article10)
            articleDb.saveArticles(list_amerique)
            article1 = Article("Le Cap","Description 1", "https://images.pexels.com/photos/259447/pexels-photo-259447.jpeg", "Cape Town", "Afrique")
            article2 = Article("Marrakech","Description 1", "https://images.pexels.com/photos/5155950/pexels-photo-5155950.jpeg", "Marrakech", "Afrique")
            article3 = Article("Le Caire","Description 1", "https://images.pexels.com/photos/3689859/pexels-photo-3689859.jpeg", "Cairo", "Afrique")
            article4 = Article("Victoria","Description 1", "https://images.pexels.com/photos/5048704/pexels-photo-5048704.jpeg", "Amsterdam", "Afrique")
            article5 = Article("Casablanca","Description 1", "https://images.pexels.com/photos/2404046/pexels-photo-2404046.jpeg", "Casablanca", "Afrique")
            article6 = Article("Gizeh","Description 1", "https://images.pexels.com/photos/2402926/pexels-photo-2402926.jpeg", "Gizeh", "Afrique")
            article7 = Article("Durban","Description 1", "https://images.pexels.com/photos/3814231/pexels-photo-3814231.jpeg", "Durban", "Afrique")
            article8 = Article("Tananarive","Description 1", "https://images.pexels.com/photos/5017881/pexels-photo-5017881.jpeg", "Tananarive", "Afrique")
            article9 = Article("Tenerife","Description 1", "https://images.pexels.com/photos/1606603/pexels-photo-1606603.jpeg", "Tenerife", "Afrique")
            article10 = Article("Zanzibar","Description 1", "https://images.pexels.com/photos/3361818/pexels-photo-3361818.jpeg", "Zanzibar", "Afrique")
            val list_afrique = listOf<Article>(article1,article2,article3,article4,article5,article6,article7,article8,article9,article10)
            articleDb.saveArticles(list_afrique)
            article1 = Article("Tokyo","Description 1", "https://images.pexels.com/photos/1134166/pexels-photo-1134166.jpeg", "Tokyo", "Asie")
            article2 = Article("Bali","Description 1", "https://images.pexels.com/photos/2166553/pexels-photo-2166553.jpeg", "Bali", "Asie")
            article3 = Article("Pékin","Description 1", "https://images.pexels.com/photos/2846034/pexels-photo-2846034.jpeg", "Beijing", "Asie")
            article4 = Article("Colombo","Description 1", "https://images.pexels.com/photos/1998438/pexels-photo-1998438.jpeg", "Colombo", "Asie")
            article5 = Article("Jérusalem","Description 1", "https://images.pexels.com/photos/2087323/pexels-photo-2087323.jpeg", "Jerusalem", "Asie")
            article6 = Article("Dubaï","Description 1", "https://images.pexels.com/photos/823696/pexels-photo-823696.jpeg", "Dubaï", "Asie")
            article7 = Article("Singapour","Description 1", "https://images.pexels.com/photos/777059/pexels-photo-777059.jpeg", "Singapore", "Asie")
            article8 = Article("Moscou","Description 1", "https://images.pexels.com/photos/2816185/pexels-photo-2816185.jpeg", "Moscow", "Asie")
            article9 = Article("Saint-Pétersbourg","Description 1", "https://images.pexels.com/photos/3301030/pexels-photo-3301030.jpeg", "Saint Petersburg", "Asie")
            article10 = Article("Istanbul","Description 1", "https://images.pexels.com/photos/1549326/pexels-photo-1549326.jpeg", "Istanbul", "Asie")
            val list_asie = listOf<Article>(article1,article2,article3,article4,article5,article6,article7,article8,article9,article10)
            articleDb.saveArticles(list_asie)
            article1 = Article("Sydney","Description 1", "https://images.pexels.com/photos/995764/pexels-photo-995764.jpeg", "Sydney", "Océanie")
            article2 = Article("Melbourne","Description 1", "https://images.pexels.com/photos/3626248/pexels-photo-3626248.jpeg", "Melbourne", "Océanie")
            article3 = Article("Auckland","Description 1", "https://images.pexels.com/photos/5063807/pexels-photo-5063807.jpeg", "Auckland", "Océanie")
            article4 = Article("Queenstone","Description 1", "https://images.pexels.com/photos/37650/new-zealand-lake-mountain-landscape-37650.jpeg", "Queenstone", "Océanie")
            article5 = Article("Suva","Description 1", "https://images.pexels.com/photos/1752461/pexels-photo-1752461.jpeg", "Suva", "Océanie")
            article6 = Article("Perth","Description 1", "https://images.pexels.com/photos/3405467/pexels-photo-3405467.jpeg", "Perth", "Océanie")
            article7 = Article("Brisbane","Description 1", "https://images.pexels.com/photos/2314922/pexels-photo-2314922.jpeg", "Brisbane", "Océanie")
            article8 = Article("Gold Coast","Description 1", "https://images.pexels.com/photos/786357/pexels-photo-786357.jpeg", "Gold Coast", "Océanie")
            article9 = Article("Vaitape","Description 1", "https://images.pexels.com/photos/753626/pexels-photo-753626.jpeg", "Vaitape", "Océanie")
            article10 = Article("Kokatahi","Description 1", "https://images.pexels.com/photos/572689/pexels-photo-572689.jpeg", "Reykjavik", "Océanie")
            val list_oceanie = listOf<Article>(article1,article2,article3,article4,article5,article6,article7,article8,article9,article10)
            articleDb.saveArticles(list_oceanie)
        }
    }

    private fun query(continent : String): Array<Article> {
            return articleDb.requestArticleByContinent(continent).toTypedArray()
    }
}