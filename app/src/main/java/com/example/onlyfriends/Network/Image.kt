package com.example.onlyfriends.Network

class Image (
    val image: List<String>
        ){
    fun getUrl(): String? {
        return if(image.isNotEmpty() && image.first().isNotEmpty()) {
            image.first()
        }
        else{
            null
        }
    }
}