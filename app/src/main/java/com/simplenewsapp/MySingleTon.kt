package com.simplenewsapp

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MySingleTon constructor(context: Context) {

    companion object {
        @Volatile
        private var INTANCE: MySingleTon? = null
        fun getInstance(context: MainActivity) = INTANCE ?: synchronized(this)
        {
            INTANCE ?: MySingleTon(context).also {

                INTANCE = it
            }
        }
    }

    // instantiate Request Queue

    private val requestQueue: RequestQueue by lazy {


        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)

    }
}