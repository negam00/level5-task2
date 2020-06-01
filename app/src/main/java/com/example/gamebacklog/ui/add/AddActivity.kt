package com.example.gamebacklog.ui.add

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.gamebacklog.R
import com.example.gamebacklog.model.Game
import com.example.gamebacklog.ui.main.MainActivity
import com.example.gamebacklog.ui.main.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.util.*


class AddActivity : AppCompatActivity() {
    private val addGameViewModel: MainActivityViewModel by viewModels()
    private val cal: Calendar by lazy { Calendar.getInstance() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        fab.setOnClickListener { onClickedSaveGame() }
    }

    private fun onClickedSaveGame() {
        if (validateFields()) {
            convertToDate()
            addGameViewModel.addGame(
                Game(
                    title = etGameTitle.text.toString(),
                    platform = etGamePlatform.text.toString(),
                    releaseDate = cal.time
                )
            )

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun convertToDate() {
        val day = etGameDay.text.toString().toInt()
        val month = etGameMonth.text.toString().toInt() - 1
        val year = etGameYear.text.toString().toInt()

        cal.set(year, month, day)
    }

    private fun validateFields(): Boolean {
        if (
            etGameTitle.text.toString().isBlank() ||
            etGamePlatform.text.toString().isBlank() ||
            etGameDay.text.toString().isBlank() ||
            etGameMonth.text.toString().isBlank() ||
            etGameYear.text.toString().isBlank()
        ) {
            Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
            return false
        } else if (
            etGameDay.text.toString().toInt() !in 1..31 ||
            etGameMonth.text.toString().toInt() !in 1..12 ||
            etGameYear.text.toString().toInt() < cal.get(Calendar.YEAR)
        ) {
            Toast.makeText(this, "Please fill in a correct date", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
