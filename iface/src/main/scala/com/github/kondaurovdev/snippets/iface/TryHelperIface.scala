package com.github.kondaurovdev.snippets.iface

trait TryHelperIface {

  /**
    * Wrap code block with Try
    * return Left[Throwable] if exception was thrown or Right[R] if success
    * @param block
    * @tparam R
    * @return
    */
  def tryToEither[R](block: => R): Either[Throwable, R]

  /**
    * Same as (tryToEither) but transform Throwable to String in Left
    * @param block
    * @param errPrefix
    * @tparam R
    * @tparam E
    * @return
    */
  def tryBlock[R, E <: Throwable](block: => R, errPrefix: String): Either[String, R]

}
