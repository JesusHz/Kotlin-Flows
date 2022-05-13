package com.example.kotlinflows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kotlinflows.databinding.ActivityMainBinding
import com.example.kotlinflows.ui.viewmodel.ApiViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var vBinding: ActivityMainBinding

    private val apiModel: ApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vBinding.root)

        apiModel.onCreatePokemon()
        apiModel.onCreateRickAndMorty()

        apiModel.pokemonModel.observe(this, Observer {
            vBinding.tvPokemon.text = it?.name
        })

        apiModel.rickAndMortyModel.observe(this, Observer {
            vBinding.tvRickAndMorty.text = it?.name
        })

        apiModel.isLoading.observe(this, Observer {
            vBinding.progressCircular.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        vBinding.btnGet.setOnClickListener {
            apiModel.pokemonRandom()
            apiModel.rickAndMortyRandom()
        }
    }
}