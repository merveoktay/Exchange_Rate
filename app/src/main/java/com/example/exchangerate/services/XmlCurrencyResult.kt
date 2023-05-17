package com.example.exchangerate.services

import android.util.Log
import com.example.exchangerate.models.Currency
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class XmlCurrencyResult  {
    fun xmlCurrency() : List<Currency> {

        val arr = mutableListOf<Currency>()
        val url = "https://www.tcmb.gov.tr/kurlar/today.xml"

        val doc:Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
        val element :Elements=doc.getElementsByClass("Tarih_Date")
        for( item in element ) {
            val tarih=item.getElementsByTag("Tarih").text()
            Log.d("tarih",tarih)

        }
        val elements:Elements = doc.getElementsByTag("Currency")

        for( item in elements ) {

            val isim = item.getElementsByTag("Isim").text()
            val forexBuying = item.getElementsByTag("ForexBuying").text()
            val forexSelling = item.getElementsByTag("ForexSelling").text()
            val banknoteBuying = item.getElementsByTag("BanknoteBuying").text()
            val banknoteSelling = item.getElementsByTag("BanknoteSelling").text()

            val currency = Currency(isim, forexBuying, forexSelling, banknoteBuying, banknoteSelling);
            arr.add(currency)
        }
        return arr
    }
}