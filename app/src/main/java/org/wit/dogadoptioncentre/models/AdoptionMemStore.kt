package org.wit.dogadoptioncentre.models

import timber.log.Timber


var lastId = 0L
internal fun getId(): Long{
    return lastId++
}

class AdoptionMemStore : AdoptionStore {
    val adoption_Array = ArrayList<AdoptionModel>()
    override fun findAll(): List<AdoptionModel> {
        return adoption_Array
    }

    override fun findById(id: Long): AdoptionModel? {
        return adoption_Array.find { it.id == id }
    }

    override fun create(create_adoption: AdoptionModel) {

        create_adoption.id = getId()
        adoption_Array.add(create_adoption)
        logAll()

    }

  fun  logAll() {
    Timber.v("** Adoption's List **")
    adoption_Array.forEach { Timber.v("ADOPTION ${it}") }


}


}