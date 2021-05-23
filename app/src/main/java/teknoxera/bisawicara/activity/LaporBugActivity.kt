package teknoxera.bisawicara.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lapor_bug.*
import teknoxera.bisawicara.databinding.ActivityLaporBugBinding

class LaporBugActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaporBugBinding

    private companion object {
        private const val base_url = "https://wa.me/6287700535264?text="
        private const val temp_text =
            "Saya%20ingin%20melaporkan%20bug%20pada%20bagian%20berikut: %0A"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaporBugBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_send.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("${base_url}${temp_text}${input_bug.text}")
            )
            startActivity(intent)
        }
    }
}