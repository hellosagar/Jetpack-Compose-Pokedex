package dev.sagar.jetpackcomposepokedex.pokemondetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sagar.jetpackcomposepokedex.data.remote.responses.Pokemon
import dev.sagar.jetpackcomposepokedex.repository.PokemonRepository
import dev.sagar.jetpackcomposepokedex.util.Resource
import javax.inject.Inject

@HiltViewModel
class PokemDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>{
        return repository.getPokemonInfo(pokemonName)
    }

}