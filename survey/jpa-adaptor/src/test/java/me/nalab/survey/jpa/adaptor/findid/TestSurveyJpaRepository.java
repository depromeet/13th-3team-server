package me.nalab.survey.jpa.adaptor.findid;

import org.springframework.data.jpa.repository.JpaRepository;

import me.nalab.core.data.survey.SurveyEntity;

public interface TestSurveyJpaRepository extends JpaRepository<SurveyEntity, Long> {
}