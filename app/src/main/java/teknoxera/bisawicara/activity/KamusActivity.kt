package teknoxera.bisawicara.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import teknoxera.bisawicara.adapter.SectionPagerAdapter
import teknoxera.bisawicara.databinding.ActivityKamusBinding

class KamusActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityKamusBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityKamusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        supportActionBar?.elevation = 0f
    }

}