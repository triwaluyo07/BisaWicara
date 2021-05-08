package teknoxera.bisawicara

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import teknoxera.bisawicara.databinding.ActivityKamusBinding

class KamusActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityKamusBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityKamusBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initRV()
    {
        binding.apply {
            rvDict.layoutManager = GridLayoutManager(this@KamusActivity, 2)
        }
    }
}