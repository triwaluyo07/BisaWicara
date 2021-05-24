package teknoxera.bisawicara.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import teknoxera.bisawicara.R

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation
    private lateinit var logo: ImageView
    private lateinit var txtLogo: TextView

    companion object {
        private const val delay: Long = 2000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Animation
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        //Hooks
        logo = findViewById(R.id.logo)
        txtLogo = findViewById(R.id.txtGithubUser)

        logo.animation = topAnimation
        txtLogo.animation = bottomAnimation

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(
                    Intent(
                        this@SplashScreenActivity,
                        MainActivity::class.java
                    )
                )
                finish()
            },
            delay
        )

    }
}