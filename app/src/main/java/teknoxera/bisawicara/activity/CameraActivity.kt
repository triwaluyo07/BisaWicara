package teknoxera.bisawicara.activity

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import teknoxera.bisawicara.data.KamusEntity
import teknoxera.bisawicara.databinding.ActivityCameraBinding
import teknoxera.bisawicara.viewmodel.MainViewModel
import java.io.File

//private lateinit var photoFile: File

class CameraActivity : AppCompatActivity() {

    companion object{
        const val FILE_NAME= "photo.jpg"
        const val REQUEST_CODE = 42
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "EXTRA_TYPE"
        const val TEST_HURUF = "TEST_HURUF"
    }

    private lateinit var binding: ActivityCameraBinding
    private lateinit var photoFile: File
    private lateinit var kamusEntity: KamusEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TEST_HURUF)) {
            id?.let {
                viewModel.setTestHurufbyId(it)
            }
            kamusEntity = viewModel.getTestHurufbyId()
        }

        binding.apply {
            imgDesc.text = kamusEntity.description
        }

        takePict()
    }

    private fun getPhotoFile(fileName: String): File {
        // Use `getExternalFilesDir` on Context to access package-specific directories.
        val storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {

//            val takenImage = data?.extras?.get("data") as Bitmap
            val takenImage = BitmapFactory.decodeFile(photoFile.absolutePath)
            binding.pictCamera.setImageBitmap(takenImage)
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }

    fun takePict(){
        binding.btnTakePict.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            photoFile = getPhotoFile(FILE_NAME)


            // takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoFile)
            val fileProvider = FileProvider.getUriForFile(this, "teknoxera.bisawicara.file_provider", photoFile)

            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)

            if (takePictureIntent.resolveActivity(this.packageManager) != null)
            {
                startActivityForResult(takePictureIntent, REQUEST_CODE)
            }
            else
            {
                Toast.makeText(this, "Unable to open camera", Toast.LENGTH_SHORT).show()
            }
        }
    }
}