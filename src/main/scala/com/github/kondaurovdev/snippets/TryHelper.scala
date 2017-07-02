package com.github.kondaurovdev.snippets

trait iTryHelper {

  def tryToEither[R](block: => R): Either[Throwable, R] = {
    scala.util.Try(block).toEither
  }

  def tryBlock[R, E <: Throwable](block: => R, errPrefix: String = ""): Either[String, R] = {
    tryToEither(block).left.map(err => {
      var msg = err.getMessage
      if (errPrefix.nonEmpty) msg = s"$errPrefix: $msg"
      msg
    })
  }

}

class TryHelper extends iTryHelper