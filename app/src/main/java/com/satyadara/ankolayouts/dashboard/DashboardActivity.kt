package com.satyadara.ankolayouts.dashboard

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.satyadara.ankolayouts.R
import com.satyadara.ankolayouts.ui.BottomNavActivity
import com.satyadara.ankolayouts.ui.DrawerNavActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk21.coroutines.onClick

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DashboardUI().setContentView(this)
    }
}

class DashboardUI : AnkoComponent<DashboardActivity> {
    override fun createView(ui: AnkoContext<DashboardActivity>) = ui.apply {
        constraintLayout {
            val btnDrawer = button(context.getString(R.string.nav_drawer)) {
                id = View.generateViewId()
                onClick { ui.owner.startActivity(Intent(ui.owner, DrawerNavActivity::class.java)) }
            }.lparams(matchParent, wrapContent) {
                topToTop = PARENT_ID
                leftToLeft = PARENT_ID
                rightToRight = PARENT_ID
            }
            
            button(context.getString(R.string.bottom_nav)) {
                onClick { ui.owner.startActivity(Intent(ui.owner, BottomNavActivity::class.java)) }
            }.lparams(matchParent, wrapContent) {
                topToBottom = btnDrawer.id
                leftToLeft = PARENT_ID
                rightToRight = PARENT_ID
            }
        }
    }.view

}