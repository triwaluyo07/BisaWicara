package teknoxera.bisawicara.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import teknoxera.bisawicara.fragment.FragmentAngka
import teknoxera.bisawicara.fragment.FragmentHuruf

class SectionPagerAdapter(act : AppCompatActivity) :
		FragmentStateAdapter(act)
{
	override fun createFragment(position : Int) : Fragment = when (position)
	{
		0 -> FragmentHuruf()
		1 -> FragmentAngka()
		else -> Fragment()
	}

	override fun getItemCount() : Int = 2
}