package com.example.exchangerate

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.exchangerate.services.XmlCurrencyResult
import java.text.DateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date


class MainActivity : AppCompatActivity() {
    lateinit var btnSelectCurrency:Button
    lateinit var txtForexBuying:TextView
    lateinit var txtForexSelling:TextView
    lateinit var txtBanknoteBuying:TextView
    lateinit var txtBanknoteSelling:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         getSupportActionBar()!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.second_color)));


        btnSelectCurrency=findViewById(R.id.btnSelectCurrency)
        btnSelectCurrency.setOnClickListener(btnOnClickListener)
        
    }

    private val btnOnClickListener = View.OnClickListener {
        txtForexBuying=findViewById(R.id.txtForexBuying)
        txtForexSelling=findViewById(R.id.txtForexSelling)
        txtBanknoteBuying=findViewById(R.id.txtBanknoteBuying)
        txtBanknoteSelling=findViewById(R.id.txtBanknoteSelling)


        val popupMenu=PopupMenu(this,btnSelectCurrency)
        popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)

        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
            when(item.itemId) {
                R.id.dolar -> {
                    currencyData(item.title as String)
                    btnSelectCurrency.text=item.title
                }
                R.id.euro -> {
                    currencyData(item.title as String)
                    btnSelectCurrency.text=item.title
                }
                R.id.ruble -> {
                    currencyData(item.title as String)
                    btnSelectCurrency.text=item.title
                }
                R.id.riyal-> {
                    currencyData(item.title as String)
                    btnSelectCurrency.text=item.title
                }
                R.id.rupi->{
                     currencyData(item.title as String)
                    btnSelectCurrency.text=item.title
                }
                R.id.yen-> {
                    currencyData(item.title as String)
                    btnSelectCurrency.text=item.title
                }
                R.id.won-> {
                    currencyData(item.title as String)
                    btnSelectCurrency.text=item.title
                }
            }
            true
        })
        popupMenu.show()
    }


    private fun currencyData(isim:String){

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val currencyData=XmlCurrencyResult()
        val arr = currencyData.xmlCurrency()

        for( item in arr ) {
            if(isim==item.Isim){
                txtForexBuying.text=item.ForexBuying
                txtForexSelling.text=item.ForexSelling
                txtBanknoteBuying.text=item.BanknoteBuying
                txtBanknoteSelling.text=item.BanknoteSelling
            }
        }
    }


}