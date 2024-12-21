package ru.mochalin.coffeegoandroid.Activity

import android.content.Intent
import android.os.Bundle

import ru.mochalin.coffeegoandroid.databinding.ActivityIntroBinding
import ru.mochalin.coffeegoandroid.Activity.MainActivity

class IntroActivity : BaseActivity() {

    // Use a lateinit var to initialize the binding property
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding property
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the start button's click listener
        binding.startButton.setOnClickListener {
            // Start MainActivity when the start button is clicked
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        }
    }
}
