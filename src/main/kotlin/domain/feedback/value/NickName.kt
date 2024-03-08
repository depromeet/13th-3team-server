package domain.feedback.value

import javax.persistence.Embeddable

@Embeddable
class NickName(
    val value: String
) {

    companion object {
        private const val FIRST_NAME = "A"
        fun firstNickName(): domain.feedback.value.NickName =
            domain.feedback.value.NickName(domain.feedback.value.NickName.Companion.FIRST_NAME)

        fun nextNickName(lastName: String): domain.feedback.value.NickName {
            for (i in lastName.length - 1 downTo 0) {
                if (lastName[i] != 'Z') {
                    return domain.feedback.value.NickName(
                        lastName.substring(0, i) + (lastName[i].code + 1).toChar() + "A".repeat(
                            lastName.length - (i + 1)
                        )
                    )
                }
            }
            return domain.feedback.value.NickName("A".repeat(Math.max(0, lastName.length + 1)))
        }
    }
}
