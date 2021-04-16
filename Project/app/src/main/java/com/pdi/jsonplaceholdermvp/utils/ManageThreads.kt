package com.pdi.jsonplaceholdermvp.utils

import io.reactivex.Scheduler

class ManageThreads(
    var main: Scheduler,
    var io: Scheduler
)