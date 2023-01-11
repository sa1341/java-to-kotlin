import java.time.Duration
import java.util.*

object Legs {

    lateinit var plannedDuration: Duration

    fun setDuration(duration: Duration) {
        this.plannedDuration = duration
    }

    @JvmStatic
    fun findLongestLegOver(
        legs: List<Legs>,
        duration: Duration
    ): Optional<Legs> {

        var result: Legs? = null
        for (leg in legs) {
            if (isLongerThan(leg, duration))
                if (result == null ||
                        isLongerThan(leg, result.plannedDuration))
                    result = leg
        }

        return Optional.ofNullable(result)
    }

    private fun isLongerThan(leg: Legs, duration: Duration): Boolean {
        return leg.plannedDuration.compareTo(duration) > 0
    }
}