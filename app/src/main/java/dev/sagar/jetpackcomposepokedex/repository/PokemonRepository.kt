package dev.sagar.jetpackcomposepokedex.repository

import dagger.hilt.android.scopes.ActivityScoped
import dev.sagar.jetpackcomposepokedex.data.remote.PokeApi
import dev.sagar.jetpackcomposepokedex.data.remote.responses.Pokemon
import dev.sagar.jetpackcomposepokedex.data.remote.responses.PokemonList
import dev.sagar.jetpackcomposepokedex.util.Resource
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit = limit, offset = offset)
        } catch (error: Exception) {
            return Resource.Error("An unknown error occured")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name)
        } catch (error: Exception) {
            return Resource.Error("An unknown error occured")
        }

        return Resource.Success(response)
    }

}