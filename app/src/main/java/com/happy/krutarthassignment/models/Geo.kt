package com.happy.krutarthassignment.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Geo(

	@field:SerializedName("lng")
	val lng: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null
): Serializable