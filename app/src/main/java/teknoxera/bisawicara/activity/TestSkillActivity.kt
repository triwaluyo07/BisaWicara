package teknoxera.bisawicara.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import teknoxera.bisawicara.ItemCallback
import teknoxera.bisawicara.R
import teknoxera.bisawicara.adapter.TestAdapter
import teknoxera.bisawicara.data.KamusEntity
import teknoxera.bisawicara.databinding.ActivityTestSkillBinding
import teknoxera.bisawicara.viewmodel.MainViewModel

class TestSkillActivity : AppCompatActivity() , ItemCallback
{
	private lateinit var binding: ActivityTestSkillBinding

	override fun onCreate(savedInstanceState : Bundle?)
	{
		super.onCreate(savedInstanceState)
		binding = ActivityTestSkillBinding.inflate(layoutInflater)
		setContentView(binding.root)

		supportActionBar?.title = getString(R.string.test)

		val viewModel = ViewModelProvider(this)
			.get(MainViewModel(application)::class.java)

		val data = viewModel.getTestHuruf()

		val adapter= TestAdapter(this)
		adapter.setData(data)

		with(binding.rvTest){
			layoutManager = GridLayoutManager(context,3, LinearLayoutManager.VERTICAL, false)
			setHasFixedSize(true)
			this.adapter = adapter
		}
	}

	override fun onItemClicked(data: KamusEntity) {
		startActivity(
			Intent(this, CameraActivity::class.java)
				.putExtra(CameraActivity.EXTRA_DATA, data.id)
				.putExtra(CameraActivity.EXTRA_TYPE, CameraActivity.TEST_HURUF)
		)
	}
}