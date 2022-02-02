package org.techtown.feelim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.techtown.feelim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var fab_btn: FloatingActionButton
    var mbinding:ActivityMainBinding?=null
    val binding get()=mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //버튼 클릭시 글쓰기 창으로 이동
        fab_btn=findViewById(R.id.fab_btn)
        fab_btn.setOnClickListener{
            val intent =Intent(this, newFeelim::class.java)
            startActivity(intent)
        }
        //리사이클러뷰에 들어갈 영화정보데이터(포스터,이름,개봉일,장르) arraylist로 넣어줌
        val movielist1= arrayListOf(
            preference(R.drawable.bilie,"빌리엘리어트","드라마 영국,프랑스","110분","2001.02.17"), preference(R.drawable.wonder,"원더","드라마 미국","113분","2017.12.27"),
                preference(R.drawable.moodindigo,"무드인디고","드라마 프랑스,벨기에","95분","2014.12.11"), preference(R.drawable.her,"HER","로맨스 미국","125분","2014.05.22"),

        )

        binding.rvProfile1.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false) //각각의 리사이클러뷰는 가로로 나열
        binding.rvProfile1.setHasFixedSize(true)
        binding.rvProfile1.adapter=preferAdapter(movielist1)

        val movielist2= arrayListOf(
                preference(R.drawable.dunkirk,"덩케르트","액션 영국,프랑스","106분","2017.02.20"), preference(R.drawable.jaeky,"재키","드라마 미국,칠레","100분","2017.01.25"),
                preference(R.drawable.aria,"아리아","드라마 프랑스","103분","2015.04.03"),preference(R.drawable.spiderman,"스파이더맨:노 웨이 홈","액션 미국","148분","2021.12.15")
        )
        binding.rvProfile2.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile2.setHasFixedSize(true)
        binding.rvProfile2.adapter=preferAdapter(movielist2)


        val movielist3= arrayListOf(
            preference(R.drawable.kingmaker,"킹메이커","드라마 한국","123분","2022.01.26"), preference(R.drawable.sea,"해적:도깨비 깃발","모험 한국","125분","2022.01.26"),
            preference(R.drawable.spiderman,"스파이더맨:노 웨이 홈","액션 미국","148분","2021.12.15"), preference(R.drawable.moonlight,"MOONLIGHT","드라마 미국","111분","2017.02.22")
        )
        binding.rvProfile3.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile3.setHasFixedSize(true)
        binding.rvProfile3.adapter=preferAdapter(movielist3)

        val movielist4= arrayListOf(
            preference(R.drawable.callmeby,"콜 미 바이 유어 네임","로맨스 이탈리아,프랑스","132분","2018.03.22"), preference(R.drawable.pransisha,"프란시스하","로맨스/멜로 미국","86분","2014.09.24"),
            preference(R.drawable.pig,"옥자","어드벤처 한국,미국","120분","2017.06.29"), preference(R.drawable.wendy,"스탠바이,웬디","코미디/드라마 미국","93분","2018.05.30"),
            preference(R.drawable.yourname,"너의 이름은","애니메이션 일본","106분","2017.01.04")
        )

        binding.rvProfile4.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile4.setHasFixedSize(true)
        binding.rvProfile4.adapter=preferAdapter(movielist4)
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