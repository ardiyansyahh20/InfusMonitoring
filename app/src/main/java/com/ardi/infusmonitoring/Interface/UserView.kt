package com.ardi.infusmonitoring.Interface

import com.ardi.infusmonitoring.Entity.User

interface UserView {
    fun showData(listUser: List<User>)
}