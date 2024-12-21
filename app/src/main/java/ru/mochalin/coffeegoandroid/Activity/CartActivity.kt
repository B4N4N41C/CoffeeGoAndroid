package ru.mochalin.coffeegoandroid.Activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.mochalin.coffeegoandroid.adapter.CartAdapter
import ru.mochalin.coffeegoandroid.databinding.ActivityCartBinding
import ru.mochalin.coffeegoandroid.R
import ru.mochalin.coffeegoandroid.helper.ChangeNumberItemsListener
import ru.mochalin.coffeegoandroid.helper.ManagmentCart

class CartActivity : BaseActivity() {
    // Binding
    lateinit var binding:ActivityCartBinding
    // management cart
    lateinit var management: ManagmentCart
    private var tax:Double=0.0

    //..............................................//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        management = ManagmentCart(this)


        calculateCart()
        setVariable()
        initCartList()
    }

    private fun initCartList() {
        with(binding){
            cartView.layoutManager=LinearLayoutManager(this@CartActivity,LinearLayoutManager.VERTICAL,false)
            cartView.adapter=CartAdapter(management.getListCart(),this@CartActivity,object : ChangeNumberItemsListener{
                override fun onChanged() {
                    calculateCart()
                }

            })
        }


    }

    private fun setVariable() {
        binding.backButton.setOnClickListener{
            finish()
        }
    }

    private fun calculateCart() {
        val percentTax = 0.02
        val delivey = 15.0
        tax = Math.round((management.getTotalFee()*percentTax)*100)/100.0
        val total = Math.round((management.getTotalFee()+tax+delivey)*100)/100
        val itemTotal = Math.round(management.getTotalFee()*100)/100


        with(binding){
            totalFeeText.text = "$$itemTotal"
            taxText.text = "$$tax"
            deliveryText.text = "$$delivey"
            totalText.text = "$$total"

        }
    }
}