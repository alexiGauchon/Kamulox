package com.example.maine.k_moulox

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_cardview.*
import org.intellij.lang.annotations.Language


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentCardview.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FragmentCardview.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FragmentCardview : Fragment() {
    var items = Array<AfficherKmoulox>(5) { AfficherKmoulox() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_cardview, container, false)



        // Return the fragment view/layout
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.title = "Cardview"
        seedItems()

        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.adapter = KmouloxAdapter(items)
    }

    public fun seedItems()
    {
        val nameArray = resources.getStringArray(R.array.citationK)
        val imgArray = resources.getStringArray(R.array.src)
        for (i in 0..3)//(nameArray.size-1))
        {

        }
        for (k in 0..3){
            items[k] = AfficherKmoulox(nameArray[k], resources.getIdentifier(imgArray[k], "drawable", activity!!.packageName))
        }
    }

    private fun updateObjectList(adapter: KmouloxAdapter) {
        adapter.notifyDataSetChanged()
    }
}
