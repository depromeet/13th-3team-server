package me.nalab.survey.web.adaptor.findfeedback.response.survey;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class AbstractSurveyResponse {

	@JsonProperty("question_id")
	private final Long questionId;
	private final Integer order;
	private final String type;
	private final String title;

}