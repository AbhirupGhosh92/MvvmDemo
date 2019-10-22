package com.happy.krutarthassignment.repository

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.happy.krutarthassignment.models.Address
import com.happy.krutarthassignment.models.Company
import com.happy.krutarthassignment.models.Geo

class CustomTypeConverter  {

    @TypeConverter
    fun fromAddressToString(address: Address) : String
    {
        val type = object : TypeToken<Address>(){}.type
        return Gson().toJson(address,type)
    }

    @TypeConverter
    fun fromStringToAddress(address : String) : Address
    {
        val type = object : TypeToken<Address>() {
        }.type
        return Gson().fromJson(address,type)
    }

    @TypeConverter
    fun fromACompanyToString(company: Company) : String
    {
        val type = object : TypeToken<Company>(){}.type
        return Gson().toJson(company,type)
    }

    @TypeConverter
    fun fromStringToCompany(company : String) : Company
    {
        val type = object : TypeToken<Company>() {
        }.type
        return Gson().fromJson(company,type)
    }

    @TypeConverter
    fun fromGeoToString(geo: Geo) : String
    {
        val type = object : TypeToken<Geo>(){}.type
        return Gson().toJson(geo,type)
    }

    @TypeConverter
    fun fromStringToGeo(geo : String) : Geo
    {
        val type = object : TypeToken<Geo>() {
        }.type
        return Gson().fromJson(geo,type)
    }
}