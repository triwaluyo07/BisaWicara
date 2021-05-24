package teknoxera.bisawicara.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import teknoxera.bisawicara.ItemCallback
import teknoxera.bisawicara.activity.TestSkillActivity
import teknoxera.bisawicara.data.KamusEntity
import teknoxera.bisawicara.databinding.ItemGridBinding

class TestAdapter(private val callback: ItemCallback) :
    RecyclerView.Adapter<TestAdapter.GridViewHolder>() {

    private val listData = ArrayList<KamusEntity>()

    fun setData(data: List<KamusEntity>?) {
        if (data.isNullOrEmpty()) return
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val itemGridBinding = ItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(itemGridBinding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class GridViewHolder(private val binding: ItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: KamusEntity) {
            with(binding){
                Glide.with(itemView.context)
                    .load(data.imgPoster)
                    .into(imgPoster)

                imgKeterangan.text = data.description

                cvItemGrid.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }
        }

    }
}