package me.nalab.survey.jpa.adaptor.authorization;

import org.springframework.data.jpa.repository.JpaRepository;

import me.nalab.core.data.feedback.FeedbackEntity;

public interface TestFeedbackJpaRepository extends JpaRepository<FeedbackEntity, Long> {
}
