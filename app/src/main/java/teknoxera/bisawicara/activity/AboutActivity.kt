package teknoxera.bisawicara.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.toColorInt
import teknoxera.bisawicara.R

class AboutActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState : Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_about)

        supportActionBar?.title = getString(R.string.about_us)
	}
}