package com.hal.myawswatch.repository.login

import com.hal.myawswatch.arch.login.LoginArch
import javax.inject.Inject

/**
 * ログイン画面のリポジトリクラス
 *
 * @param loginRDS ログイン画面のリモートデータソースクラス
 * @param loginLDS ログイン画面のローカルデータソースクラス
 * */
class LoginRepository @Inject constructor(
    private val loginRDS: LoginRDS,
    private val loginLDS: LoginLDS
) {

    /**
     * ログイン情報を設定する
     *
     * @param email メールアドレス
     * @param password パスワード
     * */
    fun setLoginCredentials(email: String, password: String) {
        loginLDS.setLoginCredentials(email, password)
    }

    /**
     * ログイン情報を取得する
     *
     * @return ログイン情報
     * */
    fun getLoginCredentials(): LoginArch.LoginCredential {
        return loginLDS.getLoginCredentials()
    }
}