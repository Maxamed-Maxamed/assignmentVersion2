package org.wit.dogadoptioncentre.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.dogadoptioncentre.R
import org.wit.dogadoptioncentre.databinding.ViewcardAdoptionBinding
import org.wit.dogadoptioncentre.models.AdoptionModel

class AdoptionAdapters constructor(private var adoptions: List<AdoptionModel>)
    : RecyclerView.Adapter<AdoptionAdapters.MainHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val ad_binding = ViewcardAdoptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return MainHolder(ad_binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val adopt = adoptions[holder.adapterPosition]
        holder.bind(adopt)
    }

    override fun getItemCount(): Int=adoptions.size

   inner class MainHolder(val binding: ViewcardAdoptionBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(adoptionModel: AdoptionModel){

            binding.nameOfPet1.text = adoptionModel.dogName
            binding.nameOfBreed2.text = adoptionModel.dogBreed
            binding.nameOfLocation3.text =adoptionModel.dogLocation
            binding.ratingBar.rating = adoptionModel.ratingbar
            binding.imageIcon.setImageResource(R.mipmap.ic_launcher_round)


        }

    }


}