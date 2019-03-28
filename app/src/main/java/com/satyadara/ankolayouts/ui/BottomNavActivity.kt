package com.satyadara.ankolayouts.ui

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import com.satyadara.ankolayouts.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.bottomNavigationView

class BottomNavActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var ui: BottomNavUI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = BottomNavUI()
        ui.setContentView(this)

        ui.bottomNav.inflateMenu(R.menu.activity_main_drawer)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> ui.textView.text = "item1"
            R.id.item2 -> ui.textView.text = "item2"
            R.id.item3 -> ui.textView.text = "item3"
            R.id.item4 -> ui.textView.text = "item4"
            R.id.item5 -> ui.textView.text = "item5"
        }
        return true
    }
}

class BottomNavUI : AnkoComponent<BottomNavActivity> {
    lateinit var layout: ConstraintLayout
    lateinit var bottomNav: BottomNavigationView
    lateinit var textView: TextView
    override fun createView(ui: AnkoContext<BottomNavActivity>) = ui.apply {
        layout = constraintLayout {
            textView = textView("Hello World!").lparams(wrapContent, wrapContent) {
                topToTop = PARENT_ID
                leftToLeft = PARENT_ID
                rightToRight = PARENT_ID
                bottomToBottom = PARENT_ID
            }
            bottomNav = bottomNavigationView {
                backgroundColor = R.color.primary_material_dark
                setOnNavigationItemSelectedListener(ui.owner)
            }.lparams(matchParent, wrapContent) {
                bottomToBottom = PARENT_ID
                leftToLeft = PARENT_ID
                rightToRight = PARENT_ID
            }
        }
    }.view

}
