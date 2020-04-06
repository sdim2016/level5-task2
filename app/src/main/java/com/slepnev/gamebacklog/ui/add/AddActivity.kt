package com.slepnev.gamebacklog.ui.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.slepnev.gamebacklog.R
import com.slepnev.gamebacklog.model.Game

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.time.LocalDate
import java.util.*

const val EXTRA_GAME ="EXTRA_GAME"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            onSaveClick()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun onSaveClick() {
        if (etTitle.text.toString().isNotBlank() &&
            etPlatform.text.toString().isNotBlank() &&
            etDay.text.toString().isNotBlank() &&
            etMonth.text.toString().isNotBlank() &&
            etYear.text.toString().isNotBlank()) {
            val cal = Calendar.getInstance()
            cal.set(etYear.text.toString().toInt(),
                etMonth.text.toString().toInt()-1, etDay.text.toString().toInt())
            val game = Game(etTitle.text.toString(), etPlatform.text.toString(), cal.time)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_GAME, game)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The game cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }

}
