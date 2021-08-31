package com.dmstechsolution.learncoding

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import com.dmstechsolution.learncoding.ui.About
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class DashBordeActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_borde)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
            }catch (error:android.content.ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
            }
        }
         drawerLayout= findViewById(R.id.drawer_layout)
         navView = findViewById(R.id.nav_view)
       val navController = findNavController(R.id.nav_host_fragment)

        val toogle=ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        navView.setNavigationItemSelectedListener(this)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.nav_home->{
                    supportActionBar!!.show()
                }
                R.id.nav_slideshow->{
                    supportActionBar!!.hide()
                }
                R.id.nav_gallery->{
                    supportActionBar!!.hide()
                }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.dash_borde, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_settings->{
                startActivity(Intent(this,About::class.java))
            }
        }
        return true
    }
    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment)
        when (navController.currentDestination!!.id) {
            R.id.nav_home -> {
                val alert=AlertDialog.Builder(this)
                alert.setTitle("Exit")
                alert.setMessage("Do you want to exit?")
                alert.setIcon(R.drawable.splashlogo)
                alert.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                    finishAffinity()
                }
                alert.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                    alert.setCancelable(true)
                }
                alert.setCancelable(false)
                alert.show()
            }
            R.id.nav_slideshow -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_slideshow_to_nav_home)
            }
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home->{
               drawerLayout.close()
            }
            R.id.rate->{
                drawerLayout.close()
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
                }catch (error:android.content.ActivityNotFoundException){
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
                }
            }
            R.id.share->{
                drawerLayout.close()
                val intent= Intent(Intent.ACTION_SEND)
                intent.type="app/"
                startActivity(Intent.createChooser(intent,"shear"))
            }
            R.id.close->{
                drawerLayout.close()
                val alert= AlertDialog.Builder(this)
                alert.setTitle("Exit")
                alert.setMessage("Do you want to exit?")
                alert.setIcon(R.drawable.splashlogo)
                alert.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                    finishAffinity()
                }
                alert.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                    alert.setCancelable(true)
                }
                alert.setCancelable(false)
                alert.show()
            }
            R.id.nav_gallery->{
                drawerLayout.close()
                startActivity(Intent(this,About::class.java))
            }
        }
        return true
    }
}