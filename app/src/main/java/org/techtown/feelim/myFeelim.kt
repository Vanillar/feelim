package org.techtown.feelim

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import org.techtown.feelim.DBManager
import org.techtown.feelim.MainActivity
import org.techtown.feelim.R

class myFeelim : AppCompatActivity() {
    lateinit var logo: View

    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var layout: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_feelim)

        dbManager = DBManager(this, "movieList", null, 1)
        sqlitedb = dbManager.readableDatabase

        logo = findViewById(R.id.logo)

        layout = findViewById(R.id.myFeelimLL)


        // 로고 (클릭 시 메인 화면으로 이동)
        // 위치만 수정 필요 (Home)
        logo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var cursor: Cursor
        cursor = sqlitedb.rawQuery("SELECT * FROM movieList", null)

        var num: Int = 0
        var num2: Int = 0
        var num3: Int = 0


        while (cursor.moveToNext()) {

            var FdbMovieTitle = cursor.getString(cursor.getColumnIndex("mvTitle")).toString()
            var FdbStartDate = cursor.getString(cursor.getColumnIndex("mvStartDate")).toString()
            var FdbFinishDate = cursor.getString(cursor.getColumnIndex("mvFinishDate")).toString()
            var FdbGenre = cursor.getInt(cursor.getColumnIndex("mvGenre")).toInt()
            var FdbPlace = cursor.getInt(cursor.getColumnIndex("mvPlace")).toInt()


            var layout_item: LinearLayout = LinearLayout(this)
            layout_item.orientation = LinearLayout.VERTICAL
            layout_item.id = num
            layout_item.setBackgroundColor(Color.GRAY)

            var layout_item_01: LinearLayout = LinearLayout(this)
            layout_item_01.orientation = LinearLayout.HORIZONTAL
            layout_item_01.id = num2
            layout_item.addView(layout_item_01)

            var layout_item_02: LinearLayout = LinearLayout(this)
            layout_item_02.orientation = LinearLayout.HORIZONTAL
            layout_item_02.id = num3
            layout_item.addView(layout_item_02)

            var tvMovieTitle: TextView = TextView(this)
            tvMovieTitle.text = FdbMovieTitle
            layout_item_01.addView(tvMovieTitle)
            tvMovieTitle.setTextColor(Color.WHITE)
            num2++

            var tvStartDate: TextView = TextView(this)
            tvStartDate.text = FdbStartDate
            layout_item_02.addView(tvStartDate)
            tvMovieTitle.setTextColor(Color.WHITE)
            num3++

            var tvFinishDate: TextView = TextView(this)
            tvFinishDate.text = FdbFinishDate
            layout_item_02.addView(tvFinishDate)
            tvMovieTitle.setTextColor(Color.WHITE)
            num3++

            /*
            var tvGenre: TextView = TextView(this)
            tvGenre.text = R.array.genreList
            layout_item.addView(tvGenre)

            var tvMovieTitle: TextView = TextView(this)
            tvMovieTitle.text = FdbMovieTitle
            layout_item.addView(tvMovieTitle)
            */

            layout_item.setOnClickListener {
                val intent = Intent(this, infoFeelim::class.java)
                intent.putExtra("intent_name", FdbMovieTitle)
                startActivity(intent)
            }

            layout.addView(layout_item)
            num++;

        }
        cursor.close()
        sqlitedb.close()
        dbManager.close()
    }

    //메뉴 추가
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.item1 -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.item2 -> {
                val intent = Intent(this, myFeelim::class.java)
                startActivity(intent)
                true
            }
            else ->super.onOptionsItemSelected(item)
        }
    }


}

