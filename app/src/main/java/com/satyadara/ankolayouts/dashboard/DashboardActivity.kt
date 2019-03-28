package com.satyadara.ankolayouts.dashboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.setContentView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DashboardActivityUI().setContentView(this)
    }
}

class DashboardActivityUI : AnkoComponent<DashboardActivity> {
    override fun createView(ui: AnkoContext<DashboardActivity>) = ui.apply {
        constraintLayout {

        }
    }.view

}