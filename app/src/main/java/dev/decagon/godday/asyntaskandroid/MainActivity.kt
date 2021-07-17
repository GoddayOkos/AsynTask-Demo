package dev.decagon.godday.asyntaskandroid

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    private lateinit var mProgressBar: ProgressBar
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mProgressBar = findViewById(R.id.progress_horizontal)
        button = findViewById(R.id.btn)

        button.setOnClickListener { MAsyncTask().execute(10) }
    }

    private inner class MAsyncTask : AsyncTask<Int, Int, Void>() {

        override fun doInBackground(vararg params: Int?): Void {
            for (i in 0..params[0]!!) {
                publishProgress(i)
                SystemClock.sleep(500)
            }
            return Void.TYPE.newInstance()
        }

        override fun onProgressUpdate(vararg values: Int?) {
            mProgressBar.progress = values[0]!!
        }
    }
}