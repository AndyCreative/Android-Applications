package com.ankit.tab_layout_demo

import android.content.ContentValues
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v =  inflater.inflate(R.layout.fragment_form, container, false)

        var edname = v.findViewById<EditText>(R.id.edName)
        var edsem = v.findViewById<EditText>(R.id.edSem)
        var edcollege = v.findViewById<EditText>(R.id.edCollege)
        var edphone = v.findViewById<EditText>(R.id.edPhone)

        var helper = MyDbHelper(requireContext())
        var db = helper.writableDatabase

        var rs = db.rawQuery("SELECT * FROM COLLEGE",null)
        var cv = ContentValues()

        cv.put("NAME",edname.text.toString())
        cv.put("SEM",edsem.text.toString())
        cv.put("COLLEGE",edcollege.text.toString())
        cv.put("PHONE",edphone.text.toString())
        db.insert("COLLEGE",null,cv)
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FormFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FormFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}