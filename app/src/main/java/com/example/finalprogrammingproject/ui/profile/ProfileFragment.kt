package com.example.finalprogrammingproject.ui.profile

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.finalprogrammingproject.databinding.FragmentProfileBinding
import androidmads.library.qrgenearator.QRGEncoder

import android.graphics.Bitmap

import android.widget.Button


import com.google.zxing.WriterException

import androidmads.library.qrgenearator.QRGContents

import android.graphics.Point

import android.view.Display

import android.content.Context.WINDOW_SERVICE

import androidx.core.content.ContextCompat.getSystemService

import android.view.WindowManager

import android.widget.Toast

import android.text.TextUtils

import androidx.core.content.ContextCompat
import com.example.finalprogrammingproject.MainActivity

import android.R

import android.Manifest.permission.CAMERA
import android.Manifest.permission.VIBRATE
import android.text.Editable
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.json.JSONObject


private const val REQUEST_PHOTO = 2

class ProfileFragment : Fragment() {

    private lateinit var profilePicture: ImageView
    private lateinit var text_profile: EditText
    private lateinit var textName: EditText
    private lateinit var textEmail: EditText
    private lateinit var textMajor: EditText
    private lateinit var textBirthday: EditText
    private lateinit var description: EditText
    private lateinit var nameTitle: TextView
    private lateinit var emailTitle: TextView
    private lateinit var majorTitle: TextView
    private lateinit var birthdayTitle: TextView
    private lateinit var photoUri: Uri
    private lateinit var textGender: EditText
    private lateinit var textAge:EditText


    private lateinit var dashboardViewModel:ProfileViewModel
    private var _binding: FragmentProfileBinding? = null
    private var qrCodeIV: ImageView? = null
    private var dataEdt: EditText? = null
    private var generateQrBtn: Button? = null
    var bitmap: Bitmap? = null
    var qrgEncoder: QRGEncoder? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        textName = binding.textName
        textBirthday = binding.textBirthday
        textEmail = binding.textEmail
        textMajor = binding.textMajor
        text_profile = binding.profileAccountName
        textGender = binding.textGender
        textAge = binding.textAge

/**
        profilePicture = binding.profilePicture
        profilePicture.apply{
            val packageManager: PackageManager = requireActivity().packageManager

            val captureImage = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val resolvedActivity: ResolveInfo? =
                packageManager.resolveActivity(captureImage, PackageManager.MATCH_DEFAULT_ONLY)

            Log.d(TAG, "${resolvedActivity} is null")
            if (resolvedActivity == null){
                isEnabled = false
            }

            setOnClickListener{
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)

                val cameraActivities: List<ResolveInfo> =
                    packageManager.queryIntentActivities(captureImage, PackageManager.MATCH_DEFAULT_ONLY)
                for(cameraActivity in cameraActivities){
                    requireActivity().grantUriPermission(cameraActivity.activityInfo.packageName, photoUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                }
                startActivityForResult(captureImage, REQUEST_PHOTO)
            }
        }*/

        return root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        var name:String
        var birthday:String
        var email:String
        var major:String
        var gender:String
        var age:String

        val db = Firebase.firestore
        val user001 = db.collection("users").document("001")
        user001.get().addOnSuccessListener { document ->
            name = document.get("Name").toString()
            textName.setText(name)
            text_profile.setText(name)

            birthday = document.get("Birthday").toString()
            textBirthday.setText(birthday)

            email = document.get("Email").toString()
            textEmail.setText(email)

            major = document.get("Major").toString()
            textMajor.setText(major)

            gender = document.get("Gender").toString()
            textGender.setText(gender)

            age = document.get("Age").toString()
            textAge.setText(age)
        }

         /** //code for working with qr code creater
        // initializing all variables.
        qrCodeIV = view?.findViewById(R.id.idIVQrcode)
        dataEdt = view?.findViewById(R.id.idEdt)
        generateQrBtn = view?.findViewById(R.id.idBtnGenerateQR)

        // initializing onclick listener for button.
        generateQrBtn!!.setOnClickListener {
            if (TextUtils.isEmpty(dataEdt!!.text.toString())) {

                // if the edittext inputs are empty then execute
                // this method showing a toast message.
                Toast.makeText(
                    context,
                    "Enter some text to generate QR Code",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                // below line is for getting
                // the windowmanager service.
                val manager =
                    activity?.getSystemService(WINDOW_SERVICE) as WindowManager

                // initializing a variable for default display.
                val display = manager.defaultDisplay

                // creating a variable for point which
                // is to be displayed in QR Code.
                val point = Point()
                display.getSize(point)

                // getting width and
                // height of a point
                val width = point.x
                val height = point.y

                // generating dimension from width and height.
                var dimen = if (width < height) width else height
                dimen = dimen * 3 / 4

                // setting this dimensions inside our qr code
                // encoder to generate our qr code.
                qrgEncoder =
                    QRGEncoder(dataEdt!!.text.toString(), null, QRGContents.Type.TEXT, dimen)
                try {
                    // getting our qrcode in the form of bitmap.
                    bitmap = qrgEncoder!!.encodeAsBitmap()
                    // the bitmap is set inside our image
                    // view using .setimagebitmap method.
                    qrCodeIV!!.setImageBitmap(bitmap)
                } catch (e: WriterException) {
                    // this method is called for
                    // exception handling.
                    Log.e("Tag", e.toString())
                }
            }
        }**/
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}