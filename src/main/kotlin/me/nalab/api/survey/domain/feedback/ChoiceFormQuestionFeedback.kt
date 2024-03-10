package me.nalab.api.survey.domain.feedback

import javax.persistence.*

@Entity
class ChoiceFormQuestionFeedback(
    id: Long,
    formQuestionId: Long,
    isRead: Boolean = false,
    feedback: Feedback,

    @ElementCollection
    @Column(name = "selects")
    @CollectionTable(name = "selects", joinColumns = [JoinColumn(name = "form_feedback_id")])
    private val selectedChoiceIds: MutableSet<Long>,
) : FormQuestionFeedbackable(id, formQuestionId, isRead, Bookmark.impossible(), feedback)
