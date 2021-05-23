package teknoxera.bisawicara.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lapor_bug.*
import teknoxera.bisawicara.R
import teknoxera.bisawicara.databinding.ActivityLaporBugBinding

class LaporBugActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLaporBugBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaporBugBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_send.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://wa.me/6287700535264?text=Saya%20ingin%20melaporkan%20bug%20pada%20bagian%20berikut:"))
            startActivity(intent)
        }
    }
}