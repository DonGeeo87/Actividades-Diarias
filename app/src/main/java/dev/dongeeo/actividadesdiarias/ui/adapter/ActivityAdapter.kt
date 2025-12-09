package dev.dongeeo.actividadesdiarias.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.dongeeo.actividadesdiarias.R
import dev.dongeeo.actividadesdiarias.databinding.ItemActivityBinding
import dev.dongeeo.actividadesdiarias.model.ActivityItem

class ActivityAdapter(
    private val onToggleCompleted: (String) -> Unit
) : ListAdapter<ActivityItem, ActivityAdapter.ActivityViewHolder>(Diff) {

    object Diff : DiffUtil.ItemCallback<ActivityItem>() {
        override fun areItemsTheSame(oldItem: ActivityItem, newItem: ActivityItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ActivityItem, newItem: ActivityItem): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActivityViewHolder(binding, onToggleCompleted)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ActivityViewHolder(
        private val binding: ItemActivityBinding,
        private val onToggleCompleted: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ActivityItem) = binding.apply {
            // Configurar checkbox
            cbCompleted.isChecked = item.isCompleted
            cbCompleted.setOnClickListener {
                onToggleCompleted(item.id)
            }
            
            // Configurar texto con estilo según estado completado
            tvTitle.text = item.title
            tvDate.text = "${item.date} · ${item.time}"
            
            // Mostrar descripción solo si existe
            if (item.description.isNotBlank()) {
                tvDescription.text = item.description
                tvDescription.visibility = View.VISIBLE
            } else {
                tvDescription.visibility = View.GONE
            }
            
            // Aplicar estilo visual cuando está completado
            if (item.isCompleted) {
                tvTitle.alpha = 0.6f
                tvDate.alpha = 0.6f
                tvDescription.alpha = 0.6f
                tvTitle.paintFlags = android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                tvTitle.alpha = 1.0f
                tvDate.alpha = 1.0f
                tvDescription.alpha = 1.0f
                tvTitle.paintFlags = 0
            }
        }
    }
}

