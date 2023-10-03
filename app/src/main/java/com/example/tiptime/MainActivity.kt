package com.example.tiptime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import com.example.tiptime.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.costOfService.setOnKeyListener { view, keycode, _ ->
            if (keycode == KeyEvent.KEYCODE_ENTER) {
                // Hide the keyboard
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                true
            }
            false
        }

        binding.B1.setOnClickListener{
            if(binding.costOfService.text.isNotEmpty()){
                var d:Double=binding.costOfService.text.toString().toDouble()
//                Toast.makeText(this,d,Toast.LENGTH_LONG).show()
                when(binding.group.checkedRadioButtonId){
                    R.id.R1->{
                        d *= 1.2
                    }
                    R.id.R2->{
                        d*=1.18
                    }
                    else -> {
                        d*=1.15
                    }
                }
                if(binding.s1.isChecked){
                    d=ceil(d)
                }
                binding.tipResult.text=d.toString()
            }
        }

    }

    fun abs():Boolean{
        return false
    }
}