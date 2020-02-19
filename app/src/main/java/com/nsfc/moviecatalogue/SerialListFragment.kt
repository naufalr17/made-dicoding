package com.nsfc.moviecatalogue


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsfc.moviecatalogue.model.SerialModel
import com.nsfc.moviecatalogue.model.SerialRvAdapter
import kotlinx.android.synthetic.main.fragment_serial_list.*

/**
 * A simple [Fragment] subclass.
 */
class SerialListFragment : Fragment() {

    private val listSerial = ArrayList<SerialModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_serial_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_serial.setHasFixedSize(true)

        listSerial.addAll(getListMovie())
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rv_serial.layoutManager = LinearLayoutManager(context)
        val serialAdapter = SerialRvAdapter(listSerial)
        rv_serial.adapter = serialAdapter
    }

    @SuppressLint("Recycle")
    fun getListMovie(): ArrayList<SerialModel> {
        val serialPoster = resources.obtainTypedArray(R.array.serial_poster)
        val serialTitle = resources.getStringArray(R.array.serial_title)
        val serialDate = resources.getStringArray(R.array.serial_date)
        val serialDesc = resources.getStringArray(R.array.serial_desc)
        val serialScore = resources.getStringArray(R.array.serial_user_score)
        val serialStudio = resources.getStringArray(R.array.serial_studio)
        val serialDirector = resources.getStringArray(R.array.serial_director)

        val serialList = ArrayList<SerialModel>()
        for (position in serialTitle.indices) {
            val serial = SerialModel(
                serialPoster.getResourceId(position, -1),
                serialTitle[position],
                serialDate[position],
                serialDesc[position],
                serialScore[position],
                serialStudio[position],
                serialDirector[position]
            )
            serialList.add(serial)
        }

        return serialList
    }


}
