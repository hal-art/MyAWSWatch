package com.hal.myawswatch.arch.login

import com.hal.myawswatch.repository.login.LoginLDS
import com.hal.myawswatch.repository.login.LoginRDS
import com.hal.myawswatch.repository.login.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * ログイン画面のアーキテクチャ
 * */
class LoginArch {
    /**
     * ログイン情報データクラス
     * */
    data class LoginCredential(val email: String, val password: String)

    /**
     * ログインモジュール提供
     * */
    @Module
    @InstallIn(ViewModelComponent::class)
    object LoginModule {
        @Provides
        fun provideLoginLDS(): LoginLDS = LoginLDS()

        @Provides
        fun provideLoginRDS(): LoginRDS = LoginRDS()

        @Provides
        fun provideLoginRepository(
            loginLDS: LoginLDS,
            loginRDS: LoginRDS
        ): LoginRepository = LoginRepository(loginRDS, loginLDS)
    }
}