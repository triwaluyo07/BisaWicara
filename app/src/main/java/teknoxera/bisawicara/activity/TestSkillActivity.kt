package teknoxera.bisawicara.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import teknoxera.bisawicara.R

class TestSkillActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState : Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_test_skill)

		supportActionBar?.title = getString(R.string.test)
	}
}