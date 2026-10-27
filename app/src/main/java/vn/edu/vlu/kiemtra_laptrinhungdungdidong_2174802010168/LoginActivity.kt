package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2174802010168

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ bằng findViewById (không dùng ViewBinding)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() && password.isEmpty() ->
                    showError("Vui lòng nhập Email và Mật khẩu!")
                email.isEmpty() ->
                    showError("Email không được để trống!")
                password.isEmpty() ->
                    showError("Mật khẩu không được để trống!")
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                    showError("Email không đúng định dạng!")
                password.length < 6 ->
                    showError("Mật khẩu phải có ít nhất 6 ký tự!")
                else -> {
                    tvStatus.setTextColor(Color.parseColor("#2E7D32"))
                    tvStatus.text = "Xác thực thành công!"

                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("EXTRA_EMAIL", email)
                    startActivity(intent)
                }
            }
        }
    }

    private fun showError(message: String) {
        tvStatus.setTextColor(Color.RED)
        tvStatus.text = message
    }
}