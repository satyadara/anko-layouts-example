package com.satyadara.ankolayouts.ui.navigation

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet.PARENT_ID
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import com.satyadara.ankolayouts.R
import com.satyadara.ankolayouts.helper.BottomNavigationViewHelper
import com.satyadara.ankolayouts.ui.fragment.BlankFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.bottomNavigationView
import org.jetbrains.anko.design.snackbar

class BottomNavActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var ui: BottomNavUI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = BottomNavUI()
        ui.setContentView(this)

        ui.bottomNav.inflateMenu(R.menu.activity_main_drawer)

        // Remove code below if you want enable shift mode
        BottomNavigationViewHelper.disableShiftMode(ui.bottomNav)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> supportFragmentManager.beginTransaction().replace(ui.fragment.id, BlankFragment()).commit()
            R.id.item2 -> supportFragmentManager.beginTransaction().replace(ui.fragment.id, BlankFragment()).commit()
            R.id.item3 -> supportFragmentManager.beginTransaction().replace(ui.fragment.id, BlankFragment()).commit()
            R.id.item4 -> supportFragmentManager.beginTransaction().replace(ui.fragment.id, BlankFragment()).commit()
            R.id.item5 -> supportFragmentManager.beginTransaction().replace(ui.fragment.id, BlankFragment()).commit()
        }
        return true
    }
}

class BottomNavUI : AnkoComponent<BottomNavActivity> {
    lateinit var layout: ConstraintLayout
    lateinit var bottomNav: BottomNavigationView
    lateinit var fragment: FrameLayout
    override fun createView(ui: AnkoContext<BottomNavActivity>) = ui.apply {
        layout = constraintLayout {
            id = View.generateViewId()
            fragment = frameLayout() {
                id = View.generateViewId()
            }
            bottomNav = bottomNavigationView {
                id = View.generateViewId()
                backgroundColor = R.color.primary_material_dark
                setOnNavigationItemSelectedListener(ui.owner)
            }

            applyConstraintSet {
                fragment {
                    connect(
                        TOP to TOP of PARENT_ID,
                        LEFT to LEFT of PARENT_ID,
                        RIGHT to RIGHT of PARENT_ID,
                        BOTTOM to TOP of bottomNav
                    )
                }

                bottomNav {
                    connect(
                        LEFT to LEFT of PARENT_ID,
                        RIGHT to RIGHT of PARENT_ID,
                        BOTTOM to BOTTOM of PARENT_ID
                    )
                }
            }
        }
    }.view

}
