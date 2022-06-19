package com.nfttki.foodies

import android.app.ActionBar
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.View
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginEnd

class HomeActivity : AppCompatActivity() {

    var tabSelectedId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        val categoryTabs = findViewById<LinearLayout>(R.id.category_tabs)
        createCategoryTab(categoryTabs, "Пицца", true)
        createCategoryTab(categoryTabs, "Роллы", false)
        createCategoryTab(categoryTabs, "Бургеры", false)
        createCategoryTab(categoryTabs, "Паста", false)
        createCategoryTab(categoryTabs, "Супы", false)
        createCategoryTab(categoryTabs, "Напитки", false)
        createCategoryTab(categoryTabs, "Десерты", false)
    }

    private fun createCategoryTab(tab:LinearLayout, tabName:String, selected:Boolean = false)
    {
        val tView = TextView(this)
        tView.id = View.generateViewId()
        tView.text = tabName
        tView.typeface = Typeface.DEFAULT_BOLD;
        tView.gravity = Gravity.CENTER;

        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
        params.marginEnd = 8;
        tView.minWidth = 64
        tView.layoutParams = params;
        tView.setPadding(32, 0, 32, 0)

        setTabCategoryState(tView, selected)

        tView.setOnClickListener {
            setTabCategoryState(tabSelectedId, false)
            setTabCategoryState(tView.id, true)
        }

        tab.addView(tView)
    }

    private fun setTabCategoryState(tabId:Int, selected:Boolean)
    {
        setTabCategoryState(findViewById(tabId), selected)
    }

    private fun setTabCategoryState(tView:TextView, selected:Boolean)
    {
        if (selected)
        {
            println("Tab selected")
            tabSelectedId = tView.id
            tView.setTextColor(ContextCompat.getColor(this, R.color.white))
            tView.background = ContextCompat.getDrawable(this, R.drawable.tab_selected)
        }
        else
        {
            tView.setTextColor(ContextCompat.getColor(this, R.color.black))
            tView.background = ContextCompat.getDrawable(this, R.drawable.tab_deselected)
        }
    }
}