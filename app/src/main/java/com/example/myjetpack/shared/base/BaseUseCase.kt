package com.example.myjetpack.shared.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<in P, R> where P : Any {

    abstract suspend fun run(params: P): Result<R>

    open operator fun invoke(
        scope: CoroutineScope,
        params: P,
        result: MutableLiveData<Result<R>>,
        dispatcher: CoroutineContext = Dispatchers.Main
    ) {
        scope.launch {
            withContext(dispatcher) {
                result.postValue(run(params))
            }
        }
    }

    open operator fun invoke(
        scope: CoroutineScope,
        params: P,
        dispatcher: CoroutineContext = Dispatchers.Main
    ): LiveData<Result<R>> {
        val result = MutableLiveData<Result<R>>()
        this(scope, params, result, dispatcher)
        return result
    }

    open suspend fun executeNow(params: P): Result<R> = run(params)
}
