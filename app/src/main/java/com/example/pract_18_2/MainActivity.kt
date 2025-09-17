package com.example.pract_18_2

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.SharedMemory
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.pract_18_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences
    private lateinit var clicksText : TextView
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        sharedPref = getSharedPreferences("CountPref", MODE_PRIVATE)

        counter = sharedPref.getInt("CountPref", 0)

        clicksText = findViewById(R.id.ClicksText)

        clicksText.text = "Нажатий $counter"

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Вы нажали на FloatingActionButton", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
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


    fun OnClick(view: View) {

        Snackbar.make(
            view,
            "Стандартный Snackbar",
            Snackbar.LENGTH_LONG

        ).show()

    }

    fun OnClick2(view: View) {

        var snackbar = Snackbar.make(
            view,
            "Стандартная кнопка",
            Snackbar.LENGTH_LONG

        )

        snackbar.setAction("Кнопка", View.OnClickListener {
            Toast.makeText(
                this,
                "Кнопка нажата",
                Toast.LENGTH_SHORT
            ).show()
        })
        snackbar.setActionTextColor(Color.MAGENTA)
        snackbar.show()

    }
    fun OnClick3(view: View) {

        counter++

        var snackbar = Snackbar.make(
            view,
            "Нестандартная кнопка Нажата: $counter раз",
            Snackbar.LENGTH_LONG,

        )
        snackbar.setTextColor(Color.GREEN)
        snackbar.show()
        clicksText.text = "Нажатий $counter"

        with(sharedPref.edit())
        {
            putInt("CountPref", counter)
            apply()
        }

    }
}