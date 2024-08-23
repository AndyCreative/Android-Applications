package com.example.fl_rb_sb_pb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pb : ProgressBar = findViewById(R.id.progressBar)

        Thread(Runnable {
            var count = 0
            while (count<=100){
                try{
                    Thread.sleep(100)
                    count += 1
                    pb.setProgress(count)
                    pb.secondaryProgress = count + 10
                }catch (e:Exception){}
            }
            if(count>=100){
                var i = Intent(this,MainActivity2::class.java)
                startActivity(i)
            }
        }).start()

    }
}