package com.satyadara.ankolayouts.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import com.satyadara.ankolayouts.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.support.v4._DrawerLayout
import org.jetbrains.anko.support.v4.drawerLayout

class DrawerNavActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var ui: DrawerNavUI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = DrawerNavUI()
        ui.setContentView(this)

        setSupportActionBar(ui.toolbar)
        val toggle = ActionBarDrawerToggle(
            this, ui.drawer, ui.toolbar, R.string.open, R.string.close
        )
        ui.drawer.setDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> ui.drawer.snackbar("Item 1")
            R.id.item2 -> ui.drawer.snackbar("Item 2")
            R.id.item3 -> ui.drawer.snackbar("Item 3")
        }
        ui.drawer.closeDrawer(GravityCompat.START)
        return true
    }
}

class DrawerNavUI : AnkoComponent<DrawerNavActivity> {
    lateinit var drawer: DrawerLayout
    lateinit var toolbar: android.support.v7.widget.Toolbar
    override fun createView(ui: AnkoContext<DrawerNavActivity>) = ui.apply {
        drawer = drawerLayout {
            fitsSystemWindows = true
            createAppBar(ui)
            createNavigationView(ui)
        }
    }.view

    fun _DrawerLayout.createAppBar(ui: AnkoContext<DrawerNavActivity>) {
        coordinatorLayout()
        fitsSystemWindows = false

        appBarLayout {
            toolbar = toolbar {
                title = context.getString(R.string.nav_drawer)
                backgroundColor = R.color.primary_material_dark
            }.lparams(width = matchParent)

        }.lparams(width = matchParent, height = matchParent)
            .applyRecursively { view ->
                when (view) {
                    is TextView -> view.textSize = 24f
                }
            }
    }

    fun _DrawerLayout.createNavigationView(ui: AnkoContext<DrawerNavActivity>) {
        navigationView {
            fitsSystemWindows = true
            setNavigationItemSelectedListener(ui.owner)
            inflateMenu(R.menu.activity_main_drawer)
        }.lparams(height = matchParent, gravity = GravityCompat.START)
    }
}