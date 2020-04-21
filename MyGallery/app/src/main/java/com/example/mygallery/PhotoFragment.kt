package com.example.mygallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_photo.*

private const val ARG_URI = "uri"

class PhotoFragment : Fragment() {
    private var uri: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            uri = it.getString(ARG_URI)
        }
    }

    // Activity가 아닌 곳에서 Layout Resource를 가지고 오면 LayoutInflater 객체의 Inflate 메서드 사용
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    // View가 완성된 직후 호출되는 onViewCreated 메서드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*  imageView에 uri 경로에 있는 사진을 로딩하는 코드
        *   Glide.with(this)로 사용 준비를 하고, load() 메서드에 uri 값을 인자로 주고, 해당 이미지를 부드럽게 로딩
        *   into() 메서드로 imageView에 표시
        * */
        Glide.with(this).load(uri).into(imageView)
    }

    companion object {
        @JvmStatic
        fun newInstance(uri: String) = PhotoFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_URI, uri)
            }
        }
    }
}
