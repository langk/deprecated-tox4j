package im.tox.tox4j.core.callbacks

import im.tox.tox4j.testing.{WrappedByteArray, WrappedShortArray}

import scala.language.implicitConversions

object InvokeTest {

  final case class ByteArray(private val array: Array[Byte]) {
    override def equals(rhs: Any): Boolean = {
      rhs match {
        case rhs: ByteArray => this.array.deep == rhs.array.deep
        case _              => false
      }
    }

    override def toString: String = {
      this.array.deep.toString()
    }

    override def hashCode: Int = {
      this.array.deep.hashCode()
    }
  }

  implicit def wrapByteArray(array: Array[Byte]): ByteArray = {
    if (array == null) {
      null
    } else {
      ByteArray(array)
    }
  }

  implicit def reWrapByteArray(array: WrappedByteArray): ByteArray = {
    if (array == null) {
      null
    } else {
      ByteArray(array.array)
    }
  }

  final case class ShortArray(private val array: Array[Short]) {
    override def equals(rhs: Any): Boolean = {
      rhs match {
        case rhs: ShortArray => this.array.deep == rhs.array.deep
        case _               => false
      }
    }

    override def toString: String = {
      this.array.deep.toString()
    }

    override def hashCode: Int = {
      this.array.deep.hashCode()
    }
  }

  implicit def wrapShortArray(array: Array[Short]): ShortArray = {
    if (array == null) {
      null
    } else {
      ShortArray(array)
    }
  }

  implicit def reWrapShortArray(array: WrappedShortArray): ShortArray = {
    if (array == null) {
      null
    } else {
      ShortArray(array.array)
    }
  }

}
