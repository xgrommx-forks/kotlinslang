package kotlinslang.control

import java.io.Serializable


/**
 * A failed Try.
 *
 * @param <T> component type of this Failure
 * @property throwable, Throwable cause
 * @constructor Construct a Failure
 * @author Daniel Dietrich, Deny Prasetyo
 * @since 1.0.0
 */

final class Failure<out T : Any>(private val throwable: Throwable) : Try<T>, Serializable {

    override fun get(): T {
        throw throwable
    }

    override fun getCause(): Throwable {
        return throwable;
    }

    override fun isEmpty(): Boolean {
        return true
    }

    override fun isFailure(): Boolean {
        return true
    }

    override fun isSuccess(): Boolean {
        return false
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other != null && other is Failure<*> && throwable == other.throwable) return true
        return false
    }

    override fun hashCode(): Int {
        return throwable.hashCode()
    }

    override fun toString(): String {
        return "Failure($throwable)"
    }
}