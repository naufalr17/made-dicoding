package com.nsfc.moviecatalogue

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nsfc.moviecatalogue.model.SerialModel
import kotlinx.android.synthetic.main.activity_detail_serial.*

class DetailSerialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_serial)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val serial = intent.getParcelableExtra("serial") as SerialModel

        Glide.with(this).load(serial.serial_image).into(ivs_poster)
        tvs_title.text = serial.serial_title
        tvs_date.text = serial.serial_date
        tvs_desc.text = serial.serial_desc
        tvs_score.text = serial.serial_user_score
        tvs_studio.text = serial.serial_studio
        tvs_director.text = serial.serial_director
    }

}
