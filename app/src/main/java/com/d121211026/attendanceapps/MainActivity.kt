package com.d121211026.attendanceapps

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.skyfishjy.library.RippleBackground

class MainActivity : AppCompatActivity() {

    private lateinit var rippleBackground: RippleBackground
    private lateinit var tvScanning: TextView
    private lateinit var tvCheckInSuccess: TextView
    private lateinit var fabCheckIn: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        onClick()

        rippleBackground = findViewById(R.id.main)
        tvScanning = findViewById(R.id.tvScanning)
        tvCheckInSuccess = findViewById(R.id.tvCheckInSuccess)
        fabCheckIn = findViewById(R.id.fabCheckIn)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun onClick() {
        fabCheckIn.setOnClickListener{
            loadScanLocation()
            Handler().postDelayed({
                stopScanLocation()
            }, 4000)
        }
    }

    private fun loadScanLocation() {
        rippleBackground.startRippleAnimation()
        tvScanning.visibility = View.VISIBLE
        tvCheckInSuccess.visibility = View.GONE
    }
    private fun stopScanLocation() {
        rippleBackground.stopRippleAnimation()
        tvScanning.visibility = View.GONE
    }
}