package com.cashflow.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cashflow.R
import com.cashflow.databinding.ItemMovementBinding
import com.cashflow.home.modelview.MovementUiModel
import kotlinx.android.synthetic.main.item_spending_category.view.*

class MovementsAdapter() :
    ListAdapter<MovementUiModel, MovementsAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val positionItem = MutableLiveData<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movement,
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
        val binding: ItemMovementBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(movementUiModel: MovementUiModel) {
            with(binding) {
                this.nameMovement.text = movementUiModel.name
                this.typeMovement.text = movementUiModel.typeMovement
                this.dateMovement.text = movementUiModel.date
                this.valueMovement.text = "R$${movementUiModel.value}"
                this.status.text = movementUiModel.status

                executePendingBindings()
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovementUiModel>() {
            override fun areItemsTheSame(
                oldItem: MovementUiModel,
                newItem: MovementUiModel
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: MovementUiModel,
                newItem: MovementUiModel
            ): Boolean = oldItem == newItem
        }
    }
}
