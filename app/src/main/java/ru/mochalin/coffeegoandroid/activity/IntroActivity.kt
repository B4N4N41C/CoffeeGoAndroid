package ru.mochalin.coffeegoandroid.activity

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.mochalin.coffeegoandroid.MainActivity
import ru.mochalin.coffeegoandroid.R
import ru.mochalin.coffeegoandroid.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener{
            startActivity(Intent(this@IntroActivity,MainActivity::class.java))
        }

    }
}