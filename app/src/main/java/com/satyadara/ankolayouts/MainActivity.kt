package com.satyadara.ankolayouts

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.satyadara.ankolayouts.ui.dashboard.DashboardActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.button
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }
}

class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = ui.apply {
        constraintLayout {
            button("Drawer Layout") {

            }
        }
    }.view

}

