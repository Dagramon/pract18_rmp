package com.example.pract_18_2

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.pract_18_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


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
        snackbar.setAction("Кнопка", View.OnClickListener {  })
        snackbar.show()

    }
    fun OnClick3(view: View) {

        var snackbar = Snackbar.make(
            view,
            "Нестандартная кнопка",
            Snackbar.LENGTH_LONG

        )
        snackbar.setAction("Кнопка", View.OnClickListener {  })
        snackbar.setActionTextColor(Color.MAGENTA)
        snackbar.show()

    }
}