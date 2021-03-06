package org.wit.dogadoptioncentre.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.dogadoptioncentre.R
import org.wit.dogadoptioncentre.adapters.AdoptionAdapters
import org.wit.dogadoptioncentre.databinding.FragmentReportListBinding
import org.wit.dogadoptioncentre.main.AdoptionXApp


class Report_listFragment : Fragment() {
    lateinit var app: AdoptionXApp
    private var _fragBinding: FragmentReportListBinding? = null
    private val fragBinding get() = _fragBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.app = activity?.application as AdoptionXApp
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_report_list, container, false)
        _fragBinding = FragmentReportListBinding.inflate(inflater, container, false)
        val root = fragBinding.root

        activity?.title = getString(R.string.action_adoption_report)

            fragBinding.recyclerView.setLayoutManager(LinearLayoutManager(activity))
            fragBinding.recyclerView.adapter = AdoptionAdapters(app.adoptionStore.findAll())
        return root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Report_listFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }











    /**
     * Initialize the contents of the Fragment host's standard options menu.  You
     * should place your menu items in to <var>menu</var>.  For this method
     * to be called, you must have first called [.setHasOptionsMenu].  See
     * [Activity.onCreateOptionsMenu]
     * for more information.
     *
     * @param menu The options menu in which you place your items.
     *
     * @see .setHasOptionsMenu
     *
     * @see .onPrepareOptionsMenu
     *
     * @see .onOptionsItemSelected
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_report,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     *
     * Derived classes should call through to the base class for it to
     * perform the default menu handling.
     *
     * @param item The menu item that was selected.
     *
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     *
     * @see .onCreateOptionsMenu
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}