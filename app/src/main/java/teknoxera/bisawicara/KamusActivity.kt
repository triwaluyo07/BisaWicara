package teknoxera.bisawicara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import teknoxera.bisawicara.databinding.ActivityKamusBinding
import teknoxera.bisawicara.databinding.ActivityMainBinding

class KamusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKamusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKamusBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}