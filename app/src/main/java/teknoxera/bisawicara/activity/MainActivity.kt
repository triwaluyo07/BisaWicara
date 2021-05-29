package teknoxera.bisawicara.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import teknoxera.bisawicara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intentActivity()
    }

    private fun intentActivity()
    {
        binding.cardKamus.setOnClickListener {
            val intent = Intent(this, KamusActivity::class.java)
            startActivity(intent)
        }

        binding.cardTestskill.setOnClickListener {
            val intent = Intent(this, TestSkillActivity::class.java)
            startActivity(intent)
        }

        binding.cardAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        binding.cardLaporbug.setOnClickListener {
            val intent = Intent(this, LaporBugActivity::class.java)
            startActivity(intent)
        }
    }
}