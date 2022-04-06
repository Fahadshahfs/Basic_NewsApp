package com.simplenewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), listitemclicked {


    private lateinit var mAdapter: ListAdapter
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // RecyclerView needs to have a layout manager and an adapter to be instantiated

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview1)
        recyclerview.layoutManager = LinearLayoutManager(this)


        // connecting adapter to RecyclerView
        mAdapter = ListAdapter(this)
        recyclerview.adapter = mAdapter

        // Main Category call on app Start
        healthNews()


        // navigation Menu

        val drawerlayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        val navview = findViewById<NavigationView>(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navview.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.navhealth -> healthNews()
                R.id.navbusiness -> businessNews()
                R.id.navsports -> sportsNews()
                R.id.navscience -> scienceNews()
                R.id.navtech -> techNews()
                R.id.naventertain -> entertainmentNews()

            }
            drawerlayout.close()
            true
        }


        // Navigation Menu End


    }


    // Functions for different categiroes


    private fun sportsNews() {

        val url = "https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
        val progressbar = findViewById<ProgressBar>(R.id.loadingbar)
        progressbar.visibility = View.VISIBLE
        // Request for data
        val jsonobject = JsonObjectRequest(
            Request.Method.GET, url, null,

            // Response.Listener
            {
                val newsJSONArray = it.getJSONArray("articles")
                val newsArray = ArrayList<NewsData>()
                for (i in 0 until newsJSONArray.length()) {
                    val newsJsonObject = newsJSONArray.getJSONObject(i)
                    val newsdata = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"),

                        )
                    progressbar.visibility = View.GONE
                    newsArray.add(newsdata)

                }
                mAdapter.newsUpdate(newsArray)

            },
            //  Response.ErrorListener
            {

            }
        )
        MySingleTon.getInstance(this).addToRequestQueue(jsonobject)

    }

    private fun scienceNews() {
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/science/in.json"
        val progressbar = findViewById<ProgressBar>(R.id.loadingbar)
        progressbar.visibility = View.VISIBLE
        val jsonobject = JsonObjectRequest(
            Request.Method.GET, url, null,

            // Response.Listener
            {
                val newsJSONArray = it.getJSONArray("articles")
                val newsArray = ArrayList<NewsData>()
                for (i in 0 until newsJSONArray.length()) {
                    val newsJsonObject = newsJSONArray.getJSONObject(i)
                    val newsdata = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"),

                        )
                    progressbar.visibility = View.GONE
                    newsArray.add(newsdata)
                }
                mAdapter.newsUpdate(newsArray)
            },
            //  Response.ErrorListener
            {

            }
        )
        MySingleTon.getInstance(this).addToRequestQueue(jsonobject)

    }

    private fun techNews() {
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json"
        val progressbar = findViewById<ProgressBar>(R.id.loadingbar)
        progressbar.visibility = View.VISIBLE
        val jsonobject = JsonObjectRequest(
            Request.Method.GET, url, null,

            // Response.Listener
            {
                val newsJSONArray = it.getJSONArray("articles")
                val newsArray = ArrayList<NewsData>()
                for (i in 0 until newsJSONArray.length()) {
                    val newsJsonObject = newsJSONArray.getJSONObject(i)
                    val newsdata = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"),

                        )
                    progressbar.visibility = View.GONE
                    newsArray.add(newsdata)
                }
                mAdapter.newsUpdate(newsArray)
            },
            //  Response.ErrorListener
            {

            }
        )
        MySingleTon.getInstance(this).addToRequestQueue(jsonobject)

    }

    private fun entertainmentNews() {
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
        val progressbar = findViewById<ProgressBar>(R.id.loadingbar)
        progressbar.visibility = View.VISIBLE
        val jsonobject = JsonObjectRequest(
            Request.Method.GET, url, null,

            // Response.Listener
            {
                val newsJSONArray = it.getJSONArray("articles")
                val newsArray = ArrayList<NewsData>()
                for (i in 0 until newsJSONArray.length()) {
                    val newsJsonObject = newsJSONArray.getJSONObject(i)
                    val newsdata = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"),

                        )
                    progressbar.visibility = View.GONE
                    newsArray.add(newsdata)
                }
                mAdapter.newsUpdate(newsArray)
            },
            //  Response.ErrorListener
            {

            }
        )
        MySingleTon.getInstance(this).addToRequestQueue(jsonobject)

    }

    private fun businessNews() {
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/business/in.json"
        val progressbar = findViewById<ProgressBar>(R.id.loadingbar)
        progressbar.visibility = View.VISIBLE
        val jsonobject = JsonObjectRequest(
            Request.Method.GET, url, null,

            // Response.Listener
            {
                val newsJSONArray = it.getJSONArray("articles")
                val newsArray = ArrayList<NewsData>()
                for (i in 0 until newsJSONArray.length()) {
                    val newsJsonObject = newsJSONArray.getJSONObject(i)
                    val newsdata = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"),

                        )
                    progressbar.visibility = View.GONE
                    newsArray.add(newsdata)
                }
                mAdapter.newsUpdate(newsArray)
            },
            //  Response.ErrorListener
            {

            }
        )
        MySingleTon.getInstance(this).addToRequestQueue(jsonobject)

    }

    private fun healthNews() {
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
        val progressbar = findViewById<ProgressBar>(R.id.loadingbar)
        progressbar.visibility = View.VISIBLE
        val jsonobject = JsonObjectRequest(
            Request.Method.GET, url, null,

            // Response.Listener
            {
                val newsJSONArray = it.getJSONArray("articles")
                val newsArray = ArrayList<NewsData>()
                for (i in 0 until newsJSONArray.length()) {
                    val newsJsonObject = newsJSONArray.getJSONObject(i)
                    val newsdata = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"),

                        )
                    progressbar.visibility = View.GONE
                    newsArray.add(newsdata)
                }
                mAdapter.newsUpdate(newsArray)
            },
            //  Response.ErrorListener
            {

            }
        )
        MySingleTon.getInstance(this).addToRequestQueue(jsonobject)

    }

    // Functions for different categiries END


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onitemclicked(item: NewsData) {
        /* val builder =  CustomTabsIntent.Builder();
         val customTabsIntent = builder.build();
         customTabsIntent.launchUrl(this, Uri.parse(item.url)) */
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()

    }
}