package com.freedomvpn.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var statusText: TextView
    private lateinit var connectButton: TextView
    private var isConnected = false

    private val backgroundColor = Color.rgb(14, 18, 30)
    private val accentColor = Color.rgb(62, 220, 140)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = backgroundColor
        window.navigationBarColor = backgroundColor

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(backgroundColor)
        }

        val title = TextView(this).apply {
            text = "FREEDOM VPN"
            textSize = 27f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "YOUR INTERNET, YOUR FREEDOM"
            textSize = 11f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        statusText = TextView(this).apply {
            text = "BELUM TERHUBUNG"
            textSize = 14f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        val serverText = TextView(this).apply {
            text = "🇺🇸  United States"
            textSize = 18f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(16, 24, 16, 24)
            setBackgroundColor(Color.rgb(29, 36, 52))
        }

        connectButton = TextView(this).apply {
            text = "CONNECT"
            textSize = 19f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.rgb(10, 25, 20))
            gravity = Gravity.CENTER
            setPadding(24, 24, 24, 24)
            setBackgroundColor(accentColor)
            setOnClickListener {
                showNotConnectedMessage()
            }
        }

        val note = TextView(this).apply {
            text = "Pilih server dan hubungkan VPN Anda.\nKoneksi VPN belum diaktifkan."
            textSize = 12f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        root.addView(title, params(280, 55))
        root.addView(subtitle, params(280, 35))
        root.addView(statusText, params(280, 65))
        root.addView(serverText, params(280, 65))
        root.addView(connectButton, params(240, 70))
        root.addView(note, params(280, 75))

        setContentView(root)
    }

    private fun params(width: Int, height: Int) =
        LinearLayout.LayoutParams(
            width,
            height
        ).apply {
            gravity = Gravity.CENTER
            bottomMargin = 12
        }

    private fun showNotConnectedMessage() {
        isConnected = false
        statusText.text = "BELUM TERHUBUNG"
        statusText.setTextColor(Color.LTGRAY)
        connectButton.text = "CONNECT"

        android.widget.Toast.makeText(
            this,
            "Mesin VPN belum dikonfigurasi.",
            android.widget.Toast.LENGTH_LONG
        ).show()
    }
}
