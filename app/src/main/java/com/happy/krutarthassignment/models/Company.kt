package com.happy.krutarthassignment.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Company(

	@field:SerializedName("bs")
	val bs: String? = null,

	@field:SerializedName("catchPhrase")
	val catchPhrase: String? = null,

	@field:SerializedName("name")
	val name: String? = null
): Serializable