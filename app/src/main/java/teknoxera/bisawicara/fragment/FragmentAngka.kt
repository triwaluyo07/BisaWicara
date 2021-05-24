package teknoxera.bisawicara.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import teknoxera.bisawicara.ItemCallback
import teknoxera.bisawicara.adapter.KamusAdapter
import teknoxera.bisawicara.data.KamusEntity
import teknoxera.bisawicara.viewmodel.MainViewModel
import teknoxera.bisawicara.databinding.FragmentAngkaBinding


class FragmentAngka : Fragment(), ItemCallback {
    private lateinit var binding: FragmentAngkaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        //inflate the layout for this fragment
        binding = FragmentAngkaBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null)
        {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
            val data = viewModel.getListAngka()

            val adapter = KamusAdapter(this)
            adapter.setData(data)

            with(binding.rvAngka){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onItemClicked(data: KamusEntity){
        Toast.makeText(activity, "Angka "+data.description,Toast.LENGTH_SHORT).show()
    }

}