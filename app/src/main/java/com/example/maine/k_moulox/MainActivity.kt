package com.example.maine.k_moulox

import android.media.MediaPlayer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.example.maine.k_moulox.tool.replace
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_cardview.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val i : Int = 20
    private lateinit var media: MediaPlayer

   // val kmouloxArray = arrayOf(AfficherKmoulox("Barbecue", R.drawable.kamoulox), AfficherKmoulox("Papillon", R.drawable.kamoulox))

    //public var items = Array<AfficherKmoulox>(4, { AfficherKmoulox() })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        media = MediaPlayer.create(this, R.raw.intro_kamoulox)
        media.start()


        fab.setOnClickListener { view ->
            alert("Envoyer un mail aux développeurs de cette application ?") {
                title = "Besoin d'aide ?"
                positiveButton("Oui"){
                    email("m.bensassi06@gmail.com", getString(R.string.app_name), "")}
                negativeButton("Annuler"){}
            }.show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    fun showToastJaune(view: View){
        browse("https://www.youtube.com/watch?v=8bDmeeGVNvc")
    }
    fun showToastVert(view: View){
        browse("https://buzzly.fr/50-phrases-pleines-de-sens-tirees-du-jeu-kamoulox-vous-tentez-le-tiramisu-37.html")
    }

    fun showToastViolet(view: View){
        media.start()
    }

    fun showToastBleu(view: View){
        alert("Les légumineuses ?") {
            title = "Question"
            positiveButton("Non, ma peluche m'a trompé"){ toast("Kamoulox !")}
            negativeButton("Oui, un remplaçant de la viande") { toast("Perdu") }
        }.show()

    }
    fun showToastRouge(view: View){
        share(getString(R.string.app_name), getString(R.string.app_name))
        toast("Partagez vos phrases les moins dénuées de sens !")
    }

    fun openDrawer(){
        drawer_layout.openDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                replace(FragmentCamera())
            }
            R.id.nav_cardview -> {
                replace(FragmentCardview())

            }
            R.id.nav_gridview -> {
                replace(FragmentGridView())

            }
            R.id.nav_mc -> {
                replace(FragmentMagicCircle())
            }
            R.id.nav_share -> {
                share(getString(R.string.app_name), getString(R.string.app_name))
            }
            R.id.nav_send -> {
                email("m.bensassi06@gmail.com", getString(R.string.app_name), "")
                email("alexigauchon@gmail.com", getString(R.string.app_name), "")
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
