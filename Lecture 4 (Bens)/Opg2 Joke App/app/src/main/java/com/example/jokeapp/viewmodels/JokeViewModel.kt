package com.example.jokeapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jokeapp.models.Joke
import com.example.jokeapp.repository.JokeRepository

class JokeViewModel : ViewModel() {

    private val jokeRepository: JokeRepository = JokeRepository()
    private val _joke = MutableLiveData<Joke>()

    val joke: LiveData<Joke>
        get() = _joke

    fun randomJoke() {
        _joke.value = jokeRepository.fetchRandomJoke()
    }
}