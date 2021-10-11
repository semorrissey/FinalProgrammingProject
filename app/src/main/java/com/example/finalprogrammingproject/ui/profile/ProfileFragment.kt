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
import com.example.finalprogrammingproject.R
import com.example.finalprogrammingproject.databinding.FragmentProfileBinding

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


    private lateinit var dashboardViewModel:ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

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

        val textView: TextView = binding.textProfile
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        profilePicture = view.findViewById<ImageView>(R.id.profilePicture)
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
        }
    }


}