package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


public class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val p: EditText = findViewById(R.id.p)
        val t: EditText = findViewById(R.id.t)
        val price: TextView = findViewById(R.id.price)
        val tax: TextView = findViewById(R.id.tax)
        val head: TextView = findViewById(R.id.head)
        val enter: Button = findViewById(R.id.button)
        val result: TextView = findViewById(R.id.result)
        //global variable
        var flag: String = "tax"
        //here to create spinner
        val spinnerVal : Spinner = findViewById(R.id.spinner)
        val options= arrayOf("tax", "total")
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


            }
        enter.setOnClickListener(){view->
            var p: Int = p.text.toString().toInt();
            var t: Int =t.text.toString().toInt();
            if(flag =="tax")
                result.text = tax(p,t).toString();
            else
                result.text = total(p,t).toString();


        }


    }

    public fun tax(p: Int, t: Int): Int {
        return p * (t / 100)
    }

    public fun total(p: Int, t: Int): Int {
        return p + (p * (t / 100))
    }
}
