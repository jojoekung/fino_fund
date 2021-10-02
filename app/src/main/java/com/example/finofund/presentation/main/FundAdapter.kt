package com.example.finofund.presentation.main

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finofund.R
import com.example.finofund.data.Fund
import com.example.finofund.databinding.ItemFundLayoutBinding
import java.text.SimpleDateFormat
import java.util.*

class FundAdapter : RecyclerView.Adapter<FundAdapter.FundHolder>() {

    private val fund = arrayListOf<Fund>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FundHolder {
        val binding =
            ItemFundLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return FundHolder(binding)
    }

    override fun onBindViewHolder(holder: FundHolder, position: Int) {
        holder.onBind(fund[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return fund.size
    }

    fun addFund(data: List<Fund>) {
        fund.clear()
        fund.addAll(data)
        notifyDataSetChanged()
    }

    fun clearData(){
        fund.clear()
    }

    inner class FundHolder(private val binding: ItemFundLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(fund: Fund) {
            binding.tvFundName.text = fund.thailandFundCode
            binding.tvNav.text = String.format("nav: %.2f", fund.nav)
            binding.tvNavReturn.text = String.format("nav return: %.2f", fund.navReturn)

            val updateDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(fund.navDate?:"")
            val format = DateFormat.format("dd/MMM/yyyy", updateDate)
            binding.tvUpdateDate.text = format
        }
    }

}