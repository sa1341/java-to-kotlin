data class EmailAddress(
    val localPart: String,
    val domain: String
) {

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {

            val atIndex = value.lastIndexOf("@")

            require(!(atIndex < 1 || atIndex == value.length - 1)) {
                "EmailAddress must be tow parts seperated by @"
            }

            return EmailAddress(
                localPart = value.substring(0, atIndex)
                , domain = value.substring(atIndex + 1))
        }
    }

}