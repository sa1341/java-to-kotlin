import java.math.BigDecimal
import java.util.*

/**
 * data 클래스로 변경하면 copy 메서드에 따라 비공개 데이터 클래스 생성자가 노출됨.
 * 프로퍼티 사이에 불변 조건을 유지해야 하는 값 타입을 데이터 클래스를 사용해 정의하면 안됩니다.
 */
class Money private constructor(
    val amount: BigDecimal,
    val currency: Currency
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        if (amount != other.amount) return false
        if (currency != other.currency) return false

        return true
    }

    override fun hashCode(): Int {
        var result = amount.hashCode()
        result = 31 * result + currency.hashCode()
        return result
    }

    override fun toString(): String {
        return "Money(amount=$amount, currency=$currency)"
    }

    fun add(that: Money): Money {
        require(currency == that.currency) {
            "cannot add Money values of different currency"
        }

        return Money(amount.add(that.amount), currency)
    }

    companion object {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency): Money {
            return Money(
                amount.setScale(currency.defaultFractionDigits),
                currency
            )
        }
    }

}