package com.cashflow.home.bottomsheet.selectmovement.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cashflow.utils.movements.TypesMovements
import com.cashflow.R
import com.cashflow.databinding.ItemTypeMovementBinding

class TypeMovementsAdapter(val context: Context) :
    ListAdapter<TypesMovements, TypeMovementsAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val positionItem = MutableLiveData<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_type_movement,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        positionItem.value = position
    }

    inner class ViewHolder(
        val binding: ItemTypeMovementBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(typeMovement: TypesMovements) {
            with(binding) {
                this.nameMovement.text = typeMovement.nameMovement
                this.iconMovement.setBackgroundResource(typeMovement.icon)
                this.iconMovement.setColorFilter(ContextCompat.getColor(context, typeMovement.color), android.graphics.PorterDuff.Mode.MULTIPLY);
                this.iconMovement.backgroundTintList =
                    ColorStateList.valueOf(context.getColor(typeMovement.color))
                executePendingBindings()
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TypesMovements>() {
            override fun areItemsTheSame(
                oldItem: TypesMovements,
                newItem: TypesMovements
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: TypesMovements,
                newItem: TypesMovements
            ): Boolean = oldItem == newItem
        }
    }
}
