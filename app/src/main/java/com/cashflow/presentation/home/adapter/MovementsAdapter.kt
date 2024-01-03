package com.cashflow.com.cashflow.presentation.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cashflow.R
import com.cashflow.databinding.ItemMovementBinding
import com.cashflow.com.cashflow.domain.model.MovementModel


class MovementsAdapter() :
    ListAdapter<MovementModel, MovementsAdapter.ViewHolder>(DIFF_CALLBACK) {

    private val positionItem = MutableLiveData<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movement,
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        positionItem.value = position
    }

    inner class ViewHolder(
        val binding: ItemMovementBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun bind(movementUiModel: MovementModel) {
            with(binding) {
                //this.iconMovement.
                this.iconMovement.setImageResource(movementUiModel.category.icon)
                this.nameMovement.text = movementUiModel.category.nameCategory
                this.typeMovement.text = movementUiModel.category.category.group
                this.dateMovement.text = movementUiModel.date

                this.status.text = movementUiModel.status?.status

                this.valueMovement.text = "R$${movementUiModel.value}"
                if (movementUiModel.value >= 0) {
                    this.valueMovement.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.green_500
                        )
                    )
                } else {
                    this.valueMovement.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.red_500
                        )
                    )
                }

                executePendingBindings()
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovementModel>() {
            override fun areItemsTheSame(
                oldItem: MovementModel,
                newItem: MovementModel,
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: MovementModel,
                newItem: MovementModel,
            ): Boolean = oldItem == newItem
        }
    }
}