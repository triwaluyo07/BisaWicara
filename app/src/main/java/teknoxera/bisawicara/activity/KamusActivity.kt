package teknoxera.bisawicara.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import teknoxera.bisawicara.R
import teknoxera.bisawicara.adapter.SectionPagerAdapter
import teknoxera.bisawicara.databinding.ActivityKamusBinding

class KamusActivity : AppCompatActivity()
{
    companion object
    {
        private val tabTitle = intArrayOf(
            R.string.huruf, R.string.angka
        )
    }

    private lateinit var binding: ActivityKamusBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityKamusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.dictionary)

        binding.viewPager.adapter = SectionPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager)
        { tab, position ->
            tab.text = resources.getString(tabTitle[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

}