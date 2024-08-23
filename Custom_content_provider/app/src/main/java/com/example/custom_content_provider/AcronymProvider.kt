package com.example.custom_content_provider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class AcronymProvider : ContentProvider() {
    companion object{
        val PROVIDER_NAME = "com.example.custom_content_provider/Acronymprovider"
        val URL = "content://$PROVIDER_NAME/actable"
        val CONTENT_URI = Uri.parse(URL)

        val _ID = "_id"
        val NAME = "NAME"
        val MEANING = "MEANING"
    }
    lateinit var db : SQLiteDatabase
    override fun onCreate(): Boolean {
        var helper = MyDBHelper(context!!)
        db = helper.writableDatabase
        return db != null
    }

    override fun query(
        p0: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_val: Array<out String>?,
        order: String?
    ): Cursor? {
        return db.query("actable",cols,condition,condition_val,null, null,order)
    }

    override fun getType(p0: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.actable"
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("actable",null,cv)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        var count = db.delete("actable",p1,p2)
        return count
    }

    override fun update(p0: Uri, cv: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        var count = db.update("actable",cv,p2,p3)
        return count
    }
}