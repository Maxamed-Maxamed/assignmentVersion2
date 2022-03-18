package org.wit.dogadoptioncentre.models

interface AdoptionStore {
    fun findAll() : List<AdoptionModel>
    fun findById(id:Long) : AdoptionModel?
    fun create(create_adoption : AdoptionModel)



}