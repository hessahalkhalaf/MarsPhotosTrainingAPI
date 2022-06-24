package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

//parameters function it's ImageView and String
@BindingAdapter("imageUrl")
fun bindingImage(imgViewBA :ImageView, imgUrlBA :String?){

    imgUrlBA?.let{
        //declaration this variable convert the URL string to a Uri object using the toUri() method
        val imgUriV = imgUrlBA.toUri().buildUpon().scheme("https").build()

        //use the (load(){} from Coil) image from the imgUri object into the imgView
        imgViewBA.load(imgUriV){
        }
    }


}