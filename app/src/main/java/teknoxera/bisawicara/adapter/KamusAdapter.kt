package teknoxera.bisawicara.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import teknoxera.bisawicara.ItemCallback
import teknoxera.bisawicara.data.KamusEntity
import teknoxera.bisawicara.databinding.ItemRowBinding

class KamusAdapter(private val callback: ItemCallback) : RecyclerView.Adapter<KamusAdapter.ListViewHolder>() {


    private val listData = ArrayList<KamusEntity>()

    fun setData(data: List<KamusEntity>?) {
        if (data.isNullOrEmpty()) return
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemRowBinding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemRowBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: KamusEntity) {
            with(binding){
                Glide.with(itemView.context)
                    .load(data.imgPoster)
                    .into(imgPoster)

                imgKeterangan.text = data.description

                cvItemRow.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }
        }


    }
}