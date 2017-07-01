package com.github.kondaurovdev.snippets

trait TryHelper {

  type errorPF = PartialFunction[Throwable, String]

  val handlePF: errorPF = {
    case e: Throwable => e.getMessage
  }

  def tryToEither[R](block: => R): Either[Throwable, R] = {
    scala.util.Try(block) match {
      case scala.util.Success(res) => Right(res)
      case scala.util.Failure(err) => Left(err)
    }
  }

  def tryBlock[R, E <: Throwable](block: => R, errPrefix: String = "", handle: errorPF = handlePF): Either[String, R] = {
    tryToEither(block).left.map(err => {
      var msg = err.getMessage
      if (errPrefix.nonEmpty) msg = s"$errPrefix: $msg"
      msg
    })
  }

}

object TryHelper extends TryHelper