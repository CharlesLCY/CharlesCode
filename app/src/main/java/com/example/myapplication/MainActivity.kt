package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable
import com.example.comm.BaseActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initView() {
        val user = User("lalala")
        KVManager.build().put("lcy", user)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, MainFragment())
        transaction.commit()
    }

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    data class User(val name: String?): Parcelable {
        constructor(parcel: Parcel) : this(parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<User> {
            override fun createFromParcel(parcel: Parcel): User {
                return User(parcel)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }
    }
}