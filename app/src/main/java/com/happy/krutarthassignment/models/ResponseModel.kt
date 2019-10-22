package com.happy.krutarthassignment.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ResponseModel")
data class ResponseModel(
	@ColumnInfo(name = "website") @field:SerializedName("website")
	val website: String? = null,

	@ColumnInfo(name = "address") @field:SerializedName("address")
	val address: Address? = null,

	@ColumnInfo(name = "phone") @field:SerializedName("phone")
	val phone: String? = null,

	@ColumnInfo(name = "name") @field:SerializedName("name")
	val name: String? = null,

	@ColumnInfo(name = "company") @field:SerializedName("company")
	val company: Company? = null,

	@PrimaryKey @ColumnInfo(name = "id") @field:SerializedName("id")
	val id: Int? = null,

	@ColumnInfo(name = "email") @field:SerializedName("email")
	val email: String? = null,

	@ColumnInfo(name = "username") @field:SerializedName("username")
	val username: String? = null,

	@ColumnInfo(name = "favourite") @field:SerializedName("favourite")
	val favourite: Boolean = false
)