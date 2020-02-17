package com.example.proyectofragments

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_item_detail.*

/**
 * Una actividad que representa una sola pantalla de detalles del elemento. Esta
 * la actividad solo se usa en dispositivos de ancho estrecho. En dispositivos del tamaño de una tableta,
 * los detalles del artículo se presentan junto con una lista de artículos
 * en una [ItemListActivity].
 */
class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Remplazalo con los detalles de tu acción", Snackbar.LENGTH_LONG)
                .setAction("Acción", null).show()
        }

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState no es nulo cuando hay un estado de fragmento
        // guardado de configuraciones anteriores de esta actividad
        // (por ejemplo, al girar la pantalla de vertical a horizontal).
        // En este caso, el fragmento se volverá a agregar automáticamente
        // a su contenedor, por lo que no necesitamos agregarlo manualmente.
        // Para obtener más información, consulte la guía API Fragmentos en:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Cree el fragmento de detalle y agréguelo a la actividad.
            // usando una transacción de fragmento.
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        ItemDetailFragment.ARG_ITEM_ID,
                        intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // Esta ID representa el botón Inicio o Arriba. En el caso de esto
                // actividad, se muestra el botón Arriba. por
                // más detalles, vea el patrón de navegación en Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                navigateUpTo(Intent(this, ItemListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
