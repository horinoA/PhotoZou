package com.photozou.test.photozou

/**
 * Created by horinoA on 2016/04/27.
 */
data class mainSerchPhotoZo(
    val stat:String,
    val info:Info
)

data class Info(
    val photo_num:Int,
    val Photo:Array<Photo>
)

data class Photo(
    val photo_id:Int,
    val user_id:Int,
    val album_id:Int,
    val photo_title:String,
    val favorite_num:Int,
    val comment_num:Int,
    val view_num :Int,
    val copyright:String,
    val copyright_commercial:String,
    val copyright_modifications:String,
    val original_height:Int,
    val original_width:Int,
    val geo:geo,
    val date:String,
    val regist_time:String,
    val url:String,
    val image_url:String,
    val original_image_url:String,
    val thumbnail_image_url:String,
    val medium_tag: String,
    val large_tag:String
)

data class geo(val latitude:Double, val longitude:Double)