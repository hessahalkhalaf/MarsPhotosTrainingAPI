package com.example.android.marsphotos

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.network.MarsPhoto
import com.example.android.marsphotos.overview.MarsApiStatus
import com.example.android.marsphotos.overview.PhotoGridAdapter




@BindingAdapter("listData") //("attribute")
fun bindRecyclerView(recyclerViewXX : RecyclerView ,dataXX :List<MarsPhoto>?){

    // as (name adapter)
    val adapter = recyclerViewXX.adapter as PhotoGridAdapter
    // coll the variable
    adapter.submitList(dataXX)
}



//parameters function it's ImageView and String
@BindingAdapter("imageUrl")
fun bindingImage(imgViewBA :ImageView, imgUrlBA :String?){

    imgUrlBA?.let{
        //declaration this variable convert the URL string to a Uri object using the toUri() method
        val imgUriV = imgUrlBA.toUri().buildUpon().scheme("https").build()

        //use the (load(){} from Coil) image from the imgUri object into the imgView
        imgViewBA.load(imgUriV){

            //Add a trailing lambda as follows(( loading and error images))
            placeholder(R.drawable.loading_animation) // loading
            error(R.drawable.ic_broken_image) // error

        }
    }
}


@BindingAdapter("marsApiStatusBA")
fun bindStatus(statusImageView11: ImageView, statusBA: MarsApiStatus?) {

    when (statusBA) {

        MarsApiStatus.LOADING -> {
            statusImageView11.visibility = View.VISIBLE
            statusImageView11.setImageResource(R.drawable.loading_animation)
        }
         MarsApiStatus.ERROR ->{
             statusImageView11.visibility=View.VISIBLE
             statusImageView11.setImageResource(R.drawable.ic_connection_error)
         }

        MarsApiStatus.DONE -> {
            statusImageView11.visibility = View.GONE
        }


    }
}
