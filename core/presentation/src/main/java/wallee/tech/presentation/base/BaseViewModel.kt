package wallee.tech.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import wallee.tech.presentation.REPLAY_CACHE_0


abstract class BaseIntentViewModel<State, Intent>(
    initialState: State,
    replayCache: Int = REPLAY_CACHE_0,
) : ViewModel() {

    protected val _viewState = MutableStateFlow(initialState)
    val viewState = _viewState.asStateFlow()

    abstract fun handleIntent(intent: Intent)

    protected inline fun updateState(state: State.() -> State) {
        _viewState.update(state)
    }
}
