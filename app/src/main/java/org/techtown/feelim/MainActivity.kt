package org.techtown.feelim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        fab_btn=findViewById(R.id.fab_btn)
        fab_btn.setOnClickListener{
            val intent =Intent(this,newFeelim::class.java)
            startActivity(intent)
        }

        val movielist1= arrayListOf(
            preference(R.drawable.bilie,"빌리엘리어트"), preference(R.drawable.her,"HER"),
            preference(R.drawable.aria,"아리아"), preference(R.drawable.borntobeblue,"본투비블루"),
            preference(R.drawable.callmeby,"콜미바이유얼네임")
        )

        binding.rvProfile1.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile1.setHasFixedSize(true)
        binding.rvProfile1.adapter=preferAdapter(movielist1)

        val movielist2= arrayListOf(
            preference(R.drawable.carol,"CAROL"), preference(R.drawable.frank,"프랭크"),
            preference(R.drawable.jaeky,"재키"), preference(R.drawable.loud,"라우더 댄 밤즈"),
            preference(R.drawable.sprout,"sprout")
        )
        binding.rvProfile2.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile2.setHasFixedSize(true)
        binding.rvProfile2.adapter=preferAdapter(movielist2)

        val movielist3= arrayListOf(
            preference(R.drawable.carol,"CAROL"), preference(R.drawable.frank,"프랭크"),
            preference(R.drawable.jaeky,"재키"), preference(R.drawable.loud,"라우더 댄 밤즈"),
            preference(R.drawable.sprout,"sprout")
        )
        binding.rvProfile3.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile3.setHasFixedSize(true)
        binding.rvProfile3.adapter=preferAdapter(movielist3)

        val movielist4= arrayListOf(
            preference(R.drawable.bilie,"빌리엘리어트"), preference(R.drawable.her,"HER"),
            preference(R.drawable.aria,"아리아"), preference(R.drawable.borntobeblue,"본투비블루"),
            preference(R.drawable.callmeby,"콜미바이유얼네임")
        )

        binding.rvProfile4.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile4.setHasFixedSize(true)
        binding.rvProfile4.adapter=preferAdapter(movielist4)
    }
}