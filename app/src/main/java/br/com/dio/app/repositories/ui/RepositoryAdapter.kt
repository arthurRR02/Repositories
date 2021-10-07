package br.com.dio.app.repositories.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.app.repositories.data.model.Repository
import br.com.dio.app.repositories.databinding.ItemRepositoryBinding
import com.bumptech.glide.Glide

class RepositoryAdapter : ListAdapter<Repository, RepositoryAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepositoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repository) {
            binding.txtRepositoryName.text = item.name
            binding.txtRepositoryDescription.text = item.description
            binding.txtRepositoryLanguage.text = item.language
            binding.favorite.text = item.stargazersCount.toString()
            binding.fork.text = item.forksCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.avatarURL).into(binding.imgOwner)
        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Repository, newItem: Repository) =
        oldItem.id == newItem.id
}