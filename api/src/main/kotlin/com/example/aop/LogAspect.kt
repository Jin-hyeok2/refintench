package com.example.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Aspect
@Component
class LogAspect {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Pointcut("within(com.example..*)")
    private fun isApi() {}

    @Around("isApi()")
    fun loggingAspect(joinPoint: ProceedingJoinPoint): Any? {
        val stopWatch = StopWatch()
        stopWatch.start()

        val result = joinPoint.proceed()

        stopWatch.stop()
        val any = if (joinPoint.args.isEmpty()) "undefined" else joinPoint.args[0]
        log.info( "${joinPoint.signature?.name} $any ${stopWatch.lastTaskTimeMillis}")
        return result?: null
    }
}