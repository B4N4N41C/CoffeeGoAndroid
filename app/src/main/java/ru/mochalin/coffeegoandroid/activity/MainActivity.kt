package ru.mochalin.coffeegoandroid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import ru.mochalin.coffeegoandroid.adapter.CategoryAdapter
import ru.mochalin.coffeegoandroid.adapter.OffersAdapter
import ru.mochalin.coffeegoandroid.adapter.PopularAdapter
import ru.mochalin.coffeegoandroid.databinding.ActivityMainBinding
import ru.mochalin.coffeegoandroid.viewModel.MainViewModel

class MainActivity : BaseActivity() {
    // Binding
    lateinit var binding: ActivityMainBinding
    // View Model
    private val viewModel=MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategory()
        initPopular()
        initOffers()
        bottomMenu()
    }

    private fun bottomMenu() {
        binding.cartButton.setOnClickListener{
            startActivity(Intent(this,CartActivity::class.java))
        }
    }

    private fun initOffers() {
        binding.progressBarOffers.visibility= View.VISIBLE

        viewModel.offers.observe(this, Observer {
            binding.recyclerViewOffers.layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            binding.recyclerViewOffers.adapter=OffersAdapter(it)
            binding.progressBarOffers.visibility=View.GONE
        })
        viewModel.loadOffers()

    }

    private fun initPopular() {
        binding.progressBarCategory.visibility= View.VISIBLE

        viewModel.popular.observe(this, Observer {
            binding.recyclerViewPopular.layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            binding.recyclerViewPopular.adapter=PopularAdapter(it)
            binding.progressbarPopular.visibility=View.GONE
        })
        viewModel.loadPopular()

    }

    private fun initCategory() {
        binding.progressBarCategory.visibility= View.VISIBLE

        viewModel.category.observe(this, Observer {
            binding.recyclerViewCategory.layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            binding.recyclerViewCategory.adapter=CategoryAdapter(it)
            binding.recyclerViewCategory.visibility=View.VISIBLE
            binding.progressBarCategory.visibility=View.GONE
        })
        viewModel.loadCategory()
    }
}