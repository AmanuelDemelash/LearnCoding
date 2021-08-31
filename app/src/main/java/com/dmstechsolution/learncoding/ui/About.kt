package com.dmstechsolution.learncoding.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dmstechsolution.learncoding.R
import com.vansuita.materialabout.builder.AboutBuilder
import com.vansuita.materialabout.views.AboutView

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        val view: AboutView = AboutBuilder.with(this)
            .setPhoto(R.drawable.amana)
            .setCover(R.drawable.life)
            .setName("Amanuel Demelash")
            .setSubTitle("Mobile Developer")
            .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
            .setAppIcon(R.mipmap.ic_launcher)
            .setAppName(R.string.app_name)
            .addGitHubLink("https://github.com/AmanuelDemelash")
            .addFacebookLink("")
            .addFiveStarsAction()
            .addInstagramLink("")
                .addWebsiteLink("https://www.dmstechsolution.com")
                .addGooglePlayStoreLink("https://play.google.com/store/apps/details?id=$packageName")
            .setVersionNameAsAppSubTitle()
            .addShareAction(R.string.app_name)
            .setWrapScrollView(true)
            .setLinksAnimated(true)
            .setShowAsCard(true)
            .build()
        setContentView(view)
    }

}