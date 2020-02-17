package com.example.proyectofragments.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Clase auxiliar para proporcionar contenido de muestra para interfaces de usuario creadas por
 * Asistentes de plantillas de Android.
 *
 */
object DummyContent {

    /**
     * Una matriz de elementos de muestra (ficticios).
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * Un mapa de elementos de muestra (ficticios), por ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 25

    init {
        addItem(crearObjeto(0))
        addItem(crearPlanos(1))
        addItem(crearLista(2))

    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun crearObjeto(position: Int): DummyItem{
        return DummyItem(position.toString(), "Objetos", makeDetails(position))
    }

    private fun crearPlanos(position: Int): DummyItem{
        return DummyItem(position.toString(), "Planos", makeDetails(position))
    }

    private fun crearLista(position: Int): DummyItem{
        return DummyItem(position.toString(), "Lista", makeDetails(position))
    }
    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Detalles sobre el objeto: ").append(position)
        when(position) {
            0 -> builder.append("\nLos objetos estaran disponibles en un futuro")
            1 -> builder.append("\nLos planos estaran disponibles en un futuro")
            2 -> builder.append("\nLas listas estaran disponibles en un futuro")
        }
        return builder.toString()
    }

    /**
    * Un artículo ficticio que representa una pieza de contenido.
    */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
