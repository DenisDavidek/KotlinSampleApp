package com.example.denisdavidek.kotlintest



import android.app.LoaderManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Loader
import android.net.Uri

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : LoaderManager.LoaderCallbacks<VideoZNatacania>, AppCompatActivity()  {
    private var youtubeVideoId : String = ""

    override fun onLoadFinished(p0: Loader<VideoZNatacania>?, p1: VideoZNatacania) {

 if (!p1.url.isEmpty() && p1.url.startsWith("https")) {

     val newString = p1.getUrl().split("embed/")
     youtubeVideoId = newString[1]
 }
   }

    override fun onLoaderReset(p0: Loader<VideoZNatacania>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateLoader(p0: Int, p1: Bundle): Loader<VideoZNatacania> {
      return MainLoader(applicationContext,p1)
        }


    /*    var a: Int? = null
    val aa: Int*/
    var a = 0;
    var b = 0;
    var globalOperator = "";



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        textView.setText("len tak");

getVideoData()

        fab_test.setOnClickListener { view ->
            Snackbar.make(view, Greeter("testKotlin").greet() + Greeter("").max(4, 5), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

            val intent = Intent(this,RecyclerViewActivity::class.java)
            intent.putExtra("textMessage", "test")
            startActivity(intent)

        }
        btn_plus.setOnClickListener { view ->
            globalOperator = nastavOperator(btn_plus.text.toString())
        }

        btn_minus.setOnClickListener { _ ->
            globalOperator = nastavOperator(btn_minus.text.toString())
        }

        btn_multiplication.setOnClickListener { _ ->
            globalOperator = nastavOperator(btn_multiplication.text.toString())
        }

        btn_division.setOnClickListener { _ ->
            globalOperator = nastavOperator(btn_division.text.toString())
        }
        floatingActionButton.setOnClickListener { view ->
            zobrazVideo(view, youtubeVideoId)
        }

        btn_spocitaj.setOnClickListener { view ->
            try {
                a = edt_first_number.text.toString().toInt()
                b = edt_second_number.text.toString().toInt()


                var c = vypocitaj().toString()

                textView.text = c
            } catch (e: NumberFormatException) {
                e.printStackTrace();
            }
        }
    }


    fun zobrazVideo(view: View, id: String) {
        /*        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra(VIDEO_URL_KEY,"https://www.youtube.com/watch?v=xPrDEBnFAzY");
        startActivity(intent);*/
        // https://www.youtube.com/embed/xPrDEBnFAzY

        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id))
        val webIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id))
        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }

    }

    fun getVideoData() {

        var argsBundle = Bundle()
        argsBundle.putString("testKey","https://snk.coop.sk/spot.json")



        var test = loaderManager.getLoader<VideoZNatacania>(33)
        if (test == null) {
            loaderManager.initLoader(33,argsBundle, this)
        } else {
            loaderManager.restartLoader(33,argsBundle,this)
        }
        /* loaderManager.restartLoader(33,null,test)*/


    }


    fun vypocitaj(): Int {
        when (globalOperator) {
            "+" -> return a + b
            "-" -> return a - b
            "*" -> return a * b
            "/" -> return a / b

        }
        return 0
    }

    fun nastavOperator(operator: String): String {

        var localOperator = "";
        when (operator) {
            "+" -> localOperator = operator
            "-" -> localOperator = operator
            "*" -> localOperator = operator
            "/" -> localOperator = operator

        }
        return localOperator
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
