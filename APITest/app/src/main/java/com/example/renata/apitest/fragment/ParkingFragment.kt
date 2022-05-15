package com.example.renata.apitest.fragment

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.renata.apitest.R
import kotlinx.android.synthetic.main.fragment_parking.*
import kotlinx.android.synthetic.main.fragment_parking.view.*

class ParkingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_parking, container, false)
        val view = inflater.inflate(R.layout.fragment_parking, container, false)

        view.etLicense.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                if (validaPlaca(s)) {
                    btnConfirm.isEnabled = true
                    Log.i("INFO", "renis 2 ")
                }
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                /*if (validaPlaca(s)) {
                    btnConfirm.isEnabled = true
                    Log.i("INFO", "renis 2 ")
                }*/
                Log.i("INFO", "renis 1 "+ s +" "+(s.length-1) +" "+if (validaPlaca(s) == true) btnConfirm.isEnabled=true else btnConfirm.isEnabled=false)
                Log.i("INFO", "renis 1 "+ s +" "+(s.length-1) +" "+if (validaPlaca(s) == true && s.length == 8) txtAlertError.visibility = View.GONE else txtAlertError.visibility = View.VISIBLE)
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

        view.btnConfirm.setOnClickListener {

            val dialogo = getActivity()?.let { Dialog(it) }
            dialogo!!.setContentView(R.layout.confirm_payment)
            /*val alertadd = AlertDialog.Builder(getActivity())
            val factory = LayoutInflater.from(getActivity())
            val view1: View = factory.inflate(R.layout.confirm_payment, null)*/
            val buttonConfirm = dialogo.findViewById<Button>(R.id.btnAlertConfirm)
            buttonConfirm.setOnClickListener { item ->
                dialogo.dismiss()
                val dialogo1 = getActivity()?.let { Dialog(it) }
                dialogo1!!.setContentView(R.layout.confirm_payment1)

                /*val imgBack = dialogo1.findViewById<ImageView>(R.id.imgConfirm2)
                imgBack.setOnClickListener { item ->
                    dialogo1.dismiss()
                    dialogo.dismiss()
                }*/
                dialogo1.create()
                dialogo1.show()
                /*val alertadd = AlertDialog.Builder(getActivity())
                val factory = LayoutInflater.from(getActivity())
                val view2: View = factory.inflate(R.layout.confirm_payment2, null)
                alertadd.setView(view2).show()*/
            }
            val txtAlertBack = dialogo.findViewById<TextView>(R.id.txtAlertBack)
            txtAlertBack.setOnClickListener { item ->
                dialogo.dismiss()
            }
            dialogo.show()
        }
        return view
    }


    fun validaPlaca(s: CharSequence): Boolean {
        var valido = true
        if (s.length != 8) {
            valido = false
        }
        for (i in s.indices) {
            println(s[i])
            if (i <= 2) {
                if (!s[i].isLetter()) {
                    valido = false
                    println("${s[i]} é numero  falso" + s.subSequence(0, i).toString() + " " + i)
                }
                println("${s[i]} correto" )
            }
            if (i == 3) {
                if (s[3] != '-') {
                    valido = false
                    println("${s[i]} é numero  falso" + s.subSequence(0, i).toString() + " " + i)

                }
            }
            if (i >= 4) {
                if (!(s[i] >= '0' && s[i] <= '9')) {
                    valido = false
                    println("${s[i]} é letra " + s.subSequence(4, i).toString() + " " + i)
                }
                println("${s[i]} correto" )
            }
        }
        return valido
    }
}