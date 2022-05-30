package com.vas.feature_main_screen.presentation

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vas.core.utils.Resource
import com.vas.feature_main_screen.domain.model.CatModel
import com.vas.feature_main_screen.domain.useCase.GetMainUseCase
import com.vas.feature_main_screen.domain.useCase.PostLikeUseCase
import kotlinx.coroutines.*

class MainViewModel(private val getMainUseCase: GetMainUseCase,
                    private val postLikeUseCase: PostLikeUseCase) : ViewModel() {

    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    private var viewModelJob = Job()
    private val ioScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val catListData: LiveData<PagingData<CatModel>> = getMainUseCase.execute().cachedIn(viewModelScope)

    fun getMain() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getMainUseCase.execute().cachedIn(viewModelScope)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun postLike(id: String){
        ioScope.launch {
            _message.value = postLikeUseCaseExecuting(id)
        }
    }

    private suspend fun postLikeUseCaseExecuting(id: String): String{
        return withContext(Dispatchers.IO){
            postLikeUseCase.execute(id)
        }
    }

}