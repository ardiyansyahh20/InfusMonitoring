package com.ardi.infusmonitoring.Interface

import com.ardi.infusmonitoring.ApiRepository.ApiRepository
import com.ardi.infusmonitoring.Entity.Infuse
import com.ardi.infusmonitoring.Entity.Status
import com.google.gson.Gson

interface InfuseView {
  fun setDataInfuse(list:List<Status>)
  fun getDataInfuse(list:List<Infuse>)
}