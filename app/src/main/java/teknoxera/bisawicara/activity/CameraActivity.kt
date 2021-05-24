package teknoxera.bisawicara.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import teknoxera.bisawicara.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}