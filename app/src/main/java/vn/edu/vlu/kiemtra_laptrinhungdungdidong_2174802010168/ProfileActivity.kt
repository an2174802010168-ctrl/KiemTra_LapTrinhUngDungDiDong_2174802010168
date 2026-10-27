package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2174802010168

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        btnLogout.setOnClickListener { finish() }

        // Dữ liệu mẫu (>= 5 phần tử)
        val subjects = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            subjects
        )
        lvSubjects.adapter = adapter

        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, subjects[position], Toast.LENGTH_SHORT).show()
        }
    }
}