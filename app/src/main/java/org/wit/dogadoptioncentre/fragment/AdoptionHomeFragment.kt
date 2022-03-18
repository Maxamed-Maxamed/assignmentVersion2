package org.wit.dogadoptioncentre.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.wit.dogadoptioncentre.R
import org.wit.dogadoptioncentre.databinding.FragmentAdoptionHomeBinding
import org.wit.dogadoptioncentre.main.AdoptionXApp
import org.wit.dogadoptioncentre.models.AdoptionModel
import timber.log.Timber


class AdoptionHomeFragment : Fragment() {
    lateinit var app: AdoptionXApp
    private var _fragBinding: FragmentAdoptionHomeBinding? =null
    private val fragBinding get() = _fragBinding!!
    var adoption_models = AdoptionModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as AdoptionXApp
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragBinding = FragmentAdoptionHomeBinding.inflate(inflater, container,false)
        val root = fragBinding.root
        activity?.title = getString(R.string.action_adoption_home)
    /*    activity?.actionBar?.title ?:  R.string.action_adoption_home.toString()*/
        /*activity?.setTitle("hello welcome to mypages")*/

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_adoption_home, container, false)
            setBtnListener(fragBinding)
            return root;
    }


    fun setBtnListener(layout:FragmentAdoptionHomeBinding ){

        layout.adoptionButton.setOnClickListener {

            adoption_models.dogName = fragBinding.nameOfPet1.text.toString()
            adoption_models.dogBreed = fragBinding.nameOfBreed2.text.toString()
            adoption_models.dogLocation = fragBinding.nameOfLocation3.text.toString()
            adoption_models.ratingbar = fragBinding.ratingBar.rating


            if (adoption_models.dogName.isEmpty()|| adoption_models.dogBreed.isEmpty() || adoption_models.dogLocation.isEmpty() || adoption_models.ratingbar.isInfinite()){

                Toast.makeText(context, R.string.text_field, Toast.LENGTH_SHORT).show()
            }
            adoption_models.dogName = fragBinding.nameOfPet1.text.toString()
            adoption_models.dogBreed = fragBinding.nameOfBreed2.text.toString()
            adoption_models.dogLocation = fragBinding.nameOfLocation3.text.toString()
            adoption_models.ratingbar = fragBinding.ratingBar.rating
            app.adoptionStore.create(AdoptionModel(id = adoption_models.id, dogName = adoption_models.dogName, dogBreed = adoption_models.dogBreed, dogLocation = adoption_models.dogLocation, ratingbar = adoption_models.ratingbar))
            Timber.i("it has been add up")
        }


    }





    companion object {
        @JvmStatic
        fun newInstance() =
            AdoptionHomeFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragBinding = null
    }
    override fun onResume() {
        super.onResume()
        app.adoptionStore.findAll().sumOf { it.id }
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
        inflater.inflate(R.menu.menu_adoption, menu)
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
      /*  return super.onOptionsItemSelected(item)*/
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)

    }
}