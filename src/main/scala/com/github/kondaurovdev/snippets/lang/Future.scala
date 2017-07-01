package com.github.kondaurovdev.snippets.lang

import com.github.kondaurovdev.snippets.TryHelper

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future => ScalaFuture}

trait Future {

  def waitFuture[F](f: ScalaFuture[F], sec: Int = 1)(implicit ec: ExecutionContext): Either[String, F] = {
    TryHelper.tryBlock({
      Await.result(f, sec.seconds)
    }, "can't get result of future")
  }

}

object Future extends Future
