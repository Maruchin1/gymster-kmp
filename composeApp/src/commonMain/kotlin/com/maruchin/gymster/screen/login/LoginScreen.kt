package com.maruchin.gymster.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.session.model.LoginRequest
import com.maruchin.gymster.screen.login.component.LoginForm

@Composable
internal fun LoginScreen(state: LoginUiState, onLogin: (LoginRequest) -> Unit) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Text(
                text = "Gymster KMP",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .padding(top = 128.dp)
            )
            LoginForm(
                invalidCredentials = state.result == LoginResult.INVALID_CREDENTIALS,
                isSubmitting = state.isSubmitting,
                onSubmit = onLogin,
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}
